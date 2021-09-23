package com.lt.business;

import java.util.List;

import com.lt.bean.Professor;
import com.lt.bean.Student;

public interface ProfessorInterface {
	

	public void displayRegisteredStudent();
	public List<Professor> professorDetails(Professor professor);
	public void studentByName();
	
	public void displaySelectedCoursesProfessor(Professor professor);



}
