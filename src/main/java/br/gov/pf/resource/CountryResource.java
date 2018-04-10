package br.gov.pf.resource;

import br.gov.pf.model.entity.Country;
import br.gov.pf.model.service.CountryService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@Secured
@Path("/countries")
@Stateless
public class CountryResource extends AbstractResource<Long, Country> {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Country.class));

    @Inject
    private CountryService service;

    public CountryResource() {
    }
}
