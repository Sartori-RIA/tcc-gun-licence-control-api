package br.gov.pf.model.service;

import br.gov.pf.model.User;
import br.gov.pf.model.dao.UserDAO;

/**
 * Created by sartori on 13/07/17.
 */
public class UserService extends AbstractService<Integer, User> {
    public UserService() {
        dao = new UserDAO();
    }
}
