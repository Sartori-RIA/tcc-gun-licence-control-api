package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.CountryDAO;
import br.gov.pf.model.entity.Country;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CountryService extends AbstractService<Long, Country> {

    @Inject
    private CountryDAO dao;

    @Override
    public AbstractDAO<Long, Country> getDAO() {
        return this.dao;
    }
}
