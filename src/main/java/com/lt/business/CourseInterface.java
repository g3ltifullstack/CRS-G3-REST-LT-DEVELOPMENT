package com.lt.business;

import com.lt.bean.Student;

public interface CourseInterface {
	
	public void displayCourses(Student student);
	public void addCourse(int courseId, Student student);
	public void dropCourse(int courseId, Student student);
	

}
