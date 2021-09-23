package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.constants.SQLConstantQueries;
import com.lt.controller.UserRestApi;
import com.lt.utils.DBUtil;

public class StudentDAOImpl implements StudentDAOInterface {
	private static Logger logger = Logger.getLogger(StudentDAOImpl.class);
	public void addCourse(int courseId, Student student) {
		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.ADD_COURSE);

			int studentId= student.getStudentId();

			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);

			//Executing query
			stmt.executeUpdate();
			System.out.println("Course with courseId="+courseId+" added!");

		} catch (SQLException ex) {
			
		}
		
		
	}

	
	public void dropCourse(int courseId, Student student) {
		//Establishing the connection
				Connection connection = DBUtil.getConnection();
				PreparedStatement stmt= null;
				try {

					//Establishing the connection
					stmt=connection.prepareStatement(SQLConstantQueries.DROP_COURSE);
					int studentId= student.getStudentId();

					stmt.setInt(1, studentId);
					stmt.setInt(2, courseId);
					//Executing query
					int rs = stmt.executeUpdate();
					if(rs>0)
					{
						System.out.println("Course dropped !");
						return;

					}
				} catch (SQLException ex) {
					
				}
				
				System.out.println("Course not found !");
		
	}

	public List<Course> displaySelectedCourses(Student student) {
		Connection connection= DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {

			stmt= connection.prepareStatement(SQLConstantQueries.VIEW_SELECTED_COURSES);
			stmt.setInt(1, student.getStudentId());


			ResultSet rs = stmt.executeQuery();

			List<Course> list= new ArrayList<Course>();

			//Creating ArrayList of courses
			while(rs.next())
			{
				Course course = new Course();
				course.setCourseId(rs.getInt("courseid"));
				course.setCourseName(rs.getString("coursename"));
				course.setCourseDescription(rs.getString("coursedescription"));
				course.setTime_stamp(rs.getString("timestamp"));
				list.add(course);

			}

			//returning list of courses
			return list;
		}
		catch(SQLException ex) {
			
		}
		
		return null;
		
	}

	
public List<Course> viewAllRegisteredCourses() {
		// TODO Auto-generated method stub
		return null;
	}


@Override
public Student createStudent(Student student) {
	//Establishing the connection
			Connection connection = DBUtil.getConnection();
			PreparedStatement stmt= null;
			int userid=0;

			try {
				System.out.println("inside try1");

					stmt= connection.prepareStatement(SQLConstantQueries.VIEW_SELECT_USER);
					stmt.setString(1, student.getName());
                    ResultSet rs = stmt.executeQuery();
                  if (rs.next()) 
                   {
                	  userid= rs.getInt("userid");
                   }
                    System.out.println(student.getName());

					
				}
				catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
			
			try {
				System.out.println("inside try2");
				stmt=null;
				if(userid!=0) {
					System.out.println("inside if");
				//Declaring prepared statement and executing query
				stmt = connection.prepareStatement(SQLConstantQueries.INSERT_STUDENT);
				//int userId= user.getUserId();
				String name=student.getName();
				String branch= student.getBranch();
				int semester= student.getSemester();
				long phone=student.getPhoneNumber();
				String gender=student.getGender();
				
				
//INSERT INTO student VALUES(select max(studentid)+1 from student,?,?,?,?,?,?)
				//stmt.setInt(1, userId);
				stmt.setString(1, name);
				stmt.setString(2, gender);
				stmt.setLong(3, phone);
                stmt.setInt(4, semester);
				stmt.setString(5, branch);
				stmt.setBoolean(6,false);
				stmt.setBoolean(7,false);
            	stmt.setInt(8, userid);
				
			
				//Executing query
				stmt.executeUpdate();
//				


			} 
			}catch (SQLException ex) {
				
			}
			
			return student;
	
}


	}


