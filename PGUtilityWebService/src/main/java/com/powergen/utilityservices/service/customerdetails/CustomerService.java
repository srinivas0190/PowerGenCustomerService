package com.powergen.utilityservices.service.customerdetails;

import com.powergen.utilityservices.dao.customerdetails.CustomerServiceDao;
import com.powergen.utilityservices.model.customerservices.Customer;


/**
 * customer service class to get customer details from DAO 
 * @author Srinivas Kondapaneni
 *
 */
public class CustomerService{
	
	/**
	 * This method gets customer details from DAO. 
	 * @param customerId
	 */
	public Customer getCustomerDetails(int customerId){
		
		CustomerServiceDao customerServiceDAO = new CustomerServiceDao();
		
		Customer customer = customerServiceDAO.getCustomerById(customerId);
		
		return customer;
	}

}
