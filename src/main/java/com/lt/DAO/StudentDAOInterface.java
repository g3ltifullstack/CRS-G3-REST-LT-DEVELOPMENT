package com.lt.DAO;

import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Student;

public interface StudentDAOInterface {
	public Student createStudent(Student student);
	
	public void addCourse(int courseId, Student student);

	public void dropCourse(int courseId, Student student);

	public List<Course> displaySelectedCourses(Student student);
	
	public List<Course> viewAllRegisteredCourses();
}
