package com.powergen.utilityservices.webservices.serviceplandetails;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.powergen.utilityservices.model.customerservices.ServicePlan;
import com.powergen.utilityservices.service.serviceplandetails.UtilityService;


/**
 * @author Srinivas Kondapaneni
 * Soap service class
 */
@WebService
public class ServicePlanWS {
	
	/**
	 * @return list of service plans
	 */
	@WebMethod
	public List<ServicePlan> getServicePlans() {

		UtilityService utilityService = new UtilityService();

		 List<ServicePlan> servicePlans = new ArrayList<ServicePlan>();
		 servicePlans = utilityService.getServicePlansList();
		
		return servicePlans;
	}
	
}
