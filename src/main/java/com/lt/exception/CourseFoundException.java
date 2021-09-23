package com.lt.exception;

public class CourseFoundException extends Exception {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String courseCode;

	/***
	 * Constructor
	 * 
	 * @param courseCode
	 */
	public CourseFoundException(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * Getter method
	 * 
	 * @return course code
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Course with courseCode: " + courseCode + " already present in catalog.";
	}

}
