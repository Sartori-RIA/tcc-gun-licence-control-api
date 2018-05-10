package br.gov.pf.resource;

import br.gov.pf.model.entity.License;
import br.gov.pf.model.service.LicenseService;
import br.gov.pf.model.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/validator")
@Stateless
public class ValidatorResource {

    @Inject
    private UserService userService;
    @Inject
    private LicenseService licenseService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validLicence(License json) {
        if (json == null || json.getSerial() == null)
            Response.status(401).build();

        License license = this.licenseService.getByProperty("serial", json.getSerial());

        if (license == null)
            return Response.status(404).build();

        return Response.ok(license).build();
    }

    @Path("/find/serial/{serial}")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response verifyBySerial(@PathParam("serial") String serial) {
        License license = licenseService.getByProperty("serial", serial);

        String header =
                "<head>\n" +
                        "    <meta charset=\"utf-8\" />\n" +
                        "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css\">\n" +
                        "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js\"></script>\n" +
                        "</head>";

        String html = header;
        String bodyNotFound = "<h1 class=\"center title\">Licença não encontrata</h1>";

        if (license == null)
            return Response.status(404).entity(html + bodyNotFound).build();
        String body = "<body> " +
                "<div class=\"row\">\n" +
                "    <div class=\"col s12 m7\">\n" +
                "       <div class=\"card\">\n" +
                "           <div class=\"card-title center-align \"><strong>Portador:</strong>" + license.getUser().getName() + " </div>" +
                "               <div class=\"card-content\">\n" +
                "                   <div><p><strong>Numero de serie: </strong>" + license.getSerial() + "</p></div>\n" +
                "                   <div><p><strong>Categoria: </strong>" + license.getCategory().getDescription() + "</p> </div>\n" +
                "                   <div><p><strong>Situação: </strong>" + getStatus(license) + "</p></div>" +
                "                   <div><p><strong>Validade até: </strong>" + license.getShelfLife() + "</p></div>\n" +
                "                   <div><p><strong>CPF: </strong>" + formatCPF(license) + "</p></div>" +
                "                   <div><p><strong>RG: </strong>" + formatRG(license) + "</p></div>" +
                "                   <div><p><strong>Rua: </strong>" + license.getAddress().getStreet() + " - " + license.getAddress().getAddressNumber() + "</p></div>" +
                "                   <div><p><strong>Cidade: </strong>" + license.getAddress().getCity().getDescription() + "</p></div>\n" +
                "                   <div><p><strong>Estado: </strong>" + license.getAddress().getCity().getState().getDescription() + "</p></div>\n" +
                "                   <div><p><strong>Pais: </strong>" + license.getAddress().getCity().getState().getCountry().getDescription() + "</p>\n" +
                "               </div>" +
                "           </div>\n" +
                "       </div>\n" +
                "   </div>" +
                "</body>";

        return Response.ok(html + body).build();
    }

    private String formatRG(License license) {
        return license.getUser().getRg();
    }

    private String formatCPF(License license) {
        String cpf = license.getUser().getCpf();
        String b1 = cpf.substring(0, 3);
        String b2 = cpf.substring(3, 6);
        String b3 = cpf.substring(6, 9);
        String b4 = cpf.substring(9, 11);
        return b1 + "." + b2 + "." + b3 + "-" + b4;

    }


    private String getStatus(License license) {
        return license.getShelfLife() != null ? "DEFERIDA" : "INDEFERIDA";
    }

}
