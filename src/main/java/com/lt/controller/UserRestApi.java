package com.lt.controller;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.business.StudentImplService;
import com.lt.business.StudentInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;
import com.lt.exception.UserNotFoundException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/CRS")
public class UserRestApi {

	// UserInterface userInterface = new UserImplService();
	private static Logger logger = Logger.getLogger(UserRestApi.class);

	UserInterface userInterface = new UserImplService();
	StudentInterface studentOperation = new StudentImplService();

	@ApiOperation(value = "user login", response = Iterable.class, tags = "verifyCredentials")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "Not Authorized!"), @ApiResponse(code = 403, message = "Forbidden!!!"),
			@ApiResponse(code = 404, message = "Not Found!!!") })
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/login")

	@ResponseBody

	public String verifyCredentials(@RequestBody User user) {

		logger.warn("user controller method user and password getting username-->" + user.getUserName());
		logger.warn("user controller method user and password getting password-->" + user.getUserPassword());
		String status = null;
		try {
			User checkuser = userInterface.validateUser(user.getUserName(), user.getUserPassword());
			logger.warn("after calling method password getting");
			if (checkuser != null) {
				int profile = checkuser.getRoleId();
				int userId1 = checkuser.getUserId();
				// Professor professor=userInterface.fetchProfessor(userId1);
				if (userId1 != 0) {
					logger.debug("login successful");
					status = "login verified";

				} else {
					throw new UserNotFoundException("provide correct login credential");
				}
			}
		} catch (UserNotFoundException ex) {
			logger.error(ex.getMessage());

		}

		return status;
	}

	// UserInterface userOperation=new UserImplService();

	@ApiOperation(value = "user signup", response = Iterable.class, tags = "registation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success|OK"),
			@ApiResponse(code = 401, message = "Not Authorized!"), @ApiResponse(code = 403, message = "Forbidden!!!"),
			@ApiResponse(code = 404, message = "Not Found!!!") })

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/signup")

	@ResponseBody

	public String registation(@RequestBody Student student) {
		logger.debug("inside signup");
		logger.warn("user controller method user and password getting username-->" + student.getName());
		logger.warn("user controller method user and password getting password-->" + student.getPassword());
		User user = new User();
		logger.debug("calling user impl--->");
		String status = null;
		User uawe = userInterface.createUser(student.getName(), student.getPassword(), student.getRole());
		if (uawe.getRoleId() != 0) {
			logger.debug("user created----> ");
			status = "user created successfully";

		} else {
			logger.error("user not created");
		}

		if (uawe != null) {
			boolean studen = studentOperation.createStudent(student);
			if (studen) {
				logger.debug("student inserted");

			} else {
				logger.error("not inserted ");
			}
		}

		return status;
	}

}