package br.gov.pf.resource;

import br.gov.pf.model.entity.User;
import br.gov.pf.model.service.UserService;
import br.gov.pf.security.Secured;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

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
}
