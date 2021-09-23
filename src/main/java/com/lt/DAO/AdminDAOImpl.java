package com.lt.DAO;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.lt.bean.Admin;
import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.constants.SQLConstantQueries;
import com.lt.exception.CourseFoundException;
import com.lt.exception.StudentNotFoundForApprovalException;
import com.lt.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminDAOImpl implements AdminDAOInterface {
	private static Logger logger = Logger.getLogger(AdminDAOImpl.class);

	@Override
	public User validateUser(String username, String pass) {
		// Step 2
		// Declare the Connection or prepared statement variable here
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			// // Step 3 Register Driver here and create connection and Step 4 make/open a
			// connection

			logger.info("Connecting to database...");
			conn = DBUtil.getConnection();

			// STEP 4: Execute a query
			System.out.println("Creating statement...");

			// Declaring prepared statement
			stmt = conn.prepareStatement(SQLConstantQueries.VALIDATE_USER);
			stmt.setString(1, username);
			stmt.setString(2, pass);
			// STEP 5: Extract data from result set

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				User checkeduser = new User();
				checkeduser.setUserId(rs.getInt("userid"));
				checkeduser.setRoleId(rs.getInt("rollid"));

				return checkeduser;
			}

		} catch (SQLException ex) {
			ex.getMessage();
		}
		logger.info("Goodbye!");
		return null;
	}

	// * // fetch admin from admin database against admin Id
	@Override
	public List<Admin> fetchAdmin(Admin admin) {
		List<Admin> list = new ArrayList<Admin>();

		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement
			stmt = connection.prepareStatement(SQLConstantQueries.FETCH_ADMIN);
			stmt.setString(1, admin.getName());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println("Entering and setting admin data");
				admin.setAdminId(rs.getInt("adminid"));
				admin.setName(rs.getString("name"));
				admin.setPhoneNumber(rs.getLong("phonenumber"));
				admin.setGender(rs.getString("gender"));
				list.add(admin);

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return list;
	}

	// create a new admin
	@Override
	public void createAdmin(Admin admin) {

		// Establishing the connection
		System.out.println("establishing connection");
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.INSERT_ADMIN);
			int adminid = admin.getAdminId();
			String name = admin.getName();
			String gender = admin.getGender();
			long phoneNo = admin.getPhoneNumber();
			int userid = admin.getUserid();

			stmt.setInt(1, adminid);
			stmt.setString(2, name);
			stmt.setString(3, gender);
			stmt.setLong(4, phoneNo);
			stmt.setInt(5, userid);

			// Executing query
			stmt.executeUpdate();
			logger.info(("Admin" + " added!"));

		} catch (SQLException ex) {
			ex.getMessage();
		}
	}

	// update admin against adminId
	@Override
	public void updateAdmin(int adminID, Admin admin) {

		// Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.UPDATE_ADMIN);
			int adminid = admin.getAdminId();
			String name = admin.getName();
			long phoneNo = admin.getPhoneNumber();
			String gender = admin.getGender();

			stmt.setString(1, name);
			stmt.setString(2, gender);
			stmt.setLong(3, phoneNo);
			stmt.setInt(4, adminid);

			// Executing query
			stmt.executeUpdate();
			System.out.println(("Admin details updated !"));

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	@Override
	public List<Admin> displayAdmins() {

		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = connection.prepareStatement(SQLConstantQueries.DISPLAY_ADMINS);

			ResultSet rs = stmt.executeQuery();

			List<Admin> list = new ArrayList<Admin>();

			// Creating ArrayList of admin
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdminId(rs.getInt("AdminID"));
				admin.setName(rs.getString("Name"));
				admin.setPhoneNumber(rs.getLong("PhoneNumber"));
				admin.setGender(rs.getString("Gender"));

				list.add(admin);

			}

			// returning list of admins
			return list;
		} catch (SQLException ex) {
			ex.getMessage();
		}

		return null;
	}

	/**
	 * Approve Student using SQL commands
	 * 
	 * @param studentId
	 * @throws StudentNotFoundException
	 * 
	 */
	@Override
	public void approveStudent(int studentId) throws StudentNotFoundForApprovalException {

		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = SQLConstantQueries.APPROVE_STUDENT_QUERY;
			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, studentId);
			int row = stmt.executeUpdate();

			logger.info(row + " student approved.");
			if (row == 0) {
				logger.error("Student with studentId: " + studentId + " not found.");
				throw new StudentNotFoundForApprovalException(studentId);
			}

			logger.info("Student with studentId: " + studentId + " approved by admin.");

		} catch (SQLException se) {

			logger.error(se.getMessage());

		}

	}

	/**
	 * Fetch Students yet to approved using SQL commands
	 * 
	 * @return List of Students yet to approved
	 */
	@Override
	public List<Student> displayAwaitingAdmissionOfStudents() {
		Connection connection = DBUtil.getConnection();

		PreparedStatement stmt = null;
		List<Student> userList = new ArrayList<Student>();
		try {

			String sql = SQLConstantQueries.VIEW_PENDING_ADMISSION_QUERY;
			stmt = connection.prepareStatement(sql);
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {

				Student user = new Student();
				user.setStudentId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setGender(resultSet.getString(3));
				user.setPhoneNumber(resultSet.getInt(4));
				user.setSemester(resultSet.getInt(5));
				user.setBranch(resultSet.getString(6));
				user.setUserId(resultSet.getInt(7));

				userList.add(user);

			}

			logger.info(userList.size() + " students have pending-approval.");

		} catch (SQLException se) {

			logger.error(se.getMessage());

		}

		return userList;

	}

	@Override
	public void addCourse(Course course) throws CourseFoundException {
		Connection connection = DBUtil.getConnection();

		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(SQLConstantQueries.INSERT_COURSE);
			int courseID = course.getCourseId();
			String title = course.getCourseName();
			String description = course.getCourseDescription();
			int semester = course.getSemester();
			String branch = course.getBranch();

			stmt.setInt(1, courseID);
			stmt.setString(2, title);
			stmt.setString(3, description);
			stmt.setInt(4, semester);
			stmt.setString(5, branch);

			// Executing query
			stmt.executeUpdate();
			logger.info("Course added!");
		} catch (SQLException se) {

			logger.error(se.getMessage());
			throw new CourseFoundException(course.getCourseId());

		}
	}

//	@Override
//	public List<Course> viewCourses(Course course) {
//		//Establishing the connection
//		Connection connection= DBUtil.getConnection();
//
//		//Declaring prepared statement and executing query
//		PreparedStatement stmt= null;
//		 int semester=student.getSemester();
//		 
//		 String branch=student.getBranch();
//		
//		try {
//
//			stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_COURSES);
//			stmt.setInt(1, semester);
//			stmt.setString(2,branch);
//
//			ResultSet rs = stmt.executeQuery();
//
//			List<Course> list= new ArrayList<Course>();
//
//			//Creating ArrayList of Course
//			while(rs.next())
//			{
//				
//				Course course = new Course();
//				course.setBranch(branch);
//				course.setSemester(semester);
//				course.setCourseId(rs.getInt("courseid"));
//				course.setCourseName(rs.getString("coursename"));
//				course.setCourseDescription(rs.getString("coursedescription"));
//			//	course.setCatalogId(rs.getInt("CatalogId"));
//				list.add(course);
//
//			}
//
//			return list;
//		}
//		catch(SQLException ex) {
//			
//		}
////		finally{
////			closeConnection(connection,stmt);
////		}
//		
//		return null;
//		
//	}
//	}

}
