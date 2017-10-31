package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.ExamDAO;
import br.gov.pf.model.entity.Exam;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created by sartori on 13/07/17.
 */
@Stateless
public class ExamService extends AbstractService<Long, Exam> {

    @Inject
    private ExamDAO dao;

    @Override
    public AbstractDAO<Long, Exam> getDAO() {
        return this.dao;
    }
}
