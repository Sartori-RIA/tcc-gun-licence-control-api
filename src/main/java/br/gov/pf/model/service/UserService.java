package br.gov.pf.model.service;

import br.gov.pf.model.User;
import br.gov.pf.model.dao.UserDAO;

/**
 * Created by sartori on 15/03/17.
 */
public class UserService extends AbstractService<Long, User> {

    public UserService() {
        dao = new UserDAO();
    }
}
