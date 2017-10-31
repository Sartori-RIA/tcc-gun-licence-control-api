package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.entity.Gun;
import br.gov.pf.model.dao.GunDAO;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by sartori on 13/07/17.
 */
@Stateless
public class GunService extends AbstractService<Long, Gun> {

    @Inject private GunDAO dao;
    @Override
    public AbstractDAO<Long, Gun> getDAO() {
        return this.dao;
    }
}
