package br.gov.pf.model.service;

import br.gov.pf.model.Exam;
import br.gov.pf.model.dao.ExamDAO;

/**
 * Created by sartori on 13/07/17.
 */
public class ExamService extends AbstractService<Long, Exam> {
    public ExamService() {
        dao = new ExamDAO();
    }
}
