package com.lt.exception;

import org.apache.log4j.Logger;



public class UserNotFoundException extends Exception {

	private static Logger logger = Logger.getLogger(UserNotFoundException.class);
	public UserNotFoundException() {
		logger.error("user not found exception ");
	};
	
	public UserNotFoundException(String name ) {
		super(name);
	};
}
