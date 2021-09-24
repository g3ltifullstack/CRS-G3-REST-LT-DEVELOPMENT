package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.constants.SQLConstantQueries;
import com.lt.utils.DBUtil;


@Repository
public class StudentDAOImpl implements StudentDAOInterface {
	private static Logger logger = Logger.getLogger(StudentDAOImpl.class);

	public void addCourse(Student student) {
		//Establishing the connection
		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt= null;

		try {
			//Declaring prepared statement and executing query
			stmt = connection.prepareStatement(SQLConstantQueries.ADD_COURSE);

			

			stmt.setInt(1, student.getStudentId());
			stmt.setInt(2, student.getCourseid());

			//Executing query
			stmt.executeUpdate();
			logger.debug("Course with courseId="+student.getCourseid()+" added!");

		} catch (SQLException ex) {
			
		}
		
		
	}

	
	public void dropCourse(Student student) {
		//Establishing the connection
				Connection connection = DBUtil.getConnection();
				PreparedStatement stmt= null;
				try {

					//Establishing the connection
					stmt=connection.prepareStatement(SQLConstantQueries.DROP_COURSE);
					

					stmt.setInt(1, student.getStudentId());
					stmt.setInt(2, student.getCourseid());
					//Executing query
					int rs = stmt.executeUpdate();
					if(rs>0)
					{
						logger.debug("Course with courseId="+student.getCourseid()+" dropped !");
						return;

					}
				} catch (SQLException ex) {
					
				}
				
				
		
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

			logger.debug("Returning list of courses");
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
				

					stmt= connection.prepareStatement(SQLConstantQueries.VIEW_SELECT_USER);
					stmt.setString(1, student.getName());
                    ResultSet rs = stmt.executeQuery();
                  if (rs.next()) 
                   {
                	  userid= rs.getInt("userid");
                   }
                    

					
				}
				catch(SQLException ex) {
					System.out.println(ex.getMessage());
				}
			
			try {
				
				stmt=null;
				if(userid!=0) {
					
				//Declaring prepared statement and executing query
				stmt = connection.prepareStatement(SQLConstantQueries.INSERT_STUDENT);
				//int userId= user.getUserId();
				String name=student.getName();
				String branch= student.getBranch();
				int semester= student.getSemester();
				long phone=student.getPhoneNumber();
				String gender=student.getGender();
				
				

				//stmt.setInt(1, userId);
				stmt.setString(1, name);
				stmt.setString(2, gender);
				stmt.setLong(3, phone);
                stmt.setInt(4, semester);
				stmt.setString(5, branch);
				stmt.setInt(6, userid);			
				logger.debug("Executing insert student");
				stmt.executeUpdate();
				

//	           


			} 
			}catch (SQLException ex) {
				
			}
			
			return student;
	
}


	}


