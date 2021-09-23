package com.lt.business;

import java.util.List;

import com.lt.bean.Professor;
import com.lt.bean.Student;

public interface ProfessorInterface {
	

	public String displayRegisteredStudent();

	public String studentByName(Student student);
	
	public void displaySelectedCoursesProfessor(Professor professor);
	public String professorDetails(Professor professor);



}
