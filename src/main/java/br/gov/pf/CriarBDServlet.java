package br.gov.pf;

import br.gov.pf.model.Client;
import br.gov.pf.model.Gun;
import br.gov.pf.model.service.ClientService;
import br.gov.pf.model.service.GunService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
		
		GunService gunService = new GunService();
		ClientService clientService = new ClientService();
		List<String> categories = Arrays.asList("Mecânico", "Carpinteiro", "Eletricista", "Encanador", "Guincho", "Dedetizador", "Desentupidor", "Pedreiro", "Pintor", "Mudanças e Carreto", "Jardineiro", "Motoboy", "Chaveiro", "Técnico em Computação");
		Gun gun = null;
		Client client = null;
		for(String c : categories){
			gun = new Gun(c);
			client = new Client(c);
			gunService.save(gun);
			clientService.save(client);
		}
		
	}	


}
