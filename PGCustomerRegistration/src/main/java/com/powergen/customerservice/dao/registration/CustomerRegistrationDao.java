package com.powergen.customerservice.dao.registration;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.powergen.customerservice.model.registration.Customer;

/**
 * DAO class to save customer in the database
 * @author Srinivas Kondapaneni
 *
 */
public class CustomerRegistrationDao {

	@Autowired
	SessionFactory mySessionFactory;

	
	public Integer saveCustomer(Customer customer) {
		
	
		Session session = mySessionFactory.openSession();
	
		Integer c_Id = null;
		try {
			
			Customer cust = new Customer();
			cust.setUname(customer.getUname());
			cust.setPassword(customer.getPassword());
			cust.setEmail(customer.getEmail());
			cust.setPhoneNum(customer.getPhoneNum());
			
			c_Id = (Integer) session.save(cust);
			
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
		} 
		//session.flush();
		return c_Id;
	}
}

