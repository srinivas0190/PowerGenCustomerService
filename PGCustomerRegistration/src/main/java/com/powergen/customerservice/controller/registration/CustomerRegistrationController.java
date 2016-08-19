package com.powergen.customerservice.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.powergen.customerservice.model.registration.Customer;
import com.powergen.customerservice.service.registration.CustomerRegistrationService;

/**
 * 
 * Spring Controller to start the service to save the customer
 * @author Srinivas Kondapaneni
 *
 */
@Controller
public class CustomerRegistrationController {
	
	
	@Autowired
	private CustomerRegistrationService customerServHandler;

		@RequestMapping(value = "/register", method = RequestMethod.POST)
		public ModelAndView customerRegistration(@ModelAttribute("registerPage") Customer customer, ModelMap model) {
			
			String customerServiceDetails = customerServHandler.sendCustomer(customer);
			
			if (customerServiceDetails != null) {
				
				String[] customerDetails = customerServiceDetails.split(":");
		
				return new ModelAndView("register","customerDetails", customerDetails );
			}
			else {
			
				return new ModelAndView("errorPage","customer",customer);
			}
			
		}
		}