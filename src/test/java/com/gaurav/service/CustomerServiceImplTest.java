package com.gaurav.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gaurav.dao.ICustomerDAO;
import com.gaurav.exception.ServiceException;
import com.gaurav.vo.Customer;

public class CustomerServiceImplTest {

	@Mock
	ICustomerDAO mockedcustdao;
	private CustomerServiceImpl custser;
	private Customer cust;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		custser = new CustomerServiceImpl();
		custser.setCustdao(mockedcustdao);
		cust = new Customer();
	}

	@Test
	public void createNewCust_creates_new_cust() throws SQLException, ServiceException {
		when(mockedcustdao.Insert(any(Customer.class))).thenReturn(1);
		assertTrue(custser.createNewCustomer(cust));
		verify(mockedcustdao).Insert(cust);
	}

	@Test
	public void createNewCust_doesNot_create_cust() throws SQLException, ServiceException {
		when(mockedcustdao.Insert(cust)).thenReturn(0);
		assertFalse(custser.createNewCustomer(cust));
		verify(mockedcustdao).Insert(cust);

	}

	@Test(expected = ServiceException.class)
	public void createNewCust_throws_exception() throws SQLException, ServiceException {
		when(mockedcustdao.Insert(any(Customer.class))).thenThrow(SQLException.class);
		custser.createNewCustomer(cust);
		verify(mockedcustdao).Insert(cust);

	}

	@Test
	public void getCustomerDetails_read_cust() throws SQLException, ServiceException {
		when(mockedcustdao.Read(anyInt())).thenReturn(cust);
		assertTrue(custser.getCustomerDetails(anyInt()));
		verify(mockedcustdao).Read(anyInt());
	}

	@Test
	public void getCustomerDetails_doesNot_read_cust() throws SQLException, ServiceException {
		when(mockedcustdao.Read(anyInt())).thenReturn(null);
		assertFalse(custser.getCustomerDetails(anyInt()));
		verify(mockedcustdao).Read(anyInt());
	}

	@Test(expected = ServiceException.class)
	public void getCustomerDetails_throws_exception() throws SQLException, ServiceException {
		when(mockedcustdao.Read(anyInt())).thenThrow(SQLException.class);
		custser.getCustomerDetails(anyInt());
		verify(mockedcustdao).Read(1);

	}

	@Test
	public void updateCustomer_update_cust() throws SQLException, ServiceException {
		when(mockedcustdao.Read(anyInt())).thenReturn(cust);
		when(mockedcustdao.Update(any(Customer.class))).thenReturn(1);
		
		assertTrue(custser.updateCustomer(anyInt()));
		
		verify(mockedcustdao).Read(anyInt());
		verify(mockedcustdao).Update(cust);
	}

	@Test
	public void updateCustomer_doesNot_update_cust() throws SQLException, ServiceException {
		when(mockedcustdao.Read(anyInt())).thenReturn(cust);
		when(mockedcustdao.Update(any(Customer.class))).thenReturn(0);
		
		assertFalse(custser.updateCustomer(anyInt()));
		
		verify(mockedcustdao).Read(anyInt());
		verify(mockedcustdao).Update(cust);
	}

	@Test(expected = ServiceException.class)
	public void updateCustomer_throws_exception() throws SQLException, ServiceException {
		when(mockedcustdao.Read(anyInt())).thenReturn(cust);
		when(mockedcustdao.Update(any(Customer.class))).thenThrow(SQLException.class);
		
		assertFalse(custser.updateCustomer(anyInt()));
		
		verify(mockedcustdao).Read(anyInt());
		verify(mockedcustdao).Update(cust);

	}

}
