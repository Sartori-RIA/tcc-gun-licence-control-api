package br.gov.pf.resource;

import br.gov.pf.model.service.AbstractService;
import br.gov.pf.security.Secured;
import br.gov.pf.util.PredicateBuilder;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.List;


public abstract class AbstractResource<PK, T> implements Serializable {

    @Inject
    protected AbstractService<PK, T> service;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<T> findAll(@QueryParam("start") int start,
                           @QueryParam("qnt") int quantity) {
        try {
            if (quantity <= 0)
                quantity = 100;
            if (start >= 0) {
                PredicateBuilder builder = this.service.getPredicateBuilder();
                return this.service.findAll(builder.limit(start, quantity));
            } else {
                return this.service.findAll();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new WebApplicationException(500);
        }
    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public T findById(@PathParam("id") PK id) {
        try {
            return service.getById(id);
        } catch (Exception ex) {
            throw new WebApplicationException(500);
        }
    }

    @GET
    @Secured
    @Path("/find/property/{property}/value/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByProperty(@PathParam("property") String property,
                                   @PathParam("value") String value) {
        try {
            T entity = service.getByProperty(property, value);
            return Response
                    .ok(entity)
                    .build();

        } catch (Exception ex) {
            throw new WebApplicationException(500);
        }
    }

    @GET
    @Path("/find/property/{property_one}/value/{value_one}/property/{property_two}/value/{value_two}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByTwoProperties(@PathParam("property_one") String propertyOne,
                                        @PathParam("value_one") String valueOne,
                                        @PathParam("property_two") String propertyTwo,
                                        @PathParam("value_two") String valueTwo) {
        try {
            T entity = service.getByTwoProperties(propertyOne, valueOne, propertyTwo, valueTwo);
            return Response
                    .ok(entity)
                    .build();

        } catch (Exception ex) {
            throw new WebApplicationException(500);
        }
    }

    @GET
    @Path("/property/{property}/value/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listByProperty(@PathParam("property") String property,
                                   @PathParam("value") String value) {
        try {
            List<T> entity = service.listByProperty(property, value);
            return Response
                    .ok(entity)
                    .build();
        } catch (Exception ex) {
            throw new WebApplicationException(500);
        }
    }

    @GET
    @Path("/property/{property_one}/value/{value_one}/property/{property_two}/value/{value_two}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listByTwoProperties(@PathParam("property_one") String propertyOne,
                                        @PathParam("value_one") String valueOne,
                                        @PathParam("property_two") String propertyTwo,
                                        @PathParam("value_two") String valueTwo) {
        try {
            List<T> entity = service.listByTwoProperties(propertyOne, valueOne, propertyTwo, valueTwo);
            return Response
                    .ok(entity)
                    .build();
        } catch (Exception ex) {
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
        } catch (Exception ex) {
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
        } catch (Exception ex) {
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

        } catch (Exception ex) {
            throw new WebApplicationException(500);
        }
    }

}
