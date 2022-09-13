package org.acme;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource implements Greeting {

	@PersistenceContext
	EntityManager em;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "Hello RESTEasy";
    }
    
	@POST
    @Path("/create")
    @Transactional
    public void transactionalMethod(@QueryParam("field") String field) {
    	nonTransactionalMethod(field);
    }
    
    @Override
    public void nonTransactionalMethod(String field) {
    	var entity = new MyEntity();
    	entity.setField(field);
		em.persist(entity);
    }
}