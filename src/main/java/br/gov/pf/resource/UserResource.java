package br.gov.pf.resource;

import br.gov.pf.model.entity.User;
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
@Path("/users")
public class UserResource extends AbstractResource<Long, User> {

    private static final Logger LOGGER = Logger.getLogger(UserResource.class);

    @Inject
    private UserService service;

    public UserResource() {
    }


    @GET
    @Path("/age")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Integer getAge(User user) {
        return UserUtil.getAge(user.getDateOfBirth());
    }

    @Override
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(User entity) {
        if (entity == null)
            return Response.noContent().build();

        User oldUser = service.getById(entity.getId());
        if (oldUser == null)
            return Response.status(401).build();

        if (entity.getPassword() == null)
            entity.setPassword(oldUser.getPassword());
        if ((entity.getName() == null) || (entity.getName() != oldUser.getName()))
            entity.setName(oldUser.getName());
        if ((entity.getDateOfBirth() == null) || (entity.getDateOfBirth() != oldUser.getDateOfBirth()))
            entity.setDateOfBirth(oldUser.getDateOfBirth());
        if ((entity.getCpf() == null) || (entity.getCpf() != oldUser.getCpf()))
            entity.setCpf(oldUser.getCpf());
        if ((entity.getGender() == null) || (entity.getGender() != oldUser.getGender()))
            entity.setGender(oldUser.getGender());
        try {
            service.update(entity);
            return Response.ok(entity).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
