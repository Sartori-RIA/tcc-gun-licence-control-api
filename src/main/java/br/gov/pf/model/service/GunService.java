package br.gov.pf.model.service;

import br.gov.pf.model.Gun;
import br.gov.pf.model.dao.GunDAO;

/**
 * Created by sartori on 13/07/17.
 */
public class GunService extends AbstractService<Long, Gun> {
    public GunService() {
        dao = new GunDAO();
    }
}
