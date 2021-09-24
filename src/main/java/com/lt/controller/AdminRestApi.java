
package com.lt.controller;

import java.sql.SQLException;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.DAO.AdminDAOImpl;
import com.lt.DAO.AdminDAOInterface;
import com.lt.bean.Admin;
import com.lt.bean.Course;
import com.lt.bean.User;
import com.lt.business.AdminImplService;
import com.lt.business.AdminInterface;
import com.lt.business.CourseImplService;
import com.lt.business.CourseInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;

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

		AdminInterface adminimpl = new AdminImplService();

		System.out.println("Print admin name -- " + admin.getName());
		System.out.println("fetch admin");
		String adminString = adminimpl.displayAdmins(admin);
		return adminString;
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/insertcourse")
	@ResponseBody
	public String insertCourse(@RequestBody Course course) throws SQLException {

		CourseInterface coursimpl = new CourseImplService();

		boolean adminString = coursimpl.insertCourse(course);
		if (adminString) {
			return "inserted";
		}
		return "not inserted";
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/deletecourse")
	@ResponseBody
	public String deleteCourse(@RequestBody Course course) throws SQLException {

		CourseInterface courseimpl = new CourseImplService();

		boolean adminString = courseimpl.deleteCourse(course);
		if (adminString) {
			return "deleted";
		}
		return "not deleted";
	}

}