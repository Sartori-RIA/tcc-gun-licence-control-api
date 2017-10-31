package br.gov.pf.model.dao;

import br.gov.pf.model.entity.User;

import javax.ejb.Stateless;

/**
 * Created by sartori on 13/07/17.
 */
@Stateless
public class UserDAO extends AbstractDAO<Long, User> {
}
