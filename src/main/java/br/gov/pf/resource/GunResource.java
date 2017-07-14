package br.gov.pf.resource;

import br.gov.pf.model.Gun;
import br.gov.pf.model.service.GunService;
import org.apache.log4j.Logger;

import javax.ws.rs.Path;

/**
 * Created by sartori on 13/07/17.
 */
@Path("/armas")
public class GunResource extends AbstractResource<Integer, Gun>{
    private static final Logger LOGGER = Logger.getLogger(GunResource.class);

    public GunResource() {
        service = new GunService();
    }
}
