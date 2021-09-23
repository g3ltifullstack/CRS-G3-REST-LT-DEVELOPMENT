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
import com.lt.constants.SQLConstantQueries;
import com.lt.exception.ProfessorNotFoundException;
import com.lt.exception.StudentNotFoundException;
import com.lt.utils.CloseConnection;
import com.lt.utils.DBUtil;

public class ProfessorDAOImpl implements ProfessorDAOInterface, CloseConnection {
	private static Logger logger = Logger.getLogger(ProfessorDAOImpl.class);

	Professor pfd = new Professor();
	@Override
	public List<Professor> professorDetails(String name) {
		
		Connection connection = DBUtil.getConnection();
		logger.debug("connection stablished ");
		PreparedStatement stmt = null;
		List<Professor> liststd = new ArrayList<Professor>();

		try {
			stmt = connection.prepareStatement(SQLConstantQueries.SELECT_PROFESSOR_BY_NAME);
			logger.info("Executing script");
			stmt.setString(1, name);
			logger.warn("going to execute resultset object");
			ResultSet rs = stmt.executeQuery();
			logger.warn("resultset executed resultset object");
			try {
				if (rs.next()) {
// PROFESSORID,PROFESSORNAME,DEPARTMENT,EMAIL,GENDER,USERID,ROLE
					logger.debug("fetching resultset of student of -->" + name);
					Professor profssor = new Professor();
					profssor.setProfessorId(rs.getInt("PROFESSORID"));
					profssor.setProfessorName(rs.getString("PROFESSORNAME"));
					profssor.setDepartment(rs.getString("DEPARTMENT"));
					profssor.setEmail(rs.getString("EMAIL"));
					profssor.setGender(rs.getString("GENDER"));
					profssor.setUserId(rs.getInt("USERID"));
					profssor.setRole(rs.getString("ROLE"));
					liststd.add(profssor);
				} else {
					throw new ProfessorNotFoundException("given professor details not available !! provide correct name --->" + name);

				}
			} catch (ProfessorNotFoundException e) {
				logger.error(e.getMessage());

			}

		} catch (SQLException ex) {
			logger.error(ex);
		}
//		

		return liststd;


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
		logger.info("Executing script");
		logger.warn("Professor dao classes");
		PreparedStatement stmt = null;
		List<Student> liststd = new ArrayList<Student>();
		
		try {

			// Declaring prepared statement
			stmt = connection.prepareStatement(SQLConstantQueries.SELECT_STUDENT_PROF);

			ResultSet rs = stmt.executeQuery();
			logger.warn("resultset executed");
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
			logger.warn("going to execute resultset object");
			ResultSet rs = stmt.executeQuery();
			logger.warn("resultset executed resultset object");
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
				} else {
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
