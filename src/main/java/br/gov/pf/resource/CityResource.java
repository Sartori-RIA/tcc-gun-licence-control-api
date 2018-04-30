package br.gov.pf.resource;

import br.gov.pf.model.entity.City;
import br.gov.pf.model.service.CityService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.logging.Logger;


//@Secured
@Stateless
@Path("/cities")
public class CityResource extends AbstractResource<Long, City> {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(City.class));

    @Inject
    private CityService service;

    public CityResource() {
    }
}
