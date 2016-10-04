package br.com.transaction.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import br.com.transaction.domain.Customer;

/**
 * Created by fernando on 03/10/16.
 */
@Controller
@Path("/transaction_api")
public class TransactionService {


    @GET
    @Path("/get")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response get() {
    	
    	Customer customer = new Customer();
    	
    	customer.setId(1l);
    	customer.setDocument("31002461871");
    	customer.setName("Fernando");
    	
        return Response.ok(customer).build();
    }

}
