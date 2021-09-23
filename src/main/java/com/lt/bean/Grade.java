package com.lt.bean;

public class Grade {
	private long courseId;
	private long studentId;
	private String grade;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public Grade(long studentId, String grade) {
		super();
		this.studentId = studentId;
		this.grade = grade;
	}

	public Grade() {
		super();
	}
	@Override
	public String toString() {
		return "Grade [studentId=" + studentId + ", grade=" + grade + "]";
	}

}
