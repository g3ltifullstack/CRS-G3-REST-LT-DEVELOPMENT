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
import com.lt.business.CourseImplService;
import com.lt.constants.SQLConstantQueries;
import com.lt.utils.DBUtil;


@Repository
public class CourseDAOImpl implements CourseDAOInterface {
	private static Logger logger = Logger.getLogger(CourseDAOImpl.class);
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
