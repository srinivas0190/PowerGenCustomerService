package com.powergen.utilityservices.dao.jmsmessage;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.powergen.utilityservices.model.customerservices.Customer;
import com.powergen.utilityservices.util.HibernateUtil;

/**
 * @author Srinivas Kondapaneni
 * JMS service DAO to insert the service id for a given customer id
 */
public class MessageReceiverDao {

	/**
	 * JMS service DAO class to update the service pla id for the
	 * given customer ID in the database.
	 * @param customerId
	 * @param serv_id
	 */
	public void updateCustomerService(int customerId, int serv_id) {

		Session session = HibernateUtil.getCurrentSession();

		try {
			session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, customerId);

			customer.setServ_id(serv_id);

			session.update(customer);
			
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();

			session.flush();
		}
		
		
	}
}
