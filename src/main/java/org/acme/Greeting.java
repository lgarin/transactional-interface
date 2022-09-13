package org.acme;

import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

public interface Greeting {

	void nonTransactionalMethod(@QueryParam("field") String field);
	
	@POST
    @Path("/createDefault")
    @Transactional
	default void transactionalDefaultMethod(@QueryParam("field") String field) {
		nonTransactionalMethod("Default: " + field);
	}

}
