package com.lt.exception;

public class CourseNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		String msg="No such user exists ! Verify UserID again ";
		return msg;
	}
}