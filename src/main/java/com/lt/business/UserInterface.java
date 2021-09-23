package com.lt.business;

import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;

public interface UserInterface {
	public User validateUser(String username, String password);

	public Student fetchStudent(int studentId);

	public Admin fetchAdmin(int adminId);

	public Professor fetchProfessor(int professorId);

//	public void displayStudents();

	public void displayProfessors();

	public void displayAdmins();

//	public void login();
//
	public void signUp();
	
	public void createStudent(Student student) ;
	public  User createUser(String name, String password,int roleid);
}

