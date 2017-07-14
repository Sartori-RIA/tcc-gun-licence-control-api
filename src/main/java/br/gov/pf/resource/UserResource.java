package br.gov.pf.resource;

import br.gov.pf.model.User;
import br.gov.pf.model.service.UserService;
import org.apache.log4j.Logger;

import javax.ws.rs.Path;

/**
 * Created by sartori on 13/07/17.
 */
@Path("/usuarios")
public class UserResource extends AbstractResource<Integer, User> {
    private static final Logger LOGGER = Logger.getLogger(UserResource.class);

    public UserResource() {
        service = new UserService();
    }
}
