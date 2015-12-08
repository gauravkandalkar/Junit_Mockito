package com.gaurav.dao;

import java.sql.SQLException;
import java.util.List;

import com.gaurav.vo.OrderVO;

public interface IOrderDAO {
	String getOrderbyID(String orderID) throws SQLException;

	List<OrderVO> getOrdersForCustomer(int custID) throws SQLException;
}
