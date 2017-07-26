package br.gov.pf.resource;

import br.gov.pf.model.UserCategory;
import br.gov.pf.model.service.UserCategoryService;

public class UserCategoryResource extends AbstractResource<Long, UserCategory> {
    public UserCategoryResource() {
        service = new UserCategoryService();
    }
}
