package br.gov.pf.resource;


import br.gov.pf.model.entity.UserRole;
import br.gov.pf.model.service.UserRoleService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@Secured
@Stateless
@Path("/users-roles")
public class UserRoleResource extends AbstractResource<Long, UserRole> {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(UserRole.class));

    @Inject
    private UserRoleService service;

    public UserRoleResource() {
    }
}
