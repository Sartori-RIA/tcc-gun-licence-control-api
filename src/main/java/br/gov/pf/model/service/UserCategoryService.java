package br.gov.pf.model.service;

import br.gov.pf.model.UserCategory;
import br.gov.pf.model.dao.UserCategoryDAO;

public class UserCategoryService extends AbstractService<Long, UserCategory> {
    public UserCategoryService() {
        dao = new UserCategoryDAO();
    }
}
