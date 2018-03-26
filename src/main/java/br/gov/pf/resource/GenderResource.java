package br.gov.pf.resource;

import br.gov.pf.model.entity.Gender;
import br.gov.pf.model.service.GenderService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@Secured
@Stateless
@Path("/genders")
public class GenderResource extends AbstractResource<Long, Gender> {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Gender.class));
    @Inject
    private GenderService service;

    public GenderResource() {
    }
}
