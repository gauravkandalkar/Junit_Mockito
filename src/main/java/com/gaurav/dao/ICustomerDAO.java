package com.gaurav.dao;

import java.sql.SQLException;

import com.gaurav.vo.Customer;

public interface ICustomerDAO {

	public Customer Read(int customerID) throws SQLException;
	public int Insert(Customer cust) throws SQLException;
	public int Update(Customer cust) throws SQLException;
	public int Delete(int customerID) throws SQLException;
}
