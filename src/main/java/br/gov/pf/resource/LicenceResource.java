package br.gov.pf.resource;

import br.gov.pf.model.entity.Licence;
import br.gov.pf.model.service.LicenceService;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 * Created by sartori on 13/07/17.
 */
@Stateless
@Path("/licencas")
public class LicenceResource extends AbstractResource<Long, Licence> {
    private static final Logger LOGGER = Logger.getLogger(LicenceResource.class);

    @Inject
    private LicenceService service;

    public LicenceResource() {
    }
}
