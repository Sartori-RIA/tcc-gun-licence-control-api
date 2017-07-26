package br.gov.pf;

import br.gov.pf.model.*;
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
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		criarBD();
		response.getWriter().println("SUCESSO");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		criarBD();
	}
	
	private void criarBD(){

    	EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();

		ExamCategory exam = new ExamCategory("Teste Prático");
		entityManager.persist(exam);
		ExamCategory exam1 = new ExamCategory("Teste Psicológico" );
		entityManager.persist(exam1);

		Sex sex = new Sex("Masculino");
		entityManager.persist(sex);
		Sex sex1 = new Sex("Feminino");
		entityManager.persist(sex1);

		LicenceCategory licenceCategory = new LicenceCategory("Porte");
		entityManager.persist(licenceCategory);
		LicenceCategory licenceCategory1 = new LicenceCategory("Posse");
		entityManager.persist(licenceCategory1);

		UserCategory userCategory = new UserCategory("Admin");
		entityManager.persist(userCategory);
		UserCategory userCategory1 = new UserCategory("Delegado");
		entityManager.persist(userCategory1);
		UserCategory userCategory2 = new UserCategory("Psicologo");
		entityManager.persist(userCategory2);
		UserCategory userCategory3 = new UserCategory("Instrutor");
		entityManager.persist(userCategory3);
		UserCategory userCategory4 = new UserCategory("Civil");
		entityManager.persist(userCategory4);


		entityManager.getTransaction().commit();
		entityManager.close();

		ExamService examService = new ExamService();
		GunService gunService = new GunService();
		LicenceService licenceService = new LicenceService();
		UserService userService = new UserService();
		SexService sexService = new SexService();
		UserCategoryService userCategoryService = new UserCategoryService();
		LicenceCategoryService licenceCategoryService = new LicenceCategoryService();

	}


}
