package com.lt.business;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lt.DAO.StudentDAOInterface;
import com.lt.bean.Course;
import com.lt.bean.Student;


@Service
public class StudentImplService implements StudentInterface {
	private static Logger logger = Logger.getLogger(StudentImplService.class);
    @Autowired
	StudentDAOInterface studentDao;
	
	public void createStudent(Student student) 
	{
		logger.debug("Calling create student Dao");
		studentDao.createStudent(student);
	}

	// add course by student against courseId
	public void addCourse(Student student) {
		logger.debug("Calling add course dao");
		studentDao.addCourse(student);
	}

	// drop course by student against courseId
	public void dropCourse(Student student) {
		logger.debug("Calling drop course dao");
		studentDao.dropCourse(student);
	}

	//display courses selected by student

	public List<Course> displaySelectedCourses(Student student) {
		logger.debug("Calling display selected course dao");

		List<Course> courses = studentDao.displaySelectedCourses(student);
        return courses;

	}


	public List<Course> viewAllRegisteredCourses() {
		return null;
	}

}
