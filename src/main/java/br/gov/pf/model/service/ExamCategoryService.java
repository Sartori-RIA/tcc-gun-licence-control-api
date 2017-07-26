package br.gov.pf.model.service;

import br.gov.pf.model.ExamCategory;
import br.gov.pf.model.dao.ExamCategoryDAO;

public class ExamCategoryService extends AbstractService<Long, ExamCategory> {
    public ExamCategoryService() {
        dao = new ExamCategoryDAO();
    }
}
