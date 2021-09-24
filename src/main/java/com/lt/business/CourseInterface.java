package com.lt.business;

import com.lt.bean.Course;
import com.lt.bean.Student;

public interface CourseInterface {
	
	public void displayCourses(Student student);
	public void addCourse(int courseId, Student student);
	public void dropCourse(int courseId, Student student);
	public boolean insertCourse(Course course);
	public boolean deleteCourse(Course course);
	
}
