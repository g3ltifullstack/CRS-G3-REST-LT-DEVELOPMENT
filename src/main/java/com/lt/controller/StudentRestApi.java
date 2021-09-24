package com.lt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Course;
import com.lt.bean.Payment;
import com.lt.bean.Student;
import com.lt.business.CourseInterface;
import com.lt.business.PaymentInterface;
import com.lt.business.StudentInterface;

import net.minidev.json.JSONArray;

@RestController
public class StudentRestApi {

	private static Logger logger = Logger.getLogger(StudentRestApi.class);

	@Autowired
	CourseInterface courseOperation;
	@Autowired
	StudentInterface studentOperation;
	@Autowired
	PaymentInterface pymt;
	@Autowired
	PaymentInterface pymt1;

	// Student signup

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/studentsignup")
	@ResponseBody
	public String createStudents(@RequestBody Student student) {
		logger.debug("Calling create student service");
		studentOperation.createStudent(student);
		return "Student signup successful";
	}
	
	// View All Courses

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/ViewAllCourses")
	@ResponseBody
	public String display(@RequestBody Student student) {

		List<Course> list = new ArrayList<>();
		logger.debug("Calling display course service");
		list = courseOperation.displayCourses(student);
		String jsonstr = JSONArray.toJSONString(list);
		return jsonstr;
	}
	
	//Add Course

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/addCourse")
	@ResponseBody
	public void addCourses(@RequestBody Student student) {

		studentOperation.addCourse(student);

	}
	
	//Drop Course

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/dropCourse")
	@ResponseBody
	public void dropCourses(@RequestBody Student student) {
		studentOperation.dropCourse(student);
	}
	
	//Display Selected Courses

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/DisplaySelectedCourse")
	@ResponseBody
	public String displaySelected(@RequestBody Student student) {
		List<Course> list1 = new ArrayList<>();
		list1 = studentOperation.displaySelectedCourses(student);
		String jsonstr1 = JSONArray.toJSONString(list1);
		return jsonstr1;

	}
	
	
	//Fee Payment

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST, value = "/PayFee")
	@ResponseBody
	public void FeePymt(@RequestBody Payment paymnt) {
		pymt.payment(paymnt);
	}
	
	//View Receipt

	@RequestMapping(produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET, value = "/ViewReceipt")
	@ResponseBody
	public String receipt(@RequestBody Student student) {
	
		String jsonstr2 = pymt1.viewreceipt(student);
		;
		return jsonstr2;

	}

}