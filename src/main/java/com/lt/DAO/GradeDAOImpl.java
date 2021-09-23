package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.bean.Grade;
import com.lt.bean.Student;
import com.lt.constants.SQLConstantQueries;
import com.lt.exception.StudentNotFoundException;
import com.lt.utils.DBUtil;

public class GradeDAOImpl implements GradeDAOInterface {
	private static Logger logger = Logger.getLogger(GradeDAOImpl.class);

	@Override
	public List<Course> displayGrades(Student student) {

		return null;
	}

	@Override
	public void uploadGrades(Grade grade) {

		Connection connection = DBUtil.getConnection();
		PreparedStatement stmt = null;
		// GREAD_UPLOAD="INSERT INTO GRADE VALUES (?,?,?)";
		try {

			// Declaring prepared statement
			logger.debug("inside oload gread dao---->");
			stmt = connection.prepareStatement(SQLConstantQueries.GRADE_UPLOAD);
			stmt.setLong(1,  grade.getCourseId());
			stmt.setLong(2, grade.getStudentId());
			stmt.setString(3,grade.getGrade());
			logger.debug("executing dao script--->");
			int a=stmt.executeUpdate();
			
			//System.out.println(a);
			//ResultSet rs = stmt.getGeneratedKeys();
			
			

			try {
				
				if (a>0) {
					
					
					logger.warn("Grade inserted for student id-->" + grade.getStudentId());
					

				} else {
					throw new StudentNotFoundException("student not available for student id-->" + grade.getStudentId());
				}
			} catch (StudentNotFoundException ex) {
 
				logger.error(ex.getMessage());
			}
 
		} catch (SQLException ex) {
			//logger.error(ex.getMessage());
			logger.error(ex);
		}
		

//		
   
	}

}
