package br.com.transaction.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.transaction.business.CustomerBO;
import br.com.transaction.domain.Customer;

/**
 * Created by fernando on 03/10/16.
 */
@Controller
@Path("/customer_api")
public class CustomerService {
	
	@Autowired
	private CustomerBO customerBO;

    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response create() {
    	
    	Customer customerCreated = customerBO.create();
    	
        return Response.ok(customerCreated).build();
    }

}
