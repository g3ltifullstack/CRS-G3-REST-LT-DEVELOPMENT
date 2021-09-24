package com.lt.DAO;

import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.exception.CourseNotFoundException;

import java.util.List;


public interface CourseDAOInterface {
	public List<Course> displayCourses(Student student);
	/**
	 * Add Course using SQL commands
	 * 
	 * @param course
	 */
	public boolean insertCourse(Course course);

	/**
	 * Delete Course using SQL commands
	 * 
	 * @param courseCode
	 * @throws CourseNotFoundException
	 */
	public boolean deleteCourse(Course course);

}
