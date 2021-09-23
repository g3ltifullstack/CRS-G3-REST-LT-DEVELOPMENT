package com.lt.DAO;

import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Grade;
import com.lt.bean.Student;

public interface GradeDAOInterface {
	
	public List<Course> displayGrades(Student student);
	public void uploadGrades(Grade grade);

}
