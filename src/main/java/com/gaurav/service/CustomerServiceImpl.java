package com.gaurav.service;

import java.sql.SQLException;

import com.gaurav.dao.CustomerDAOimpl;
import com.gaurav.dao.ICustomerDAO;
import com.gaurav.exception.ServiceException;
import com.gaurav.vo.Customer;

public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDAO custdao;

	@Override
	public boolean getCustomerDetails(int CustomerID) throws ServiceException {
		boolean result = false;
		try {
			Customer cust = getCustdao().Read(CustomerID);
			if (cust != null)
				result = true;

		} catch (SQLException e) {
			throw new ServiceException(e);
		}

		return result;

	}

	@Override
	public boolean createNewCustomer(Customer cust) throws ServiceException {
		boolean result = false;
		try {
			int resultint = getCustdao().Insert(cust);
			if (resultint > 0)
				result = true;
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
		return result;

	}

	@Override
	public boolean updateCustomer(int customerID) throws ServiceException {
		boolean result = false;
		try {
			Customer cust = getCustdao().Read(customerID);
			cust.setName("updated name");
			int resultint = getCustdao().Update(cust);
			if (resultint > 0)
				result = true;
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
		return result;

	}

	@Override
	public boolean deleteCustomer(int customerID) throws ServiceException {
		boolean result = false;
		try {
			int resultint = getCustdao().Delete(customerID);
			if (resultint > 0)
				result = true;
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
		return result;

	}
	

	public ICustomerDAO getCustdao() {
		return custdao;
	}

	public void setCustdao(ICustomerDAO custdao) {
		this.custdao = custdao;
	}

}
