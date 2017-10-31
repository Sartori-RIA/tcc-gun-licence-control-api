package br.gov.pf;

import br.gov.pf.model.entity.ExamCategory;
import br.gov.pf.model.entity.LicenceCategory;
import br.gov.pf.model.entity.Sex;
import br.gov.pf.model.entity.UserRole;
import br.gov.pf.model.service.*;
import br.gov.pf.util.JPAUtil;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CriarBDServlet
 */
@WebServlet("/criar")
public class CriarBDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CriarBDServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		criarBD();
		response.getWriter().println("SUCESSO");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		criarBD();
	}
	
	private void criarBD(){
/*
    	EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();

		ExamCategory exam = new ExamCategory("Teste Prático");
		entityManager.persist(exam);
		ExamCategory exam1 = new ExamCategory("Teste Psicológico" );
		entityManager.persist(exam1);

		Sex sex = new Sex("Masculino","M");
		entityManager.persist(sex);
		Sex sex1 = new Sex("Feminino","F");
		entityManager.persist(sex1);

		LicenceCategory licenceCategory = new LicenceCategory("Porte");
		entityManager.persist(licenceCategory);
		LicenceCategory licenceCategory1 = new LicenceCategory("Posse");
		entityManager.persist(licenceCategory1);

		UserRole userRole = new UserRole("ADMIN");
		entityManager.persist(userRole);
		UserRole userRole1 = new UserRole("DELEGADO");
		entityManager.persist(userRole1);
		UserRole userRole2 = new UserRole("PSICOLOGO");
		entityManager.persist(userRole2);
		UserRole userRole3 = new UserRole("INSTRUTOR");
		entityManager.persist(userRole3);
		UserRole userRole4 = new UserRole("CIVIL");
		entityManager.persist(userRole4);


		entityManager.getTransaction().commit();
		entityManager.close();

		ExamService examService = new ExamService();
		GunService gunService = new GunService();
		LicenceService licenceService = new LicenceService();
		UserService userService = new UserService();
		SexService sexService = new SexService();
		UserRoleService userRoleService = new UserRoleService();
		LicenceCategoryService licenceCategoryService = new LicenceCategoryService();*/

	}


}
