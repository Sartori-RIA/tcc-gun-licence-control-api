package br.gov.pf.resource;

import br.gov.pf.model.entity.UserRole;
import br.gov.pf.model.service.UserRoleService;

import javax.ws.rs.Path;

@Path("/usuarios/niveis/acessos")
public class UserRoleResource extends AbstractResource<Long, UserRole> {
    public UserRoleResource() {
        service = new UserRoleService();
    }
}
