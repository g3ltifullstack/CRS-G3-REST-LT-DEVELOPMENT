package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.constants.SQLConstantQueries;
import com.lt.utils.DBUtil;

public class UserDAOImpl implements UserDAOInterface {
	private static Logger logger = Logger.getLogger(UserDAOImpl.class);

	@Override
	public User validateUser(String username, String pass) {
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {

			// Declaring prepared statement
			stmt = connection.prepareStatement(SQLConstantQueries.VALIDATE_USER);
			stmt.setString(1, username);
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				User checkeduser = new User();
				checkeduser.setUserId(rs.getInt("userid"));
				checkeduser.setRoleId(rs.getInt("roleid"));

				return checkeduser;
			} else {
				System.out.println("Invalid User Credentials ! ");
				return null;
			}

		} catch (SQLException ex) {

		}
//		
		return null;
	}

	// fetch student from student database against studentId
	@Override
	public Student fetchStudent(int userID) {

		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {

			stmt = connection.prepareStatement(SQLConstantQueries.FETCH_STUDENT);
			stmt.setInt(1, userID);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("studentId"));

				student.setName(rs.getString("studentname"));
				student.setPhoneNumber(rs.getLong("phonenumber"));
				student.setGender(rs.getString("gender"));
				student.setSemester(rs.getInt("semester"));
				student.setBranch(rs.getString("branch"));

				return student;
			}

		} catch (SQLException ex) {

		}
//			
		return null;

	}

	@Override
	public Admin fetchAdmin(int adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor fetchProfessor(int professorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User user) {

		// Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.INSERT_USER);
			// int userId= user.getUserId();
			String username = user.getUserName();
			String password = user.getUserPassword();
			int roleId = user.getRoleId();

			// stmt.setInt(1, userId);
			stmt.setString(1, username);
			stmt.setString(2, password);

			stmt.setInt(3, roleId);
			stmt.setInt(4, 0);

			// Executing query
			stmt.executeUpdate();

		} catch (SQLException ex) {

		}

		return user;
	}

	@Override
	public void updateUser(int userId, User user) {
		// Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			logger.info("Updating the user and executing it");
			stmt = connection.prepareStatement(SQLConstantQueries.UPDATE_USER);
			int userId1 = user.getUserId();
			String username = user.getUserName();
			String password = user.getUserPassword();
			int roleId = user.getRoleId();

			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setInt(3, roleId);
			stmt.setInt(4, userId1);

			// Executing query
			stmt.executeUpdate();
			logger.info("Updated the record");

		} catch (SQLException ex) {
			ex.getMessage();
		}
	}

	// provide details of all admins
	@Override
	public List<Admin> displayAdmins() {

		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement(SQLConstantQueries.DISPLAY_ADMINS);

			ResultSet rs = stmt.executeQuery();

			List<Admin> list = new ArrayList<Admin>();
			logger.info("Display admins --");
			// Creating ArrayList of admin
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("adminid"));
				admin.setName(rs.getString("name"));
				admin.setGender(rs.getString("gender"));
				admin.setPhoneNumber(rs.getLong("phonenumber"));
				admin.setUserid(rs.getInt("userid"));
				list.add(admin);
			}

			// returning list of admins
			return list;
		} catch (SQLException ex) {
			ex.getMessage();
		}

		return null;
	}

	@Override
	public void createStudent(Student student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createProfessor(Professor professor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Student> displayStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> displayProfessors() {
		// TODO Auto-generated method stub
		return null;
	}

}
