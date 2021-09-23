package com.lt.business;

import java.io.IOException;
import java.util.List;

import com.lt.bean.Course;

public interface AdminInterface {
	public void addProfessor(); //addCourseCatalog() 
	public boolean approveStudent(); 
	public void generateReportCard(); 
	public void addCourse();
	public void dropCourse();
	public List<Course> publishResult() throws IOException;

}
