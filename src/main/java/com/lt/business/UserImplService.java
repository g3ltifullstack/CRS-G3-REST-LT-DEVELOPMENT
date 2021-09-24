package com.lt.business;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.DAO.StudentDAOImpl;
import com.lt.DAO.UserDAOImpl;
import com.lt.DAO.UserDAOInterface;
import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;


@Service
public class UserImplService implements UserInterface {
	@Autowired
	UserDAOInterface userDao;

	//validating users by checking their credentials

	public User validateUser(String username, String password){
		User user= userDao.validateUser(username, password)	;
	//	if(user==null)
			
		return user;
	}


	public Student fetchStudent(int studentId){
		return userDao.fetchStudent(studentId);
	}
	

	public Admin fetchAdmin(int adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Professor fetchProfessor(int professorId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	public void displayProfessors() {
		// TODO Auto-generated method stub

	}


	public void displayAdmins() {
		// TODO Auto-generated method stub

	}

	
	public void signUp() {
		
	}

	@Override
	public void createStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User createUser(User user) {
		userDao.createUser(user);
		return user;
	}
	
		

	
}
	



