package com.powergen.utilityservices.webservices.customerdetails;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.logging.Logger;

import com.powergen.utilityservices.model.customerservices.Customer;
import com.powergen.utilityservices.service.customerdetails.CustomerService;

/**
 * @author SrinivasKondapaneni
 *	Rest service class
 */
@Path("/cust")
@Produces("application/json")
public class CustomerServiceWS {

	final static Logger logger = Logger.getLogger(CustomerServiceWS.class);
	
	  @Path("{param}")
	  @GET
	  @Produces("application/json")
	public Customer getCustomerDetails(@PathParam("param") int customerId) {
		  
		logger.info("Invoked rest call");

		CustomerService customerService = new CustomerService();

		Customer customer = customerService.getCustomerDetails(customerId);
		
		logger.info("Completed Rest Call");
		logger.info(customer);
		
		return customer;
	}
}
