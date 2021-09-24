package com.lt.controller;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Grade;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.business.GradesImplService;
import com.lt.business.GradesInterface;
import com.lt.business.ProfessorImplService;
import com.lt.business.ProfessorInterface;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/professor")
public class ProfessorRestApi {

	ProfessorInterface proff = new ProfessorImplService();
	private static Logger logger = Logger.getLogger(ProfessorRestApi.class);
	
	@ApiOperation(value = "Professor uploading grade", response = Iterable.class, tags = "provideGread")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "Not Authorized!"), @ApiResponse(code = 403, message = "Forbidden!!!"),
			@ApiResponse(code = 404, message = "Not Found!!!") })

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/gupload")

	@ResponseBody
	public String provideGread(@RequestBody Grade grade) {
		logger.debug("providing gread");
		logger.debug("calling grade impl--->");
		String sts=null;
		GradesInterface gradeOperation= new GradesImplService();
		boolean status=false;
		status=gradeOperation.uploadGrades(grade);
		if(status) {
			logger.debug("login verified");
			sts="login verified";
		}
		return sts;
	
	};

// view student details
	
	@ApiOperation(value = "professor getting student details", response = Iterable.class, tags = "getStudentdetails")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "Not Authorized!"), @ApiResponse(code = 403, message = "Forbidden!!!"),
			@ApiResponse(code = 404, message = "Not Found!!!") })

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/rgdetails")

	@ResponseBody
	public String getStudentdetails() {
		logger.debug("going in professor services");
		Student std = new Student();
		ProfessorInterface proff = new ProfessorImplService();
		String data = proff.displayRegisteredStudent();
		;
		logger.info(std.getGender());

		if (proff != null) {
			logger.warn("student details--->" + std.getPhoneNumber());
		}
		return data;

		// return student }

	}
	
	
	@ApiOperation(value = "professor getting student details by student name", response = Iterable.class, tags = "studentByName")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "Not Authorized!"), @ApiResponse(code = 403, message = "Forbidden!!!"),
			@ApiResponse(code = 404, message = "Not Found!!!") })
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/stdbyname")

	@ResponseBody
	public String studentByName(@RequestBody Student student) {
		logger.debug("getting data of -->"+student.getName());
		logger.debug("calling professor impl--->");
		
		String data=proff.studentByName(student);
		return data;
	
	};
	
	@ApiOperation(value = "professor details by professor  name", response = Iterable.class, tags = "professorByName")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "Not Authorized!"), @ApiResponse(code = 403, message = "Forbidden!!!"),
			@ApiResponse(code = 404, message = "Not Found!!!") })
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/prfbyname")

	@ResponseBody
	public String professorByName(@RequestBody Professor professor) {
		logger.debug("getting data of -->"+professor.getProfessorName());
		logger.debug("calling professor impl--->");
		//GradesInterface gradeOperation= new GradesImplService();
		String data=proff.professorDetails(professor);
		return data;
	
	};
	
}
