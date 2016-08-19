package com.powergen.customerservice.testcases.registration;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.powergen.customerservice.model.registration.Customer;
import com.powergen.customerservice.service.registration.CustomerRegistrationService;


public class MockitoTestCase {
	
	@Test
	public void testGetCustomer() {
		Customer customer = new Customer();
		customer.setUname("srinivas");
		customer.setPassword("srinivas");
		customer.setEmail("srinivas@gmail.com");
		customer.setPhoneNum("123456789");
		
		CustomerRegistrationService custImpl = Mockito.mock(CustomerRegistrationService.class);
		
		when(custImpl.getCustomer(1)).thenReturn(customer);
		
		assertEquals(custImpl.getCustomer(1), customer);
	}

}
