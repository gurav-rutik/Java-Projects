package com.jspiders.bankingapp_project;

import java.util.Scanner;

import com.jspiders.bankingapp_project.business.UserBusiness;
import com.jspiders.bankingapp_project.business.UserBusinessImplementation;

public class App {
	public static void main(String[] args) {

		UserBusiness userBusiness = new UserBusinessImplementation();

		Scanner scanner = new Scanner(System.in);

		boolean run = true;

		while (run) {
			System.out.println("Enter 1 to create an user");
			System.out.println("Enter 2 to login");
			System.out.println("Enter 3 to delete");
			System.out.println("Enter 4 to exit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				userBusiness.createUser();
				break;
			case 2:
				userBusiness.logIn();
				break;
			case 3:
				userBusiness.deleteUser();
				break;
			case 4:
				run = false;
				System.out.println("Thank you");
				break;
			default:
				System.out.println("Invalid choice");
			}
		}

		scanner.close();

	}
}
