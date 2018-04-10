package br.gov.pf.model.service;

import br.gov.pf.model.dao.AbstractDAO;
import br.gov.pf.model.dao.LicenseDAO;
import br.gov.pf.model.entity.Exam;
import br.gov.pf.model.entity.License;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sartori on 13/07/17.
 */
@Stateless
public class LicenseService extends AbstractService<Long, License> {
    @Inject
    private LicenseDAO dao;

    @Override
    public AbstractDAO<Long, License> getDAO() {
        return dao;
    }

    @Override
    public License update(License entity) throws Exception {
        if (verifyExams(entity)) {
            entity.setStatus(true);
            entity.setShelfLife(setExpirateDate(entity));
        }
        return super.update(entity);
    }


    private Boolean verifyExams(License entity) {
        ArrayList<Exam> exams = new ArrayList<>();
        if (entity.getExamList() != null) {
            entity.getCategory().getRequirement().getExams().forEach(examCategory -> {
                entity.getExamList().forEach(exam -> {
                    if (exam.getExamCategory().getId().equals(examCategory.getId()) && exam.getStatus())
                        exams.add(exam);
                });
            });
            return exams.size() == entity.getCategory().getRequirement().getExams().size();
        }
        return Boolean.FALSE;
    }


    private Date setExpirateDate(License entity) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, entity.getCategory().getYearsExpirate());
        return calendar.getTime();
    }
}
