package com.lt.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.lt.DAO.ProfessorDAOImpl;
import com.lt.DAO.ProfessorDAOInterface;
import com.lt.bean.Professor;
import com.lt.bean.Student;

import net.minidev.json.JSONArray;

@Repository
public class ProfessorImplService implements ProfessorInterface {
	private static Logger logger = Logger.getLogger(ProfessorImplService.class);

	//StudentDAOInterface stdao = new StudentDAOImpl();
	//Professor prof = new Professor();
	//UserInterface user = new UserImplService();
	ProfessorDAOInterface professordao = new ProfessorDAOImpl();
	Scanner sc = new Scanner(System.in);

//calling dao method to display registred student
	
	@Override
	public String displayRegisteredStudent() {
		List<Student> student = new ArrayList<Student>();
		ProfessorDAOInterface professordao = new ProfessorDAOImpl();
		//Student std=new Student();
		logger.debug("in professor bussiness logic");
		student = professordao.displayRegistredStudent();
		logger.info("below showing registred student details");
		String jsonStr = JSONArray.toJSONString(student);

		for (Student students : student) {

			logger.info("student id-->" + students.getStudentId() + " student name-->" + students.getName()
					+ " gender-->" + students.getGender() + "semester-->" + students.getSemester() + " branch-->"
					+ students.getBranch() + " phonenumber-->" + students.getPhoneNumber());
		}
		return jsonStr;

	}

	@Override
	public String professorDetails(Professor professor) {
		String name=professor.getProfessorName();
		List<Student> profinfo = new ArrayList();
		logger.debug("calling studentByName for getting data of " + name);
		profinfo = professordao.studentByName(name);
		String jsonStr = JSONArray.toJSONString(profinfo);
		return jsonStr;
	}

	@Override
	public void displaySelectedCoursesProfessor(Professor professor) {
		// TODO Auto-generated method stub

	}

	@Override
	public String studentByName(Student student) {
		List<Student> stdinfo = new ArrayList();
		ProfessorDAOInterface professordao = new ProfessorDAOImpl();
	
      String name=student.getName();
		logger.debug("calling studentByName for getting data of " + name);
		stdinfo = professordao.studentByName(name);
		String jsonStr = JSONArray.toJSONString(stdinfo);

		for (Student students : stdinfo) {

			logger.info("student id-->" + students.getStudentId() + " student name-->" + students.getName()
					+ " gender-->" + students.getGender() + "semester-->" + students.getSemester() + " branch-->"
					+ students.getBranch() + " phonenumber-->" + students.getPhoneNumber());
		}
		return jsonStr;
	}

}
