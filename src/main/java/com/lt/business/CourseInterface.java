package com.lt.business;

import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Student;

public interface CourseInterface {
	
	public List<Course> displayCourses(Student student);
	public void addCourse(int courseId, Student student);
	public void dropCourse(int courseId, Student student);
	public boolean insertCourse(Course course);
	public boolean deleteCourse(Course course);
	
}