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

        String style = "<style>\n" +
                "    .license {\n" +
                "        background-color: greenyellow;\n" +
                "        width: 600px;\n" +
                "    }\n" +
                "\n" +
                "    .field {\n" +
                "        outline: 1px solid green;\n" +
                "        outline-offset: -4px;\n" +
                "    }\n" +
                "\n" +
                "    .field>.title {\n" +
                "        color: red;\n" +
                "    }\n" +
                "</style>";
        String html = header + style;
        String bodyNotFound = "<h1 class=\"center title\">Licença não encontrata</h1>";

        if (license == null)
            return Response.status(404).entity(html + bodyNotFound).build();

        String body = "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"license\">\n" +
                "            <header class=\"center teal darken-4 white-text\">\n" +
                "                <h4>Licença de " + license.getCategory().getDescription() + " de Arma</h4>\n" +
                "            </header>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col s12 content field\">\n" +
                "                    <div class=\"col s2 title\">Nome</div>\n" +
                "                    <div class=\"col s8\">" + license.getUser().getName() + "</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col s6 content field\">\n" +
                "                    <div class=\"col s2 title\">CPF</div>\n" +
                "                    <div class=\"col s8\">" + license.getUser().getCpf() + "</div>\n" +
                "                </div>\n" +
                "                <div class=\"col s6 content field\">\n" +
                "                    <div class=\"col s2 title\">RG</div>\n" +
                "                    <div class=\"col s8\">" + license.getUser().getRg() + "</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col s6 field\">\n" +
                "                    <div class=\"col s12 title\">Categoria</div>\n" +
                "                    <div class=\"col 12\">" + license.getCategory().getDescription() + "</div>\n" +
                "                </div>\n" +
                "                <div class=\"col s6 field\">\n" +
                "                    <div class=\"col s12 title\">Situção</div>\n" +
                "                    <div class=\"col s12\">" + getStatus(license) + "</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col s12 field\">\n" +
                "                    <div class=\"col s12 title center\">Numero de Serie</div>\n" +
                "                    <div class=\"col s12\">" + license.getSerial() + "</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col s12 field\">\n" +
                "                    <div class=\"col s2 title\">Validade</div>\n" +
                "                    <div class=\"col s8\">" + license.getShelfLife() + "</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col s12 field\">\n" +
                "                    <div class=\"col s2 title\">Rua</div>\n" +
                "                    <div class=\"col s8\">" + license.getAddress().getStreet() + " - " + license.getAddress().getAddressNumber() + "</div>\n" +
                "                </div>\n" +
                "                <div class=\"col s12 field\">\n" +
                "                    <div class=\"col s2 title\">Cidade</div>\n" +
                "                    <div class=\"col s8\">" + license.getAddress().getCity().getDescription() + "</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col s6 field\">\n" +
                "                    <div class=\"col s4 title\">Estado</div>\n" +
                "                    <div class=\"col s6\">" + license.getAddress().getCity().getState().getDescription() + "</div>\n" +
                "                </div>\n" +
                "                <div class=\"col s6 field\">\n" +
                "                    <div class=\"col s4 title\">País</div>\n" +
                "                    <div class=\"col s6\">" + license.getAddress().getCity().getState().getCountry().getDescription() + "</div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>";

        return Response.ok(html + body).build();
    }


    private String getStatus(License license) {
        return license.getShelfLife() != null ? "DEFERIDA" : "INDEFERIDA";
    }

}
