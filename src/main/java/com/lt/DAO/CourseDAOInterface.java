package com.lt.DAO;

import com.lt.bean.Course;
import com.lt.bean.Student;
import java.util.List;


public interface CourseDAOInterface {
	public List<Course> displayCourses(Student student);
	//public void addCourse(int courseId, Student student);
	//public void dropCourse(int courseId, Student student);

}
