package br.gov.pf.resource;

import br.gov.pf.model.entity.License;
import br.gov.pf.model.service.LicenseService;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 * Created by sartori on 13/07/17.
 */
@Stateless
@Path("/licenses")
public class LicenseResource extends AbstractResource<Long, License> {
    private static final Logger LOGGER = Logger.getLogger(LicenseResource.class);

    @Inject
    private LicenseService service;

    public LicenseResource() {
    }
}
