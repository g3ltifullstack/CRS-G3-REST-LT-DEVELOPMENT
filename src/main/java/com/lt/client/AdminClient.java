package com.lt.client;

import java.util.Scanner;

import com.lt.business.GradesImplService;
import com.lt.business.GradesInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;

public class AdminClient {

	public void adminMenu() {
		UserInterface admin = new UserImplService();
		System.out.println("Welcome to Admin Portal ---> ");
		System.out.println("Choose an Option ");
		System.out.println("1. SignUp ");
		System.out.println("2. Login ");
		System.out.println("3. Manage Password ");
		System.out.println("4. Exit ");
		Scanner sc = new Scanner(System.in);
		int userRole = sc.nextInt();
		switch (userRole) {
		case 1:
			System.out.println("SignUp Portal");
			// user sign up method
			admin.signUp();
			System.out.println("Signed up Successfully");
			break;

		case 2:
			System.out.println("Login Portal");
			// user login method
			//admin.login();
			System.out.println("Logged in Successfully");
			System.out.println("Display Student Details");

		//	admin.displayStudents();
			System.out.println("Display Grade Details");

			GradesInterface grade = new GradesImplService();
	//		grade.uploadGrades();
			break;

		case 3:
			System.out.println("Manage User Portal");
			System.out.println("Enter UserName: ");
			String userName = sc.next();
			System.out.println("Enter Password: ");
			String password = sc.next();
			// Manage User method
	//		admin.manageUser(userName, password);
			System.out.println("Username and Password submitted Successfully");
			break;

		case 4:
			System.out.println("You have successfully logged out and exited from system. thank you!");
			break;

		default:
			System.out.println("Choose valid user type");
		}

		sc.close();

	}

}
