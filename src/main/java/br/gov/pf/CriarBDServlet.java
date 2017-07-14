package br.gov.pf;

import br.gov.pf.model.Exam;
import br.gov.pf.model.service.ExamService;
import br.gov.pf.model.service.GunService;
import br.gov.pf.model.service.LicenceService;
import br.gov.pf.model.service.UserService;
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

		Exam exam = new Exam("Teste Prático");
		entityManager.persist(exam);
		Exam exam1 = new Exam("Teste Psicológico" );
		entityManager.persist(exam1);
		entityManager.getTransaction().commit();
		entityManager.close();

		ExamService examService = new ExamService();
		GunService gunService = new GunService();
		LicenceService licenceService = new LicenceService();
		UserService userService = new UserService();

	}


}
