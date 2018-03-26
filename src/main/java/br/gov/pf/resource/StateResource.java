package br.gov.pf.resource;

import br.gov.pf.model.entity.State;
import br.gov.pf.model.service.StateService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Secured
@Path("/states")
@Stateless
public class StateResource extends AbstractResource<Long, State> {

    @Inject
    private StateService service;

    public StateResource() {
    }
}
