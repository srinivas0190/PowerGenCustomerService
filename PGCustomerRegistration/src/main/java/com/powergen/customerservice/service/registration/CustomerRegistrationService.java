package com.powergen.customerservice.service.registration;

import java.util.List;

import com.powergen.customerservice.dao.registration.CustomerRegistrationDao;
import com.powergen.customerservice.jms.registration.JmsQueueSender;
import com.powergen.customerservice.model.registration.Customer;
import com.powergen.customerservice.webservice.registration.ServicePlan;
import com.powergen.customerservice.webservice.registration.ServicePlanWS;
import com.powergen.customerservice.webservice.registration.ServicePlanWSService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * CustomerServiceHandlerImpl class handles the flow of the project. It follow
 * the steps of saving the customer, calling the soap service to generate a list
 * of services calling the rest client for the registered customer details and
 * calling the jms service to send a message to listener
 * 
 * @author Srinivas Kondapaneni
 *
 */
public class CustomerRegistrationService {

	public CustomerRegistrationService(CustomerRegistrationDao custServiceDao, JmsQueueSender queueSender) {
		this.custServiceDao = custServiceDao;
		this.queueSender = queueSender;
	}

	private JmsQueueSender queueSender;
	private CustomerRegistrationDao custServiceDao;

	/**
	 * Method to process the customer
	 * 
	 * @param customer
	 */
	public String sendCustomer(Customer customer) {

		List<ServicePlan> servList = null;
		int serviceId = 0;
		String service_type = null;
		Customer registeredCustomer = null;
		String customerService = null;
		
		String serviceDetails = null;

		Integer customerId = custServiceDao.saveCustomer(customer);

		registeredCustomer = getCustomer(customerId);
		
		servList = getServiceList();

		serviceId = servList.get(0).getId();
		
		service_type = servList.get(0).getServicePlan();

		queueSender.sendMessage(customerId + " " + serviceId);
		
		serviceDetails = serviceId + ":" + service_type;
		
		customerService = registeredCustomer.toString() + ":" +serviceDetails;
		
		return customerService;
	}

	/**
	 * Method to connect to the external application using rest url
	 * 
	 * @param c_id
	 * @return
	 */
	public Customer getCustomer(int c_id) {

		Customer customer = null;

		try {

			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:8080/UtilityWebService/RestWS/cust/" + c_id);

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			customer = response.getEntity(Customer.class);
			
		} catch (Exception e) {

			e.printStackTrace();
		}

		return customer;
	}
	
	
	/**
	 * Method to get service list generated from DAO
	 * @return ServiceList
	 */
	public List<ServicePlan> getServiceList() {

		ServicePlanWSService swsService = new ServicePlanWSService();
		ServicePlanWS servicePlanWS = swsService.getServicePlanWSPort();

		List<ServicePlan> serviceList = servicePlanWS.getServicePlans();
		return serviceList;
	}

}