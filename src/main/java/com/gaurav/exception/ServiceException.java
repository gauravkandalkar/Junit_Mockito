package com.gaurav.exception;

import java.sql.SQLException;

public class ServiceException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException(SQLException e) {
		super(e);
	}
}
