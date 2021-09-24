package com.lt.business;

import java.io.IOException;
import java.util.List;

import com.lt.bean.Admin;
import com.lt.bean.Course;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;

public interface AdminInterface {
	public void addProfessor(); 

	public boolean approveStudent();

	public void generateReportCard();

	public void dropCourse();

	public List<Course> publishResult() throws IOException;

	public String fetchAdmin(Admin admin);

	public boolean createAdmin(Admin admin);

	/**
	 * Display Admins
	 */
	public String displayAdmins(Admin admin);

}
