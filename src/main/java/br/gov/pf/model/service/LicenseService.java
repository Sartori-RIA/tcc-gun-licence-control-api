package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.LicenseDAO;
import br.gov.pf.model.entity.License;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by sartori on 13/07/17.
 */
@Stateless
public class LicenseService extends AbstractService<Long, License> {
    @Inject
    private LicenseDAO dao;

    @Override
    public AbstractDAO<Long, License> getDAO() {
        return this.dao;
    }
}
