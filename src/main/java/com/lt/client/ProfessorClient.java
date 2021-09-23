package com.lt.client;

import java.util.Scanner;

import com.lt.bean.Professor;
import com.lt.business.CourseImplService;
import com.lt.business.CourseInterface;
import com.lt.business.GradesImplService;
import com.lt.business.GradesInterface;
import com.lt.business.ProfessorImplService;
import com.lt.business.ProfessorInterface;




public class ProfessorClient {
	
	
		CourseInterface courseOperation= new CourseImplService();
	public void professorOperation(Professor professor)  {
		
		ProfessorInterface proff = new ProfessorImplService();
		System.out.println("<-----Welcome to professor Portal ------> ");
		System.out.println("Choose an Option to perform action ");
		System.out.println("1. provideGrade ");
		System.out.println("2. Display Registated student ");
		System.out.println("3. Display Student by name  ");
		System.out.println("4. exit ");
		Scanner sc = new Scanner(System.in);
		int userRole = sc.nextInt();
		int courseId;
		switch (userRole) {
		
		case 1:
			
			
			System.out.println("Enter the CourseID to upload grades");
			courseId= sc.nextInt();
			// shows the list of students enrolled in particular course
			
			System.out.println("Enter the StudentID to upload grades");
			int studentId= sc.nextInt();
			System.out.println("Enter the grade");
			String grade= sc.next();
			// grade submission
			GradesInterface gradeOperation= new GradesImplService();
			gradeOperation.uploadGrades(studentId, courseId, grade);
		
			
			break;
			
		case 2:
			System.out.println("Below showing registred student details");
			// user sign up method
			proff.displayRegisteredStudent();
			
			break;
		case 3:
			System.out.println("selected student");
			// user sign up method
			proff.studentByName();
			
			break;
		
		default:
			System.out.println("Choose valid operation");
	
		}
		
		
	}
}

	
