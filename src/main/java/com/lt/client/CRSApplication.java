/*package com.lt.client;

import java.util.Scanner;

public class CRSApplication {
	public static void main(String[] args) {
		System.out.println("1. Admin");
		System.out.println("2. Student");
		System.out.println("3. Professor");
		System.out.println("User Type");
		Scanner sc = new Scanner(System.in);
		int userType = sc.nextInt();
		switch (userType) {
		case 1:
			System.out.println("Admin");
			AdminClient admin = new AdminClient();
			admin.adminMenu();

		case 2:
			System.out.println("Student");
			StudentClient student = new StudentClient();
			student.studentMenu();

		}
		sc.close();
	}

}
*/