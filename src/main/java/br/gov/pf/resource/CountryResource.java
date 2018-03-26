package br.gov.pf.resource;

import br.gov.pf.model.entity.Country;
import br.gov.pf.model.service.CountryService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Secured
@Path("/countries")
@Stateless
public class CountryResource extends AbstractResource<Long, Country> {

    @Inject
    private CountryService service;

    public CountryResource() {
    }
}
