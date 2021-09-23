package com.lt.exception;

import org.apache.log4j.Logger;



public class UserNotFoundException extends Exception {

	/**
	 * @Param user not found exception
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(UserNotFoundException.class);
	public UserNotFoundException() {
		logger.error("user not found exception ");
	};
	
	public UserNotFoundException(String name ) {
		super(name);
	};
}
