package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.AddressDAO;
import br.gov.pf.model.entity.Address;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AddressService extends AbstractService<Long, Address>{

    @Inject private AddressDAO dao;
    @Override
    public AbstractDAO<Long, Address> getDAO() {
        return this.dao;
    }
}
