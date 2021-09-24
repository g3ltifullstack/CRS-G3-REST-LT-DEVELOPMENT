package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.constants.SQLConstantQueries;
import com.lt.utils.DBUtil;

@Repository
public class UserDAOImpl implements UserDAOInterface {

	private static Logger logger = Logger.getLogger(UserDAOImpl.class);
	public User validateUser(String username, String pass) {
		
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;
     logger.debug("outer try ");
		try {
		   
			//Declaring prepared statement
			stmt=connection.prepareStatement(SQLConstantQueries.VALIDATE_USER);
			stmt.setString(1, username);
			stmt.setString(2,pass);
			ResultSet rs = stmt.executeQuery();
			 logger.debug("resultset executed for  validate user ");
			if(rs.next() )
			{
				 logger.warn("resultset executed if block ");
				User checkeduser = new User();
				checkeduser.setUserId( rs.getInt("userid") );
				checkeduser.setRoleId(rs.getInt("roleid"));
				

				return checkeduser;
			}
			else
			{
				System.out.println("Invalid User Credentials ! ");
				return null;
			}

		} catch (SQLException ex) {
			
		}
//		
		return null;
	}

	
	// fetch student from student database against studentId
		public Student fetchStudent(int userID){

			Connection connection = DBUtil.getConnection();
			PreparedStatement stmt= null;

			try {

				stmt=connection.prepareStatement(SQLConstantQueries.FETCH_STUDENT);
				stmt.setInt(1, userID);

				ResultSet rs = stmt.executeQuery();

				while(rs.next())
				{
					Student student= new Student();
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

	public Admin fetchAdmin(int adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Professor fetchProfessor(int userid) {
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			
			stmt=connection.prepareStatement(SQLConstantQueries.FETCH_PROFESSOR);
			stmt.setInt(1, userid);

			ResultSet rs = stmt.executeQuery();

			while(rs.next())
			{
				Professor professor= new Professor();
				professor.setProfessorId(rs.getInt("professorid"));
               professor.setProfessorName(rs.getString("professorname"));
				professor.setDepartment(rs.getString("department"));
				professor.setEmail(rs.getString("email"));
				professor.setGender(rs.getString("gender"));
			return professor;
			}


		} catch (SQLException ex) {
			
		}
//		
		return null;
	}


public User createUser(User user) {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;
    logger.debug("inside user dao ");
		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.INSERT_USER);
			//int userId= user.getUserId();
			String username=user.getUserName();
			String password= user.getUserPassword();
			int roleId= user.getRoleId();
			logger.warn("getting value inside user dao");

			//stmt.setInt(1, userId);
			stmt.setString(1, username);
			stmt.setString(2, password);
            stmt.setInt(3, roleId);
			stmt.setInt(4, 0);

			logger.debug("executing script");
		int execute=	stmt.executeUpdate();
		
		if(execute>0) {
			logger.debug("user updated");
		}
		else {
			logger.error("user not updated");
		}
//		
//           


		} catch (SQLException ex) {
			
		}
		
		return user;
	}

	public void createStudent(Student student) {
		
		
	}

	public void createProfessor(Professor professor) {
		// TODO Auto-generated method stub
		
	}

	public void createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	public List<Student> displayStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Professor> displayProfessors() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Admin> displayAdmins() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean updateUser(User user) {
		boolean isUpdated = false;
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
			isUpdated = true;

		} catch (SQLException ex) {
			ex.getMessage();
		}
		return isUpdated;

	}
	
	@Override
	public boolean deleteUser(User user) {
		// Establishing the connection
		boolean isDeleted = false;
		Connection connection = DBUtil.getConnection();
		try {

			// Establishing the connection
			PreparedStatement stmt = null;

			stmt = connection.prepareStatement(SQLConstantQueries.DELETE_USER);
			stmt.setInt(1, user.getUserId());
			// Executing query
			int rs = stmt.executeUpdate();
			if (rs > 0) {
				isDeleted=true;
				return isDeleted;
			}
//							else 
//							throw new UserNotFoundException();

		} catch (SQLException ex) {
			ex.getMessage();
		}
		return isDeleted;
	}

}
