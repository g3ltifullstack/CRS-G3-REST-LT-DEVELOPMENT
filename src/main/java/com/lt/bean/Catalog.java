package com.lt.bean;

/**
 * @author Hp
 *
 */
public class Catalog {
	private long courseId;
	private long professorId;
	private long courseCatalogId;

	/**
	 * @return course id
	 */
	public long getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId
	 */
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return professor id
	 */
	public long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(long professorId) {
		this.professorId = professorId;
	}

	public long getCourseCatalogId() {
		return courseCatalogId;
	}

	public void setCourseCatalogId(long courseCatalogId) {
		this.courseCatalogId = courseCatalogId;
	}

}
