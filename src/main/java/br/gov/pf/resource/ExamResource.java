package br.gov.pf.resource;

import br.gov.pf.model.entity.Exam;
import br.gov.pf.model.service.ExamService;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 * Created by sartori on 13/07/17.
 */
@Stateless
@Path("/exames")
public class ExamResource extends AbstractResource<Long, Exam> {
    private static final Logger LOGGER = Logger.getLogger(ExamResource.class);

    @Inject
    private ExamService service;

    public ExamResource() {
    }
}
