package br.gov.pf.resource;

import br.gov.pf.model.Examinator;
import br.gov.pf.model.service.ExaminatorService;

import javax.ws.rs.Path;

/**
 * Created by sartori on 13/05/17.
 */
@Path("/examinators")
public class ExaminatorResource extends AbstractResource<String, Examinator> {

    public ExaminatorResource() {
        service = new ExaminatorService();
    }
}
