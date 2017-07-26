package br.gov.pf.model.service;

import br.gov.pf.model.Licence;
import br.gov.pf.model.dao.LicenceDAO;

/**
 * Created by sartori on 13/07/17.
 */
public class LicenceService extends AbstractService<Long, Licence>{
    public LicenceService() {
        dao = new LicenceDAO();
    }
}
