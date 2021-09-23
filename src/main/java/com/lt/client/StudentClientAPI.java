package com.lt.client;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Course;
import com.lt.bean.Payment;
import com.lt.bean.Student;
import com.lt.business.CourseImplService;
import com.lt.business.CourseInterface;
import com.lt.business.NotificationImplService;
import com.lt.business.NotificationInterface;
import com.lt.business.PaymentImplService;
import com.lt.business.PaymentInterface;
import com.lt.business.StudentImplService;
import com.lt.business.StudentInterface;
import com.lt.client.StudentClientAPI;

import net.minidev.json.JSONArray;


@RestController
public class StudentClientAPI {

	    @Autowired  
	    CourseInterface courseOperation;
	    @Autowired
	    StudentInterface studentOperation;
	    @Autowired
	    PaymentInterface pymt;
	    @Autowired
	    PaymentInterface pymt1;
		
	
			    @RequestMapping(produces = MediaType.APPLICATION_JSON, method =RequestMethod.POST, value ="/ViewAllCourses")
				@ResponseBody
				public String display(@RequestBody Student student){
					
					List<Course> list=new ArrayList<>();
					list=courseOperation.displayCourses(student);
					String jsonstr=JSONArray.toJSONString(list);
		     		return jsonstr;
				}
				
			    @RequestMapping(produces = MediaType.APPLICATION_JSON, method =RequestMethod.POST, value ="/addCourse")
				@ResponseBody
				public void addCourses(@RequestBody Course course, @RequestBody Student student){
				
				studentOperation.addCourse(course, student);
			
				}
				
				@RequestMapping(produces = MediaType.APPLICATION_JSON, method =RequestMethod.POST, value ="/dropCourse")
				@ResponseBody
				public void dropCourses(@RequestBody Course course, @RequestBody Student student){
				studentOperation.dropCourse(course, student);
				}	
				
				
				@RequestMapping(produces = MediaType.APPLICATION_JSON, method =RequestMethod.POST, value ="/DisplaySelectedCourse")
				@ResponseBody
			    public String displaySelected(@RequestBody Student student) {
					List<Course> list1=new ArrayList<>();
					list1=studentOperation.displaySelectedCourses(student);
					String jsonstr1=JSONArray.toJSONString(list1);
		     		return jsonstr1;
					
				}
				
				@RequestMapping(produces = MediaType.APPLICATION_JSON, method =RequestMethod.POST, value ="/PayFee")
				@ResponseBody
				public void FeePymt(@RequestBody Student student)
				{
			     	pymt.payment(student);
				}
				
				@RequestMapping(produces = MediaType.APPLICATION_JSON, method =RequestMethod.GET, value ="/ViewReceipt")
				@ResponseBody
				public String receipt(@RequestBody Student student) {
					List<Payment> list2=new ArrayList<>();
					list2=pymt1.viewreceipt(student);
					String jsonstr2=JSONArray.toJSONString(list2);
		     		return jsonstr2;
					
					
				}
				
				
			

}
		

		
