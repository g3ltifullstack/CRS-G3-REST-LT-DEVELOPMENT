package com.lt.DAO;


import java.util.List;

import com.lt.bean.Admin;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.exception.StudentNotFoundForApprovalException;

public interface AdminDAOInterface {
	public User validateUser(String username, String pass);

	public Admin fetchAdmin(int adminid);

	public void createAdmin(Admin admin);

	public void updateAdmin(int adminID, Admin admin);
	/**
	 * Method to display all Admins 
	 * @return List of Admins 
	 */
	public List<Admin> displayAdmins();
	/**
	 * Approve Student using SQL commands
	 * @param studentId
	 * @throws StudentNotFoundException
	 */
	public void approveStudent(int studentId) throws StudentNotFoundForApprovalException;

	public List<Student> displayAwaitingAdmissionOfStudents();

}
