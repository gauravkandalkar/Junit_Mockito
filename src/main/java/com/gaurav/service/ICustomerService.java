package com.gaurav.service;

import com.gaurav.exception.ServiceException;
import com.gaurav.vo.Customer;

public interface ICustomerService {

	boolean getCustomerDetails(int CustomerID) throws ServiceException;

	boolean createNewCustomer(Customer cust) throws ServiceException;

	boolean updateCustomer(int customerID) throws ServiceException;

	boolean deleteCustomer(int customerID) throws ServiceException;

}