package br.gov.pf.resource;

import br.gov.pf.model.entity.ExamCategory;
import br.gov.pf.model.service.ExamCategoryService;
import br.gov.pf.security.Secured;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@Secured
@Stateless
@Path("/exams-types")
public class ExamCategoryResource extends AbstractResource<Long, ExamCategory> {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(ExamCategory.class));

    @Inject
    private ExamCategoryService service;

    public ExamCategoryResource() {
    }
}
