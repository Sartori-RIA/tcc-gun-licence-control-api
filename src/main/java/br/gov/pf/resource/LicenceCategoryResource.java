package br.gov.pf.resource;

import br.gov.pf.model.LicenceCategory;
import br.gov.pf.model.service.LicenceCategoryService;

public class LicenceCategoryResource extends AbstractResource<Long, LicenceCategory> {
    public LicenceCategoryResource() {
        service = new LicenceCategoryService();
    }
}
