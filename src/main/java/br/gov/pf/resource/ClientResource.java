package br.gov.pf.resource;

import br.gov.pf.model.Client;
import br.gov.pf.model.service.ClientService;
import org.apache.log4j.Logger;

import javax.ws.rs.Path;

/**
 * Created by sartori on 19/04/17.
 */
@Path("/clients")
public class ClientResource extends AbstractResource<Integer, Client> {
    private static final Logger LOGGER = Logger.getLogger(ClientResource.class);

    public ClientResource() {
        service = new ClientService();
    }
}
