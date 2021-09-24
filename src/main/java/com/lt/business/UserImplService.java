package com.lt.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.DAO.AdminDAOImpl;
import com.lt.DAO.AdminDAOInterface;
import com.lt.DAO.UserDAOImpl;
import com.lt.DAO.UserDAOInterface;
import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class UserImplService extends User implements UserInterface {
	UserDAOInterface userDao = new UserDAOImpl();
	User user = new User();
	private static Logger logger = Logger.getLogger(UserImplService.class);
	// validating users by checking their credentials

	public User validateUser(String username, String password) {
		logger.info("*******Validating the User********");
		User user = userDao.validateUser(username, password);
		if (user == null)
			logger.info("No user Found!!");

		return user;
	}

	public Student fetchStudent(int studentId) {
		return userDao.fetchStudent(studentId);
	}

//	@Override
//	public Admin fetchAdmin(int adminId) {
//		AdminDAOInterface adminDAO = new AdminDAOImpl();
//		return adminDAO.fetchAdmin(adminId);
//	}

	public Professor fetchProfessor(int professorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void displayProfessors() {
		// TODO Auto-generated method stub

	}

	public String displayAdmins(Admin admin) {
		List<Admin> adminList = new ArrayList<>();
		System.out.println("json");
		adminList = userDao.displayAdmins(admin);
		String jsonStr = JSONArray.toJSONString(adminList);
		System.out.println("Print json string "+jsonStr);
		return jsonStr;
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
		User user = new User();
		user.setUserName(name);
		user.setUserPassword(password);
		user.setRoleId(roleid);
		UserDAOInterface userdao = new UserDAOImpl();
		userdao.createUser(user);
		return user;
	}

	@Override
	public void login() {
		logger.info("Enter userName");
		Scanner sc = new Scanner(System.in);
		String userName = sc.next();
		logger.info("Enter password");
		String password = sc.next();
		if (userName != null && password != null) {
			user.setUserName(userName);
			user.setUserPassword(password);

		}
		sc.close();
	}

	@Override
	public boolean updateUser(User user) {
		
		System.out.println("json");
		boolean adminList = userDao.updateUser(user);
		return adminList;
	}

	@Override
	public boolean deleteUser(User user) {
		System.out.println("json");
		boolean adminList = userDao.deleteUser(user);
		return adminList;
	}
}
