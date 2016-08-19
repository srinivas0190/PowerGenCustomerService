package com.powergen.utilityservices.dao.customerdetails;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.powergen.utilityservices.model.customerservices.Customer;
import com.powergen.utilityservices.util.HibernateUtil;

/**
 * @author Srinivas Kondapaneni
 * Rest service to get customer details by id from the database.
 */
public class CustomerServiceDao{

	/**
	 * Rest service to get customer details by id from the database.
	 * @param customerId
	 * @return
	 */
	public Customer getCustomerById(int c_id){
		
		Session session = HibernateUtil.getSession();
		Customer customer = new Customer();
		
		try {
			
			customer = (Customer)session.get(Customer.class, c_id);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.flush();
		}
		return customer;	
	}
}
