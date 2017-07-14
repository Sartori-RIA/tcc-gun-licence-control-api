package br.gov.pf.resource;

import br.gov.pf.model.Licence;
import br.gov.pf.model.service.LicenceService;
import org.apache.log4j.Logger;

import javax.ws.rs.Path;

/**
 * Created by sartori on 13/07/17.
 */
@Path("/licencas")
public class LicenceResource extends AbstractResource<Integer, Licence> {
    private static final Logger LOGGER = Logger.getLogger(LicenceResource.class);

    public LicenceResource() {
        service = new LicenceService();
    }
}
