package br.gov.pf.resource;

import br.gov.pf.model.entity.License;
import br.gov.pf.model.entity.User;
import br.gov.pf.model.service.LicenseService;
import br.gov.pf.model.service.UserService;
import br.gov.pf.util.UserUtil;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by sartori on 13/07/17.
 */
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
            return Response.status(401).build();
        if (entity.getCategory().getRequirement().getCriminalRecors() && user.getCriminalRecord())
            return Response.status(401).build();
        if (entity.getCategory().getRequirement().getRespondingProcess() && user.getRespondingProcess())
            return Response.status(401).build();

        return super.save(entity);
    }
}
