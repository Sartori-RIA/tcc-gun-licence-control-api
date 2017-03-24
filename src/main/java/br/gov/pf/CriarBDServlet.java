package br.gov.pf;

import br.gov.pf.model.Gun;
import br.gov.pf.model.User;
import br.gov.pf.model.service.GunService;
import br.gov.pf.model.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
		List<String> categories = Arrays.asList("Mecânico", "Carpinteiro", "Eletricista", "Encanador", "Guincho", "Dedetizador", "Desentupidor", "Pedreiro", "Pintor", "Mudanças e Carreto", "Jardineiro", "Motoboy", "Chaveiro", "Técnico em Computação");
		Gun gun = null;
		for(String c : categories){
			gun = new Gun(c);
			gunService.save(gun);
		}

		UserService userService = new UserService();
		List<String> users = Arrays.asList("Mecânico", "Carpinteiro", "Eletricista");

		User user = null;
		for (String c: users ){
			user = new User(c);
			userService.save(user);
		}



	/*	CityService cityService = new CityService();
		City city = new City("Guarapuava");
		city.setNeighborhoods(listGuarapuavaNeighborhoods());		
		
		cityService.save(city);
		
		ParticularServiceService particularServiceService = new ParticularServiceService();
		ParticularService particular = new ParticularService("Maria", "000", "blablabla", category);
		particular.setNeighborhood(city.getNeighborhoods().get(0)); 
		particularServiceService.save(particular);*/
		
	}	
	
	/*public List<Neighborhood> listGuarapuavaNeighborhoods(){
		List<Neighborhood> neighborhoods = new ArrayList<>();
		neighborhoods.add(new Neighborhood("Aldeia"));
		neighborhoods.add(new Neighborhood("Centro"));
		neighborhoods.add(new Neighborhood("Jordão"));
		neighborhoods.add(new Neighborhood("Batel"));
		neighborhoods.add(new Neighborhood("Santa Cruz"));
		neighborhoods.add(new Neighborhood("Santana"));
		neighborhoods.add(new Neighborhood("Boqueirão"));
		neighborhoods.add(new Neighborhood("Vila Bela"));
		neighborhoods.add(new Neighborhood("Cascavel"));
		neighborhoods.add(new Neighborhood("Alto Cascavel"));
		neighborhoods.add(new Neighborhood("Jardim das Américas"));
		neighborhoods.add(new Neighborhood("São Cristóvão"));
		neighborhoods.add(new Neighborhood("Alto da XV"));
		neighborhoods.add(new Neighborhood("Morro Alto"));
		neighborhoods.add(new Neighborhood("Bonsucesso"));
		neighborhoods.add(new Neighborhood("Dos Estados"));
		neighborhoods.add(new Neighborhood("Vila Carli"));
		neighborhoods.add(new Neighborhood("Conradinho"));
		neighborhoods.add(new Neighborhood("Primavera"));
		neighborhoods.add(new Neighborhood("Trianon"));
		neighborhoods.add(new Neighborhood("Insdustrial"));
		
		return neighborhoods;
	}*/

}
