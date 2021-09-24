package com.lt.controller;



import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.business.UserInterface;
import com.lt.controller.AdminRestApi;
import com.lt.controller.ProfessorRestApi;
import com.lt.controller.StudentRestApi;
import com.lt.bean.Admin;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.business.StudentImplService;
import com.lt.business.StudentInterface;
import com.lt.business.UserImplService;
import org.apache.log4j.Logger;



@RestController
public class UserRestApi {
	@Autowired
	UserInterface userOperation;
	@Autowired
	StudentInterface studentOpration;
	
	@GetMapping("/home")
	public String Crs()
	{
		return "welcome to crs";
	}
	
	 
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method =RequestMethod.POST, value = "/login")
    @ResponseBody
	public String verifyCredentials(@RequestBody User user){
        
//        logger.warn("user controller method user and password getting username-->"+user.getUserName());
//        logger.warn("user controller method user and password getting password-->"+user.getUserPassword());
              
              
              User checkuser = userOperation.validateUser(user.getUserName(),user.getUserPassword());
          //    logger.warn("after calling method password getting");
              if (checkuser != null) {
                  int profile = checkuser.getRoleId();
                  int userId1 = checkuser.getUserId();
                  return"user found";


              }
              else {
            	  return "no user found";
              }
              
          }
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON, method =RequestMethod.POST, value = "/usersignup")
    @ResponseBody
	public String createUsers(@RequestBody User user){
		userOperation.createUser(user);
		return "User signup successful";
	}
        
	
}



