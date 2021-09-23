package com.lt.business;

import java.util.List;

import com.lt.DAO.StudentDAOImpl;
import com.lt.DAO.StudentDAOInterface;
import com.lt.bean.Course;
import com.lt.bean.Student;


public class StudentImplService implements StudentInterface {

	StudentDAOInterface studentDao= new StudentDAOImpl();
	
	public Student createStudent(Student student) 
	{
		studentDao.createStudent(student);
		return studentDao.createStudent(student); 
	}

	// add course by student against courseId
	public void addCourse(int courseId, Student student) {
		studentDao.addCourse(courseId, student);
	}

	// drop course by student against courseId
	public void dropCourse(int courseId,Student student) {
		studentDao.dropCourse(courseId, student);
	}

	//display courses selected by student

	public void displaySelectedCourses(Student student) {
		System.out.println("***********************************LIST OF SELECTED COURSES******************************");	
		System.out.println("COURSE ID      COURSE NAME               COURSE DESCRIPTION           TIME STAMP             ");
		List<Course> courses = studentDao.displaySelectedCourses(student);
		courses.forEach(course -> System.out.println(course.getCourseId()+"               "+course.getCourseName()+"                    "+course.getCourseDescription()+"              "+course.getTime_stamp()));


	}


	public List<Course> viewAllRegisteredCourses() {
		return null;
	}

}
