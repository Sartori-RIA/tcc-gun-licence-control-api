package br.gov.pf.model.service;

import br.gov.pf.model.Client;
import br.gov.pf.model.dao.ClientDAO;
import br.gov.pf.model.dao.GunDAO;

/**
 * Created by sartori on 19/04/17.
 */
public class ClientService extends AbstractService<Integer, Client> {

    public ClientService(){
        dao = new ClientDAO();
    }
}
