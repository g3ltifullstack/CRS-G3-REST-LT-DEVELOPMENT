package com.lt.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.constants.CommonData;
import com.lt.constants.SQLConstantQueries;
import com.lt.exception.StudentNotFoundException;
import com.lt.utils.CloseConnection;
import com.lt.utils.DBUtil;

public class ProfessorDAOImpl implements ProfessorDAOInterface, CloseConnection {
	private static Logger logger = Logger.getLogger(ProfessorDAOImpl.class);

	Professor pfd = new Professor();

	public List<Professor> professorDetails() {
		return null;

	}

	@Override
	public void selectCourse(int courseId, Professor professor) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Course> displayProfessorCourses(Professor professor) {

		return null;
	}
	// "select studentid,studentname,gender,semester,branch,phonenumber from
	// student";

	@Override
	public List<Student> displayRegistredStudent() {
		Connection connection = DBUtil.getConnection();
		logger.debug("connection stablished ");
		PreparedStatement stmt = null;
		List<Student> liststd = new ArrayList<Student>();
		int countdata = 0;
		try {

			// Declaring prepared statement
			stmt = connection.prepareStatement(SQLConstantQueries.SELECT_STUDENT_PROF);

			ResultSet rs = stmt.executeQuery();
			logger.info("Executing script");
			while(rs.next()) {

				Student student = new Student();
				student.setStudentId(rs.getInt("studentid"));
				student.setName(rs.getString("studentname"));
				student.setGender(rs.getString("gender"));
				student.setSemester(rs.getInt("semester"));
				student.setBranch(rs.getString("branch"));
				student.setPhoneNumber(rs.getLong("phonenumber"));
				liststd.add(student);
			}
			logger.info("data fetched");
		} catch (SQLException ex) {
			logger.error(ex.getMessage());
		}
//		

		return liststd;
	}

	@Override
	public List<Student> studentByName(String name) {
		Connection connection = DBUtil.getConnection();
		logger.debug("connection stablished ");
		PreparedStatement stmt = null;
		List<Student> liststd = new ArrayList<Student>();

		try {
			stmt = connection.prepareStatement(SQLConstantQueries.SELECT_STUDENT_BY_NAME);
			logger.info("Executing script");
			stmt.setString(1, name);

			ResultSet rs = stmt.executeQuery();

			try {
				if (rs.next()) {
					
						logger.debug("fetching resultset of student of -->" + name);
						Student student = new Student();
						student.setStudentId(rs.getInt("studentid"));
						student.setName(rs.getString("studentname"));
						student.setGender(rs.getString("gender"));
						student.setSemester(rs.getInt("semester"));
						student.setBranch(rs.getString("branch"));
						student.setPhoneNumber(rs.getLong("phonenumber"));
						liststd.add(student);
				} 
				else {
					throw new StudentNotFoundException("given student details not available==" + name);

				}
			} catch (StudentNotFoundException e) {
				logger.error(e.getMessage());

			}

		} catch (SQLException ex) {
			logger.error(ex);
		}
//		
	
		return liststd;
	}

}
