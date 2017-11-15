package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.LicenceDAO;
import br.gov.pf.model.entity.Licence;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by sartori on 13/07/17.
 */
@Stateless
public class LicenceService extends AbstractService<Long, Licence> {
    @Inject
    private LicenceDAO dao;

    @Override
    public AbstractDAO<Long, Licence> getDAO() {
        return this.dao;
    }
}
