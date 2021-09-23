package com.lt.bean;

public class GradeCard {
	private long gradeCardId;
	private long studentId;
	private String gradeName;

	public long getGradeCardId() {
		return gradeCardId;
	}

	public void setGradeCardId(long gradeCardId) {
		this.gradeCardId = gradeCardId;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

}
