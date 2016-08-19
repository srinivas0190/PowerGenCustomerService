package com.powergen.utilityservices.service.jmsmessage;

import com.powergen.utilityservices.dao.jmsmessage.MessageReceiverDao;


/**
 * @author Srinivas Kondapaneni
 * JMS listener to update the service plan id for the given 
 * customer id in the database. 
 *
 */
public class MessageReceiverService {
	
	/**
	 * update the service plan id for the given 
	 * customer id in the database. 
	 * @param customerId
	 * @param serviceId
	 */
	public void setCustomerService(int customerId, int serviceId) {
	
		MessageReceiverDao jmsMessageDao = new MessageReceiverDao();
		jmsMessageDao.updateCustomerService(customerId, serviceId);
		
	}
}
