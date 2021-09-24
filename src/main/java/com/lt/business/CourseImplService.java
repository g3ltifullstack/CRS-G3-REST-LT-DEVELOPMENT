package com.lt.business;

import java.util.List;

import org.apache.log4j.Logger;

import com.lt.DAO.CourseDAOImpl;
import com.lt.DAO.CourseDAOInterface;
import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.exception.CourseNotFoundException;

public class CourseImplService implements CourseInterface {
	private static Logger logger = Logger.getLogger(CourseImplService.class);

	CourseDAOInterface courseDao = new CourseDAOImpl();

	// display list of available courses for student
	public void displayCourses(Student student) {

		List<Course> courses = courseDao.displayCourses(student);
		for (Course course : courses) {

			System.out.println("CourseID: " + course.getCourseId() + " CourseName: " + course.getCourseName()
					+ " CourseDescription: " + course.getCourseDescription());

		}

	}

	public void addCourse(int courseId, Student student) {
		// TODO Auto-generated method stub

	}

	public void dropCourse(int courseId, Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean insertCourse(Course course) {
		System.out.println("json");
		boolean courseToBeDeleted=false;
		try {
			 courseToBeDeleted = courseDao.insertCourse(course);
			if (courseToBeDeleted) {
				logger.info("deleted ");

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return courseToBeDeleted;
	
	}

	@Override
	public boolean deleteCourse(Course course) {
		System.out.println("json");
		boolean courseToBeDeleted=false;
		try {
			 courseToBeDeleted = courseDao.deleteCourse(course);
			if (courseToBeDeleted) {
				logger.info("deleted ");

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return courseToBeDeleted;
	}

}
