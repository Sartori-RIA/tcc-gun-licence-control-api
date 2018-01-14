package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.StateDAO;
import br.gov.pf.model.entity.State;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class StateService extends AbstractService<Long, State> {

    @Inject
    private StateDAO dao;

    @Override
    public AbstractDAO<Long, State> getDAO() {
        return this.dao;
    }
}
