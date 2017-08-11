package br.gov.pf.model.service;

import br.gov.pf.model.entity.Sex;
import br.gov.pf.model.dao.SexDAO;

public class SexService extends AbstractService<Long, Sex> {
    public SexService() {
        dao = new SexDAO();
    }
}
