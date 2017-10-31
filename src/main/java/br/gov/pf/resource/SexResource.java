package br.gov.pf.resource;

import br.gov.pf.model.entity.Sex;
import br.gov.pf.model.service.SexService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@Stateless
@Path("/sexos")
public class SexResource extends AbstractResource<Long, Sex> {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Sex.class));
    @Inject
    private SexService service;

    public SexResource() {
    }
}
