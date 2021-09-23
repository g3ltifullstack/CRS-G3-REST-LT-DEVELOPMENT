package com.lt.business;

import com.lt.bean.Student;


public interface GradesInterface {
//	public void displayGrades(List<String> listNumberOfStudentGrades);

	public void displayGrades(Student student);
	public void uploadGrades(int studentId, int courseId, String grade) ;

}
