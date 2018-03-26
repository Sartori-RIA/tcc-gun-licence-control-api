package br.gov.pf.resource;

import br.gov.pf.model.entity.Address;
import br.gov.pf.model.service.AddressService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

@Secured
@Path("/address")
@Stateless
public class AddressResource extends AbstractResource<Long, Address> {

    @Inject
    private AddressService service;

    public AddressResource() {
    }
}
