package com.powergen.utilityservices.dao.serviceplandetails;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.powergen.utilityservices.model.customerservices.ServicePlan;
import com.powergen.utilityservices.util.HibernateUtil;


/**
 * @author Srinivas Kondapaneni
 * Service Plan DAO to get the list of service plans from the database
 */
public class ServicePlanDAO {
	
	/**
	 * Method to get the list of service plans from the database
	 * @return list of service plans
	 */
	@SuppressWarnings("unchecked")
	public List<ServicePlan> getServicePlans(){
		
		List<ServicePlan> serviceList = new ArrayList<ServicePlan>();
		Session session = HibernateUtil.getSession();
		
		try {
			
			serviceList = session.createQuery("from ServicePlan").list();
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
			session.flush();
		} 
		
		if(serviceList.isEmpty()){
			return null;
		}
		else{
			return serviceList;	
		}
	}
}
