package br.gov.pf.resource;

import br.gov.pf.model.entity.License;
import br.gov.pf.model.entity.User;
import br.gov.pf.model.service.LicenseService;
import br.gov.pf.model.service.UserService;
import br.gov.pf.security.Secured;
import br.gov.pf.util.UserUtil;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sartori on 13/07/17.
 */
@Secured
@Stateless
@Path("/licenses")
public class LicenseResource extends AbstractResource<Long, License> {

    private static final Logger LOGGER = Logger.getLogger(LicenseResource.class);

    @Inject
    private LicenseService service;

    @Inject
    private UserService userService;

    public LicenseResource() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response save(License entity) {
        User user = userService.getById(entity.getUser().getId());
        Integer age = UserUtil.getAge(user.getDateOfBirth());
        if (age < entity.getCategory().getRequirement().getMinimalAge())
            return Response.status(400).build();
        if (entity.getCategory().getRequirement().getCriminalRecors() && user.getCriminalRecord())
            return Response.status(400).build();
        if (entity.getCategory().getRequirement().getRespondingProcess() && user.getRespondingProcess())
            return Response.status(400).build();

        return super.save(entity);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response update(License entity) {
        if (entity.getShelfLife() != null & entity.isStatus())
            return Response.status(400).build();
        return super.update(entity);
    }
}
