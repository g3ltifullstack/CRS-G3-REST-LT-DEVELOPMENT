package com.lt.business;

import java.util.List;

import org.apache.log4j.Logger;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.lt.DAO.CourseDAOInterface;
import com.lt.bean.Course;
import com.lt.bean.Student;

@Service
public class CourseImplService implements CourseInterface {
	private static Logger logger = Logger.getLogger(CourseImplService.class);

	@Autowired
	CourseDAOInterface courseDao;

	// display list of available courses for student
	public List<Course> displayCourses(Student student) {

		List<Course> courses = courseDao.displayCourses(student);
		for (Course course : courses) {

			logger.debug("CourseID: " + course.getCourseId() + " CourseName: " + course.getCourseName()
					+ " CourseDescription: " + course.getCourseDescription());

		}
		return courses;

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
		boolean courseToBeDeleted = false;
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
		boolean courseToBeDeleted = false;
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
