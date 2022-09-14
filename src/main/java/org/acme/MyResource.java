package org.acme;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/")
public class MyResource implements MyInterface {

	@PersistenceContext
	EntityManager em;
    
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