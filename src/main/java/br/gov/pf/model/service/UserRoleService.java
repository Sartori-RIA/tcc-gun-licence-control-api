package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.entity.UserRole;
import br.gov.pf.model.dao.UserRoleDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserRoleService extends AbstractService<Long, UserRole> {
    @Inject private UserRoleDAO dao;
    @Override
    public AbstractDAO<Long, UserRole> getDAO() {
        return this.dao;
    }
}
