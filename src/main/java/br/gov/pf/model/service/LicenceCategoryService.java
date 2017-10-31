package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.LicenceCategoryDAO;
import br.gov.pf.model.entity.LicenceCategory;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class LicenceCategoryService extends AbstractService<Long, LicenceCategory> {

    @Inject
    private LicenceCategoryDAO dao;

    @Override
    public AbstractDAO<Long, LicenceCategory> getDAO() {
        return this.dao;
    }
}
