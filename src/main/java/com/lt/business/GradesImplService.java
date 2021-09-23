package com.lt.business;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.lt.DAO.GradeDAOImpl;
import com.lt.DAO.GradeDAOInterface;
import com.lt.bean.Course;
import com.lt.bean.Grade;
import com.lt.bean.Student;



@Service
public class GradesImplService  implements GradesInterface {

	private static Logger logger = Logger.getLogger(GradesImplService.class);
	GradeDAOInterface gradeDao= new GradeDAOImpl();
	@Override
	public void displayGrades(Student student) {
		logger.debug("***********************************REPORT CARD******************************");	
		logger.debug("COURSE ID                    GRADE");
		List<Course> courses = gradeDao.displayGrades(student);

		courses.forEach(course -> logger.info(course.getCourseId()+"        "+course.getCourseName()));

		
	}
 
	@Override
	public void uploadGrades(Grade grade)  {
		gradeDao.uploadGrades(grade);
		

		
	}

	
	

}
