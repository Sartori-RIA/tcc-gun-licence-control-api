package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.CityDAO;
import br.gov.pf.model.entity.City;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CityService extends AbstractService<Long, City> {

    @Inject
    private CityDAO dao;

    @Override
    public AbstractDAO<Long, City> getDAO() {
        return this.dao;
    }
}
