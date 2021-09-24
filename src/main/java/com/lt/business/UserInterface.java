package com.lt.business;

import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;

public interface UserInterface {
	/**
	 * 
	 * @param userID
	 * @param newPassword
	 * @return
	 */
	public User validateUser(String username, String password);

	public Student fetchStudent(int studentId);
	/**
	 * @param adminId
	 * @return
	 */
//	public Admin fetchAdmin(int adminId);
	public Professor fetchProfessor(int professorId);
//	public void displayStudents();

	/**
	 * Display Admins
	 */
	public String displayAdmins(Admin admin);

	/**
	 * Login 
	 */
	public void login();	
	public void signUp();
	public boolean updateUser(User user);
	public boolean deleteUser(User user);

	public void createStudent(Student student) ;
	public  User createUser(String name, String password,int roleid);
}

