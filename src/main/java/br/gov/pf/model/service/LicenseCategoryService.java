package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.LicenceCategoryDAO;
import br.gov.pf.model.entity.LicenseCategory;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class LicenseCategoryService extends AbstractService<Long, LicenseCategory> {

    @Inject
    private LicenceCategoryDAO dao;

    @Override
    public AbstractDAO<Long, LicenseCategory> getDAO() {
        return this.dao;
    }
}
