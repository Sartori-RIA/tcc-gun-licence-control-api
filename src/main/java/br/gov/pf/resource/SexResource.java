package br.gov.pf.resource;

import br.gov.pf.model.Sex;
import br.gov.pf.model.service.SexService;

public class SexResource extends AbstractResource<Long, Sex> {
    public SexResource() {
        service = new SexService();
    }
}
