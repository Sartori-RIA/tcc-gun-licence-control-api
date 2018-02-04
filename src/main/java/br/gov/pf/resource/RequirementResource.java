package br.gov.pf.resource;

import br.gov.pf.model.entity.Requirement;
import br.gov.pf.model.service.RequirementService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/requirements")
@Stateless
public class RequirementResource extends AbstractResource<Long, Requirement> {

    @Inject
    private RequirementService service;

    public RequirementResource() {
    }
}
