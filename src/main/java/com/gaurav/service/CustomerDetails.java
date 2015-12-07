package com.gaurav.service;

import java.sql.SQLException;

import com.gaurav.dao.CustomerDAOimpl;
import com.gaurav.exception.ServiceException;
import com.gaurav.vo.Customer;

public class CustomerDetails {

	private boolean result;
	private CustomerDAOimpl custdao;

	public boolean getCustomerDetails(int CustomerID) throws ServiceException {
		custdao = new CustomerDAOimpl();
		result = false;
		try {
			Customer cust = custdao.Read(CustomerID);
			if (cust != null)
				result = true;

		} catch (SQLException e) {
			throw new ServiceException();
		}

		return result;

	}

}
