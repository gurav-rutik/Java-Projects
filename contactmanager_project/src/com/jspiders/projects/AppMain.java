package com.jspiders.projects;

import java.util.Scanner;

import com.jspiders.projects.business.BusinessImplementation;

public class AppMain {
	
	private static boolean run = true;
	private static Scanner scanner = new Scanner(System.in);
	private static BusinessImplementation business = new BusinessImplementation();
	
	public static void main(String[] args) {
		
		
		while(run) {
			
			display();
			int choice = scanner.nextInt();
			
			switch(choice) {
			
			case 1:{
				business.addContact();
			}break;
			
			case 2:{
				System.out.println("Contact Deleted");
			}break;
			
			case 3:{
				System.out.println("Contact Updated");
			}break;
			
			case 4:{
				System.out.println("Contact Finded by First Name");
			}break;
			
			case 5:{
				System.out.println("Contact Finded by Last Name");
			}break;
			
			case 6:{
				System.out.println("All Contact Finded");
			}break;
			
			case 7:{
				System.out.println("Search Contact");
			}break;
			
			case 8:{
				System.out.println("See you soon!");
				run=false;
			}break;
			
			default:{
				System.out.println("Invalid choice!!");
			}
			}
			
			

		
		}
		scanner.close();
	}
			
	
	private static void display() {
		System.out.println("================================================");
		System.out.println("============== CONTACT MANAGER APP =============");
		System.out.println("================================================");
		System.out.println("1. Add Contact");
		System.out.println("2. Delete Contact");
		System.out.println("3. Update Contact");
		System.out.println("4. Find Contact By First Name");
		System.out.println("5. Find Contact By Last Name");
		System.out.println("6. Find All Contact");
		System.out.println("7. Search Contact");
		System.out.println("8. Exit");
		System.out.println("================================================");
		System.out.println("Enter choice");
	}
	
}
