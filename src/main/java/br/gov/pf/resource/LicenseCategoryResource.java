package br.gov.pf.resource;

import br.gov.pf.model.entity.LicenseCategory;
import br.gov.pf.model.service.LicenseCategoryService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@Stateless
@Path("/licenses-types")
public class LicenseCategoryResource extends AbstractResource<Long, LicenseCategory> {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(LicenseCategory.class));
    @Inject
    private LicenseCategoryService service;

    public LicenseCategoryResource() {
    }
}
