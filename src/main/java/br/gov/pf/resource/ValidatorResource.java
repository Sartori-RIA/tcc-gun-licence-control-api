package br.gov.pf.resource;

import br.gov.pf.model.entity.License;
import br.gov.pf.model.entity.User;
import br.gov.pf.model.service.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/validator")
public class ValidatorResource {

    @Inject
    private UserService userService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validLicence(License json) throws ServletException {
        if(json == null || json.getSerial() == null)
            throw new ServletException("Por favor informe uma licença");

        User user = this.userService.getByProperty("license.serial", json.getSerial());

        if (user == null)
            return Response.status(404).build();

        return Response.ok(user).build();
    }

}
