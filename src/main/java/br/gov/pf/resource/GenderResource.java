package br.gov.pf.resource;

import br.gov.pf.model.entity.Sex;
import br.gov.pf.model.service.GenderService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@Secured
@Stateless
@Path("/generos")
public class GenderResource extends AbstractResource<Long, Sex> {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Sex.class));
    @Inject
    private GenderService service;

    public GenderResource() {
    }
}
