package br.gov.pf.resource;

import br.gov.pf.model.User;
import br.gov.pf.model.service.UserService;

import javax.ws.rs.Path;
import java.util.logging.Logger;

/**
 * Created by sartori on 18/03/17.
 */
@Path("/users")
public class UserResource extends AbstractResource<Long, User> {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(UserResource.class));

    public UserResource(){
        service = new UserService();
    }
}
