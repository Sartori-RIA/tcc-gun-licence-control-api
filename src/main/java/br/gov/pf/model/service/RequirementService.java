package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.RequirementDAO;
import br.gov.pf.model.entity.Requirement;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class RequirementService extends AbstractService<Long, Requirement>{
    @Inject private RequirementDAO dao;

    @Override
    public AbstractDAO<Long, Requirement> getDAO() {
        return this.dao;
    }
}
