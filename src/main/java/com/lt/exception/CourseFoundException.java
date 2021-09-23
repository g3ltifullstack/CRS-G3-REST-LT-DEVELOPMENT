package com.lt.exception;

public class CourseFoundException extends Exception {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private int courseId;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CourseFoundException [courseId=" + courseId + "]";
	}

	public CourseFoundException(int courseId) {
		super();
		this.courseId = courseId;
	}

}
