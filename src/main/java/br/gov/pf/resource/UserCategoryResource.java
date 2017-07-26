package br.gov.pf.resource;

import br.gov.pf.model.UserCategory;
import br.gov.pf.model.service.UserCategoryService;

import javax.ws.rs.Path;

@Path("/usuarios/niveis/acessos")
public class UserCategoryResource extends AbstractResource<Long, UserCategory> {
    public UserCategoryResource() {
        service = new UserCategoryService();
    }
}
