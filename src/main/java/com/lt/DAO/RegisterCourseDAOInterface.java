package com.lt.DAO;

import java.util.List;

import com.lt.bean.Student;

public interface RegisterCourseDAOInterface {

	public boolean numberOfCoursesSelected(Student student);

	public void submitRegistration(Student student);

	public void generateRegistrationReciept(Student student, double payableAmount, int payModeId);

	public List<Integer> displayRegisteredStudentsInCourse(int courseId);

}
