package br.gov.pf.resource;

import br.gov.pf.model.entity.License;
import br.gov.pf.model.entity.User;
import br.gov.pf.model.service.LicenseService;
import br.gov.pf.model.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

        License license = this.licenseService.getByProperty("serial",json.getSerial());

        if (license == null)
            return Response.status(404).build();

        return Response.ok(license).build();
    }

}
