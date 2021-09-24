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
public class CourseDAOImpl implements CourseDAOInterface {

	// Initializing the logger
	private static Logger logger = Logger.getLogger(CourseDAOImpl.class);

	// insert a new cousre in database against a course Id and catalog Id
	@Override
	public boolean insertCourse(Course course) {
		boolean isInserted =false;

		// Establishing the connection
		Connection connection = DBUtil.getConnection();
		// Establishing the connection
		PreparedStatement stmt = null;

		try {
			// Declaring prepared statement and executing query
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
			isInserted=true;
			return isInserted;

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return isInserted;
	}

	// delete a cousre from course database using course Id
	@Override
	public boolean deleteCourse(Course course) {
		boolean isDeleted = false;
		// Establishing the connection
		Connection connection = DBUtil.getConnection();
		// Establishing the connection
		PreparedStatement stmt = null;
		try {

			stmt = connection.prepareStatement(SQLConstantQueries.DELETE_COURSE + course.getCourseId());
			// Executing query
			int rs = stmt.executeUpdate();
			if (rs > 0) {
				logger.info("Course with courseId " + course.getCourseId() + " deleted !");
				isDeleted=true;
				return isDeleted;

			}

		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
		return isDeleted;

	}

	// provide list of courses available for a student to select
			// mapped with student's with branch and semester
			public List<Course> displayCourses(Student student) {
	            
				//Establishing the connection
				Connection connection= DBUtil.getConnection();

				//Declaring prepared statement and executing query
				PreparedStatement stmt= null;
				 int semester=student.getSemester();
				 
				 String branch=student.getBranch();
				
				try {

					stmt= connection.prepareStatement(SQLConstantQueries.DISPLAY_COURSES);
					stmt.setInt(1, semester);
					stmt.setString(2,branch);

					ResultSet rs = stmt.executeQuery();

					List<Course> list= new ArrayList<Course>();

					//Creating ArrayList of Course
					while(rs.next())
					{
						
						Course course = new Course();
						course.setBranch(branch);
						course.setSemester(semester);
						course.setCourseId(rs.getInt("courseid"));
						course.setCourseName(rs.getString("coursename"));
						course.setCourseDescription(rs.getString("coursedescription"));
					    logger.debug("creating list of courses");
						list.add(course);

					}

					return list;
				}
				catch(SQLException ex) {
					logger.debug(ex);
				}
			
				
				return null;
				
			}
	
}
