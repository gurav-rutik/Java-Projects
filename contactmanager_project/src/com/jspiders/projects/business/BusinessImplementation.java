package com.jspiders.projects.business;

import java.util.Scanner;

import com.jspiders.projects.data.Data;
import com.jspiders.projects.data.DataImplementation;
import com.jspiders.projects.entity.Contact;

public class BusinessImplementation implements Business {
	
	private Scanner scanner = new Scanner(System.in);
	private int id;
	
	Data data = new DataImplementation();

	@Override
	public void addContact() {
		System.out.println("Enter first name");
		String firstName = scanner.next();
		System.out.println("Enter last name");
		String laststName = scanner.next();
		System.out.println("Enter mobile number");
		long mobile = scanner.nextLong();
		System.out.println("Enter work number");
		long work = scanner.nextLong();
		System.out.println("Enter email");
		String email = scanner.next();
		
		Contact contact = new Contact(id(), firstName, laststName, mobile, work, email);
		data.addContact(contact);
		
		Contact[] contacts = data.findAllContacts();
		
		for(int i=0;i<contacts.length;i++) {
			System.out.println(contacts[i]);
		}
	}

	@Override
	public void deleteContact() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContact() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findContactByFirstName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findContactByLastName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findAllContacts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search() {
		// TODO Auto-generated method stub
		
	}
	
	private int id() {
		return ++id;
	}
}
