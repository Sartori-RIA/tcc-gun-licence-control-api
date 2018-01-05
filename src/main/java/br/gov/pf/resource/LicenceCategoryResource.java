package br.gov.pf.resource;

import br.gov.pf.model.entity.LicenceCategory;
import br.gov.pf.model.service.LicenceCategoryService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@Secured
@Stateless
@Path("/licencas-categorias")
public class LicenceCategoryResource extends AbstractResource<Long, LicenceCategory> {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LicenceCategory.class));
    @Inject
    private LicenceCategoryService service;

    public LicenceCategoryResource() {
    }
}
