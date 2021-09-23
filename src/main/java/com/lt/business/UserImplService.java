package com.lt.business;

import java.util.Scanner;

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
	UserDAOInterface userDao= new UserDAOImpl();

	//validating users by checking their credentials

	public User validateUser(String username, String password){
		User user= userDao.validateUser(username, password)	;
	//	if(user==null)
			
		return user;

	}

//	User user = new User();
//	Student student;

	
//	public User manageUser(String username, String password) {
//		System.out.println("Manage User--->>");
//		if (username != null && password != null) {
//			System.out.println("Set Username:->");
//			user.setUserName(username);
//			System.out.println("Set Password:->");
//			user.setUserPassword(password);
//		}
//		return user;
//	}


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

//business logic separately and data separately ..client layer limit
//	@Override
//	public void displayStudents() {
//		System.out.println("display student method");
//		StudentDAOImpl studentDAO = new StudentDAOImpl();
//		studentDAO.signUpStudent(student);
//		List<Student> list = new ArrayList<>();
//		System.out.println("Adding List of Students");
//		list.add(new Student(101, "Biswarup", "m", 101, 1, "cse"));
//		list.add(new Student(102, "Akshay", "m", 102, 2, "cse"));
//		list.add(new Student(103, "Akhilesh", "m", 103, 3, "cse"));
//		list.add(new Student(104, "Nikita", "f", 104, 4, "cse"));
//		list.add(new Student(105, "Bhabani", "m", 105, 5, "mechanical"));
//		list.add(new Student(106, "Srinivas", "m", 106, 6, "mca"));
//		System.out.println("Print the List of Student Details : - > " + list);
//	}

	

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
	public User createUser(String name, String password, int roleid) {
		// TODO Auto-generated method stub
		System.out.println("inside create user");
		
		User user = new User();
		user.setUserName(name);
		user.setUserPassword(password);
		user.setRoleId(roleid);
		UserDAOInterface userdao = new UserDAOImpl();
		System.out.println("user created");
		userdao.createUser(user);
		return user;
	}
		
		
//		
//		if (userId != 0 && userName != null && password != null) {
//			System.out.println("Got it");
//			user.setUserId(userId);
//			user.setUserName(userName);
//			user.setUserPassword(password);
//			System.out.println("end reached");
//
//		}
//		System.out.println("limit");
//		sc.close();
//
//	}

//	@Override
//	public void login() {
//		System.out.println("Enter userName");
//		Scanner sc = new Scanner(System.in);
//		String userName = sc.next();
//		System.out.println("Enter password");
//		String password = sc.next();
//		if (userName != null && password != null) {
//			user.setUserName(userName);
//			user.setUserPassword(password);
//
//		}
		

	
}
	



