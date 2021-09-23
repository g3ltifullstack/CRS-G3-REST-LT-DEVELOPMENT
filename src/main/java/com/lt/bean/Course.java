package com.lt.bean;

public class Course {

	private int courseId;
	private String courseName;
	private String courseDescription;
	private double courseFee;
	private long professorId;
	private String Branch;
	private int Semester;
	private long noOfStudent;
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

	public void setNoOfStudent(long noOfStudent) {
		this.noOfStudent = noOfStudent;
	}

	/**
	 * @param courseId
	 * @param courseName
	 * @param courseDescription
	 * @param courseFee
	 * @param professorId
	 * @param branch
	 * @param semester
	 * @param noOfStudent
	 * @param time_stamp
	 */
	public Course(int courseId, String courseName, String courseDescription, double courseFee, long professorId,
			String branch, int semester, long noOfStudent, String time_stamp) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseFee = courseFee;
		this.professorId = professorId;
		Branch = branch;
		Semester = semester;
		this.noOfStudent = noOfStudent;
		this.time_stamp = time_stamp;
	}

	public Course() {
		super();
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", courseFee=" + courseFee + ", professorId=" + professorId + ", Branch=" + Branch
				+ ", Semester=" + Semester + ", noOfStudent=" + noOfStudent + ", time_stamp=" + time_stamp + "]";
	}

}
