package com.lt.bean;

public class Course {

	private int courseId;
	private String courseName;
	private String courseDescription;
	private double courseFee;
	private long professorId;
	private String Branch;
	private int Semester;
	private String time_stamp;
	public String getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(String time_stamp) {
		this.time_stamp = time_stamp;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public int getSemester() {
		return Semester;
	}
	public void setSemester(int semester) {
		Semester = semester;
	}
	private long noOfStudent;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String i) {
		this.courseDescription = i;
	}
	public double getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(double courseFee) {
		this.courseFee = courseFee;
	}
	public long getProfessorId() {
		return professorId;
	}
	public void setProfessorId(long professorId) {
		this.professorId = professorId;
	}
	public long getNoOfStudent() {
		return noOfStudent;
	}
//	public Course(int courseId, String courseName, String courseDescription, double courseFee, long professorId,
//			long noOfStudent) {
//		super();
//		this.courseId = courseId;
//		this.courseName = courseName;
//		this.courseDescription = courseDescription;
//		this.courseFee = courseFee;
//		this.professorId = professorId;
//		this.noOfStudent = noOfStudent;
//	}
	public void setNoOfStudent(long noOfStudent) {
		this.noOfStudent = noOfStudent;
	}
	
}
