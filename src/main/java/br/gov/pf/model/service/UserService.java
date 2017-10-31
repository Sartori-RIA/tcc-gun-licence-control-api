package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.UserDAO;
import br.gov.pf.model.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by sartori on 13/07/17.
 */
@Stateless
public class UserService extends AbstractService<Long, User> {
    @Inject
    private UserDAO dao;

    @Override
    public AbstractDAO<Long, User> getDAO() {
        return this.dao;
    }
}
