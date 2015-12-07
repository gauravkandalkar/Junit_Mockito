package com.gaurav.service;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.gaurav.dao.CustomerDAOimpl;
import com.gaurav.exception.ServiceException;
import com.gaurav.vo.Customer;


public class CustomerDetailsTest {

	@Mock
	CustomerDAOimpl mockedCustomerDAO = new CustomerDAOimpl();
	private CustomerDetails custdtl;
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(CustomerDetails.class);
		custdtl = new CustomerDetails();
	}
	
	
	@Test
	public void test() throws SQLException, ServiceException {
		Customer cust = new Customer();
		Mockito.when(mockedCustomerDAO.Read(Mockito.anyInt())).thenReturn(cust);
		boolean actualresult = custdtl.getCustomerDetails(Mockito.anyInt());
		assertEquals(true, actualresult);
	}

}
