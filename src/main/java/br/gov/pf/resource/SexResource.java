package br.gov.pf.resource;

import br.gov.pf.model.entity.Sex;
import br.gov.pf.model.service.SexService;

import javax.ws.rs.Path;

@Path("/sexos")
public class SexResource extends AbstractResource<Long, Sex> {
    public SexResource() {
        service = new SexService();
    }
}
