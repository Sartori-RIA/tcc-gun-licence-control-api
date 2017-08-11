package br.gov.pf.model.service;

import br.gov.pf.model.entity.UserRole;
import br.gov.pf.model.dao.UserRoleDAO;

public class UserRoleService extends AbstractService<Long, UserRole> {
    public UserRoleService() {
        dao = new UserRoleDAO();
    }
}
