package com.powergen.utilityservices.service.serviceplandetails;

import java.util.List;

import com.powergen.utilityservices.dao.serviceplandetails.ServicePlanDAO;
import com.powergen.utilityservices.model.customerservices.ServicePlan;

/**
 * @author Srinivas Kondapaneni
 * Soap service provider class to get all the
 * services from the database.
 *
 */
public class UtilityService {

	/**
	 * Method to retieve all the services from the database. 
	 * @return list of service plans
	 */
	public List<ServicePlan> getServicePlansList() {
		ServicePlanDAO servicePlanDAO = new ServicePlanDAO();

		 List<ServicePlan> servicePlans = servicePlanDAO.getServicePlans();

		return servicePlans;
	}
}
