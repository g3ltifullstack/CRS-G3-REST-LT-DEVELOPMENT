package com.lt.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lt.DAO.CourseDAOImpl;
import com.lt.DAO.CourseDAOInterface;
import com.lt.bean.Course;
import com.lt.bean.Student;




@Service
public class CourseImplService implements CourseInterface {
	CourseDAOInterface courseDao= new CourseDAOImpl();

	// display list of available courses for student 
	public List<Course> displayCourses(Student student) {
		
		
		List<Course> courses = courseDao.displayCourses(student);
		for(Course course:courses) {
			
				System.out.println("CourseID: " +course.getCourseId()+" CourseName: "+course.getCourseName()+" CourseDescription: "+course.getCourseDescription());
			
		}
		return courses;
		
	}

	

	public void addCourse(int courseId, Student student) {
		// TODO Auto-generated method stub
		
		
	}

	public void dropCourse(int courseId, Student student) {
		// TODO Auto-generated method stub
		
	}


}
