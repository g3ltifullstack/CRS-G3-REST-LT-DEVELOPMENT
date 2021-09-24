/**
 * 
 */
package com.lt.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Admin;
import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.business.AdminImplService;
import com.lt.business.AdminInterface;
import com.lt.business.CourseImplService;
import com.lt.business.CourseInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;

import com.lt.exception.StudentNotFoundForApprovalException;
import com.lt.exception.UserNotFoundException;
import com.lt.DAO.AdminDAOInterface;
import com.lt.DAO.CourseDAOImpl;
import com.lt.DAO.CourseDAOInterface;
import com.lt.DAO.UserDAOImpl;
import com.lt.DAO.AdminDAOImpl;

@RestController
@RequestMapping("/admin")
public class AdminRestApi {

	AdminDAOInterface adminOperation = new AdminDAOImpl();

	/**
	 * 
	 * @param courseCode
	 * @param professorId
	 * @return
	 */

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/createadmin")
	@ResponseBody
	public String createAdmin(@RequestBody Admin admin) throws SQLException {

		AdminInterface adminDAO1 = new AdminImplService();

		System.out.println("Print admin name -- " + admin.getName());
		System.out.println("fetch admin");
		boolean adminString = adminDAO1.createAdmin(admin);
		if (adminString) {
			return "created";
		}
		return "not created";
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/fetchadmin")
	@ResponseBody
	public String fetchAdmin(@RequestBody Admin admin) {
		AdminInterface adminDAO1 = new AdminImplService();

		System.out.println("Print admin name -- " + admin.getName());
		System.out.println("fetch admin");
		String adminString = adminDAO1.fetchAdmin(admin);
		return adminString;
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/updateuser")
	@ResponseBody
	public String updateUser(@RequestBody User user) throws SQLException {

		UserInterface adminDAO1 = new UserImplService();

//		System.out.println("Print admin name -- " + admin.getName());
		System.out.println("fetch admin");
		boolean adminString = adminDAO1.updateUser(user);
		if (adminString) {
			return "updated";
		}
		return "not updated"; // add exception
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/deleteuser")
	@ResponseBody
	public String deleteUser(@RequestBody User user) throws SQLException {

		UserInterface adminDAO1 = new UserImplService();

		boolean adminString = adminDAO1.deleteUser(user);
		if (adminString) {
			return "deleted";
		}
		return "not deleted"; // add exception
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/displayadmin")
	@ResponseBody
	public String displayAdmins(@RequestBody Admin admin) throws SQLException {

		AdminInterface adminDAO1 = new AdminImplService();

		System.out.println("Print admin name -- " + admin.getName());
		System.out.println("fetch admin");
		String adminString = adminDAO1.displayAdmins(admin);
		return adminString;
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/insertcourse")
	@ResponseBody
	public String insertCourse(@RequestBody Course course) throws SQLException {

		CourseInterface courseDAO = new CourseImplService();

		boolean adminString = courseDAO.insertCourse(course);
		if (adminString) {
			return "inserted";
		}
		return "not inserted";
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/deletecourse")
	@ResponseBody
	public String deleteCourse(@RequestBody Course course) throws SQLException {

		CourseInterface courseDAO = new CourseImplService();

		boolean adminString = courseDAO.deleteCourse(course);
		if (adminString) {
			return "deleted";
		}
		return "not deleted";
	}

}