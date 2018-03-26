package br.gov.pf.resource;

import br.gov.pf.model.entity.City;
import br.gov.pf.model.service.CityService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Secured
@Stateless
@Path("/cities")
public class CityResource extends AbstractResource<Long, City> {
    @Inject
    private CityService service;

    public CityResource() {
    }
}
