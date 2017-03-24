package br.gov.pf.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.gov.pf.model.service.AbstractService;


public class AbstractResource<PK, T> {	

	protected AbstractService<PK, T> service;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<T> findAll() {
		try {
			
			return service.findAll(); 
			
		} 
		catch (Exception ex) {			
			ex.printStackTrace();			
			throw new WebApplicationException(500);
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public T findById(@PathParam("id") PK id) {
		try {		
			T entity = service.getById(id);			
			return entity;
			
		} 
		catch (Exception ex) {			
			throw new WebApplicationException(500);
		}
	}
	
	@GET
	@Path("/find/property/{property}/value/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByProperty(@PathParam("property") String property, @PathParam("value") String value) {
		
		try {
			
			T entity = service.getByProperty(property, value);			
			
			//GenericEntity<T> entity = new GenericEntity<T>(entity) {};
			
			return Response
					.ok(entity)
					.build();
			
		} 
		catch (Exception ex) {			
			throw new WebApplicationException(500);
		}
	}
	
	@GET
	@Path("/property/{property}/value/{value}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listByProperty(@PathParam("property") String property, @PathParam("value") String value) {
		
		try {
			
			List<T> entity = service.listByProperty(property, value);			
			
			//GenericEntity<T> entity = new GenericEntity<T>(entity) {};
			
			return Response
					.ok(entity)
					.build();
			
		} 
		catch (Exception ex) {			
			throw new WebApplicationException(500);
		}
	}
	
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(T entity) {
		try {			
			service.save(entity);	
			
			return Response
					.status(200)
					.entity(entity)
					.build();	
			
		} 
		catch (Exception ex) {	
			ex.printStackTrace();
			throw new WebApplicationException(500);
		}
	}

	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(T entity) {
		try {
			
			service.update(entity);
			
			return Response
					.status(200)
					.entity(entity)
					.build();	
			
		} 
		catch (Exception ex) {			
			throw new WebApplicationException(500);
		}
	}	
	
	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response delete(@PathParam("id") PK id) {
		try {
			
			service.deleteById(id);
			
			return Response
					.status(200)					
					.build();
			
		} 
		catch (Exception ex) {			
			throw new WebApplicationException(500);
		}
	}

	
	
}
