package com.lt.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lt.DAO.StudentDAOImpl;
import com.lt.DAO.StudentDAOInterface;
import com.lt.bean.Course;
import com.lt.bean.Student;

@Service
public class StudentImplService implements StudentInterface {

	StudentDAOInterface studentDao= new StudentDAOImpl();
	
	public void createStudent(Student student) 
	{
		studentDao.createStudent(student);
	}

	// add course by student against courseId
	public void addCourse(Course course, Student student) {
		studentDao.addCourse(course, student);
	}

	// drop course by student against courseId
	public void dropCourse(Course course,Student student) {
		studentDao.dropCourse(course, student);
	}

	//display courses selected by student

	public List<Course> displaySelectedCourses(Student student) {

		List<Course> courses = studentDao.displaySelectedCourses(student);
        return courses;

	}


	public List<Course> viewAllRegisteredCourses() {
		return null;
	}

}
