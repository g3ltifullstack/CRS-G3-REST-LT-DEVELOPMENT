package com.lt.business;

import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Student;

public interface StudentInterface {

	public void createStudent(Student student);
		
	public void addCourse(int courseId, Student student);

	public void dropCourse(int courseId, Student student);

	public void displaySelectedCourses(Student student);
	
	public List<Course> viewAllRegisteredCourses();
	
}
