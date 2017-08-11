package br.gov.pf.resource;

import br.gov.pf.model.entity.LicenceCategory;
import br.gov.pf.model.service.LicenceCategoryService;

import javax.ws.rs.Path;

@Path("/licencas/categorias")
public class LicenceCategoryResource extends AbstractResource<Long, LicenceCategory> {
    public LicenceCategoryResource() {
        service = new LicenceCategoryService();
    }
}
