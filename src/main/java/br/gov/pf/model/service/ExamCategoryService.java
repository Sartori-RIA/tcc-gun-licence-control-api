package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.ExamCategoryDAO;
import br.gov.pf.model.entity.ExamCategory;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ExamCategoryService extends AbstractService<Long, ExamCategory> {

    @Inject
    private ExamCategoryDAO dao;

    @Override
    public AbstractDAO<Long, ExamCategory> getDAO() {
        return this.dao;
    }
}
