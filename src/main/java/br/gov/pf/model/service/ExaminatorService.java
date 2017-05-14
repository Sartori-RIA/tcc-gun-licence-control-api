package br.gov.pf.model.service;

import br.gov.pf.model.Examinator;
import br.gov.pf.model.dao.ExaminatorDAO;

/**
 * Created by sartori on 13/05/17.
 */
public class ExaminatorService extends AbstractService<String, Examinator> {
    public ExaminatorService() {
        dao = new ExaminatorDAO();
    }
}
