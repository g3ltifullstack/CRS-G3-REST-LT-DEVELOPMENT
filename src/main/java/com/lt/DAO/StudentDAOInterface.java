package com.lt.DAO;

import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Student;

public interface StudentDAOInterface {
	public boolean createStudent(Student student);
	
	public void addCourse(Student student);

	public void dropCourse(Student student);

	public List<Course> displaySelectedCourses(Student student);
	
	public List<Course> viewAllRegisteredCourses();
}