package br.gov.pf.model.dao;

import br.gov.pf.model.entity.License;

import javax.ejb.Stateless;

/**
 * Created by sartori on 13/07/17.
 */
@Stateless
public class LicenseDAO extends AbstractDAO<Long, License> {

    @Override
    public License getByProperty(String propertyName, String propertyValue) {
        return super.getByProperty(propertyName, propertyValue);
    }
}
