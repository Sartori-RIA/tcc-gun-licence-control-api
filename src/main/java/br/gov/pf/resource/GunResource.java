package br.gov.pf.resource;

import br.gov.pf.model.entity.Gun;
import br.gov.pf.model.service.GunService;
import br.gov.pf.security.Secured;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 * Created by sartori on 13/07/17.
 */
@Secured
@Stateless
@Path("/armas")
public class GunResource extends AbstractResource<Long, Gun> {
    private static final Logger LOGGER = Logger.getLogger(GunResource.class);

    @Inject
    private GunService service;

    public GunResource() {
    }
}
