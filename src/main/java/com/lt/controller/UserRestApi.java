package com.lt.controller;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.business.StudentImplService;
import com.lt.business.StudentInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;

@RestController
@RequestMapping("/CRS")
public class UserRestApi {

	// UserInterface userInterface = new UserImplService();
	private static Logger logger = Logger.getLogger(UserRestApi.class);

	UserInterface userInterface = new UserImplService();
	StudentInterface studentOperation = new StudentImplService();

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/login")

	@ResponseBody

	public String verifyCredentials(@RequestBody User user) {

		logger.warn("user controller method user and password getting username-->" + user.getUserName());
		logger.warn("user controller method user and password getting password-->" + user.getUserPassword());

		User checkuser = userInterface.validateUser(user.getUserName(), user.getUserPassword());
		logger.warn("after calling method password getting");
		if (checkuser != null) {
			int profile = checkuser.getRoleId();
			int userId1 = checkuser.getUserId();
			// Professor professor=userInterface.fetchProfessor(userId1);
			if (profile != 0) {
				logger.debug("login successful");
			} else {
				logger.error("verify your credential");
			}

		}

		return null;
	}

	// UserInterface userOperation=new UserImplService();

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/signup")

	@ResponseBody

	public String registation(@RequestBody Student student) {
		logger.debug("inside signup");
		logger.warn("user controller method user and password getting username-->" + student.getName());
		logger.warn("user controller method user and password getting password-->" + student.getPassword());
		User user = new User();
		logger.debug("calling user impl--->");
		User uawe = userInterface.createUser(student.getName(), student.getPassword(), student.getRole());
		if (uawe.getRoleId() != 0) {
			logger.debug("user created----> ");

		} else {
			logger.error("user not created");
		}

		if (uawe != null) {
			Student studen = studentOperation.createStudent(student);
			if (studen != null) {
				logger.debug("student inserted");
			} else {
				logger.error("not inserted ");
			}
		}

		return "**********Registation completed*********";
	}

	

}