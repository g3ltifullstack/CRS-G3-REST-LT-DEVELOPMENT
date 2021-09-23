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
    StudentInterface studentOperation=new StudentImplService();
	  
	  @RequestMapping(produces = MediaType.APPLICATION_JSON, method =
				 RequestMethod.POST, value = "/login")
	  
	  @ResponseBody

	    public String verifyCredentials(@RequestBody User user){
					
                  logger.warn("user controller method user and password getting username-->"+user.getUserName());
                  logger.warn("user controller method user and password getting password-->"+user.getUserPassword());
						
                        
						User checkuser = userInterface.validateUser(user.getUserName(),user.getUserPassword());
						logger.warn("after calling method password getting");
						if (checkuser != null) {
							int profile = checkuser.getRoleId();
							int userId1 = checkuser.getUserId();
							switch (profile) {
							case 102: //
								Professor professor=userInterface.fetchProfessor(userId1); //
								
								ProfessorRestApi proffrest= new ProfessorRestApi(); //redirecting to professor
								// client landing page logger.debug("professor verified"+profile);
								logger.debug("professor verified");
								//proffrest.professorOperation(professor);

								break;

							}

						}
					
	return null;
}

	//  UserInterface userOperation=new UserImplService();
	  
	  @RequestMapping(produces = MediaType.APPLICATION_JSON, method =
				 RequestMethod.POST, value = "/signup")
	  
	  @ResponseBody

	    public String registation(@RequestBody Student student){
		        logger.debug("inside signup");
               logger.warn("user controller method user and password getting username-->"+student.getName());
               logger.warn("user controller method user and password getting password-->"+student.getPassword());
               User user=new User();
               logger.debug("calling user impl--->");
              User uawe= userInterface.createUser(student.getName(),student.getPassword(),student.getRole());
               if(uawe.getRoleId()!=0) {
            	   logger.debug("user created----> ");
            	  
               }
               else {
            	   logger.error("user not created");
               }
               
             if(uawe!=null) {
            	Student  studen=studentOperation.createStudent(student);
            	if(studen!=null) {
            		logger.debug("student inserted");
            	}
            	else {
            		logger.error("not inserted ");
            	}
             }
             
 			
	return "**********Registation completed*********";
}	  
	  
	  
	// view student details
	/*
	 * @RequestMapping(produces = MediaType.APPLICATION_JSON, method =
	 * RequestMethod.GET, value = "/details")
	 * 
	 * @ResponseBody public String getStudentdetails() {
	 * logger.debug("going in professor services"); Student std = new Student();
	 * ProfessorInterface proff = new ProfessorImplService(); String data
	 * =proff.displayRegisteredStudent(); ; logger.info(std.getGender());
	 * 
	 * if (proff != null) { logger.warn("student details--->"+std.getPhoneNumber());
	 * } return data;
	 * 
	 * // return student }
	 */
	  
}