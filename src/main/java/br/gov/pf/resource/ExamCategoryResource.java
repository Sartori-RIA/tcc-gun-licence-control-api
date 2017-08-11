package br.gov.pf.resource;

import br.gov.pf.model.entity.ExamCategory;
import br.gov.pf.model.service.ExamCategoryService;

import javax.ws.rs.Path;

@Path("/exames/categorias")
public class ExamCategoryResource extends AbstractResource<Long, ExamCategory> {
    public ExamCategoryResource() {
        service = new ExamCategoryService();
    }
}
