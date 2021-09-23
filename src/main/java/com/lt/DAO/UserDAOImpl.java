package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.constants.SQLConstantQueries;
import com.lt.utils.DBUtil;

@Repository
public class UserDAOImpl implements UserDAOInterface {

	public User validateUser(String username, String pass) {
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			
			//Declaring prepared statement
			stmt=connection.prepareStatement(SQLConstantQueries.VALIDATE_USER);
			stmt.setString(1, username);
			stmt.setString(2,pass);
			ResultSet rs = stmt.executeQuery();

			if(rs.next() )
			{
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

	public Professor fetchProfessor(int professorId) {
		// TODO Auto-generated method stub
		return null;
	}


public User createUser(User user) {

		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.INSERT_USER);
			//int userId= user.getUserId();
			String username=user.getUserName();
			String password= user.getUserPassword();
			int roleId= user.getRoleId();

			//stmt.setInt(1, userId);
			stmt.setString(1, username);
			stmt.setString(2, password);

			stmt.setInt(3, roleId);
			stmt.setInt(4, 0);

			//Executing query
			stmt.executeUpdate();
//			System.out.println("rs1 ");
//			ResultSet rs = stmt.executeQuery();
//			System.out.println("rs2 ");

			 

            
//                if (rs.next()) {
//                	System.out.println("user inserted ");
//
// 
//
//                } else {
//                    System.out.println("not inserted");
//                }
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

}
