package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.GenderDAO;
import br.gov.pf.model.entity.Gender;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GenderService extends AbstractService<Long, Gender> {

    @Inject
    private GenderDAO dao;

    @Override
    public AbstractDAO<Long, Gender> getDAO() {
        return this.dao;
    }
}
