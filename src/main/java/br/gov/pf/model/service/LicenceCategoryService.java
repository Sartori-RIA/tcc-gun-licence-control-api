package br.gov.pf.model.service;

import br.gov.pf.model.LicenceCategory;
import br.gov.pf.model.dao.LicenceCategoryDAO;

public class LicenceCategoryService extends AbstractService<Long, LicenceCategory> {
    public LicenceCategoryService() {
        dao = new LicenceCategoryDAO();
    }
}
