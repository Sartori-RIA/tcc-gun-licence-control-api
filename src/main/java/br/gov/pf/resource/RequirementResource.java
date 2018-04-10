package br.gov.pf.resource;

import br.gov.pf.model.entity.City;
import br.gov.pf.model.entity.Requirement;
import br.gov.pf.model.service.RequirementService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@Secured
@Path("/requirements")
@Stateless
public class RequirementResource extends AbstractResource<Long, Requirement> {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Requirement.class));

    @Inject
    private RequirementService service;

    public RequirementResource() {
    }
}
