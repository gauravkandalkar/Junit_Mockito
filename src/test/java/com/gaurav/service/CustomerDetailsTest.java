package com.gaurav.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import com.gaurav.dao.CustomerDAOimpl;
import com.gaurav.exception.ServiceException;
import com.gaurav.vo.Customer;


public class CustomerDetailsTest {

	@Mock
	CustomerDAOimpl mockedCustomerDAO;
	public CustomerDetails custdtl;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(CustomerDAOimpl.class);
		custdtl = new CustomerDetails();
	}
	
	
	@Test
	public void getcustdtl_should_return_cust() throws SQLException, ServiceException {
		Customer cust = new Customer();
		when(mockedCustomerDAO.Read(anyInt())).thenReturn(any(Customer.class));
		//when(mockedCustomerDAO.Read(123)).thenReturn(cust);
		boolean actualresult = custdtl.getCustomerDetails(anyInt());
		
		assertEquals(true, actualresult);
		verify(mockedCustomerDAO).Read(123);
		
	}
	
	@Test(expected=ServiceException.class)
	public void getcustdtl_should_through_service_excp() throws SQLException, ServiceException {
		Customer cust = new Customer();
		//Mockito.when(mockedCustomerDAO.Read(Mockito.anyInt())).thenReturn(cust);
		when(mockedCustomerDAO.Read(123)).thenThrow(SQLException.class);
		boolean actualresult = custdtl.getCustomerDetails(anyInt());
		verify(mockedCustomerDAO).Read(123);
		
	}

}
