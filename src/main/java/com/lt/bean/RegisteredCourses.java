package com.lt.bean;

public class RegisteredCourses {
	private long courseId;
	private String courseName;
	private String courseDetails;
	private long noOfStudents;
	private long professorId;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDetails() {
		return courseDetails;
	}

	public void setCourseDetails(String courseDetails) {
		this.courseDetails = courseDetails;
	}

	public long getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(long noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(long professorId) {
		this.professorId = professorId;
	}

}
