package br.gov.pf.resource;

import br.gov.pf.model.entity.Requirement;
import br.gov.pf.model.entity.State;
import br.gov.pf.model.service.StateService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@Secured
@Path("/states")
@Stateless
public class StateResource extends AbstractResource<Long, State> {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(State.class));

    @Inject
    private StateService service;

    public StateResource() {
    }
}
