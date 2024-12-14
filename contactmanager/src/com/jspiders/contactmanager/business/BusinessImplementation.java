package com.jspiders.contactmanager.business;

import java.util.Scanner;

import com.jspiders.contactmanager.data.Data;
import com.jspiders.contactmanager.data.DataImplementation;
import com.jspiders.contactmanager.entity.Contact;

public class BusinessImplementation implements Business {

	private Scanner scanner = new Scanner(System.in);

	private int id;

	private Data data = new DataImplementation();

	@Override
	public void addContact() {
		System.out.println("Enter first name");
		String firstName = scanner.next();
		System.out.println("Enter last name");
		String lastName = scanner.next();
		System.out.println("Enter mobile number");
		long mobile = scanner.nextLong();
		System.out.println("Enter work number");
		long work = scanner.nextLong();
		System.out.println("Enter email");
		String email = scanner.next();

		Contact contact = new Contact(id(), firstName, lastName, mobile, work, email);

		data.addContact(contact);

		Contact[] contacts = data.findAllContacts();

		for (int i = 0; i < contacts.length; i++) {
			System.out.println(contacts[i]);
		}
	}

	@Override
	public void deleteContact() {
		System.out.println("Enter contact id");
		int id = scanner.nextInt();
		data.deleteContact(id);

		Contact[] contacts = data.findAllContacts();

		if (contacts.length > 0) {
			for (int i = 0; i < contacts.length; i++) {
				System.out.println(contacts[i]);
			}
		} else
			System.out.println("Contacts not found");
	}

	@Override
	public void updateContact() {
		System.out.println("Enter contact id");
		int id = scanner.nextInt();
		Contact contact = data.findContactById(id);
		if (contact != null) {
			System.out.println("Enter first name");
			String firstName = scanner.next();
			System.out.println("Enter last name");
			String lastName = scanner.next();
			System.out.println("Enter mobile number");
			long mobile = scanner.nextLong();
			System.out.println("Enter work number");
			long work = scanner.nextLong();
			System.out.println("Enter email");
			String email = scanner.next();
			contact.setFirstName(firstName);
			contact.setLastName(lastName);
			contact.setMobile(mobile);
			contact.setWork(work);
			contact.setEmail(email);
			System.out.println("Contact updated");
			System.out.println(contact);
		} else
			System.out.println("Contact not found");
	}

	@Override
	public void findContactByFirstName() {
		System.out.println("Enter first name");
		String firstName = scanner.next();
		Contact[] contacts = data.findAllContacts();
		if (contacts.length > 0) {
			boolean flag = false;
			for (int i = 0; i < contacts.length; i++) {
				if (contacts[i].getFirstName().equals(firstName)) {
					flag = true;
					System.out.println(contacts[i]);
				}
			}
			if (!flag)
				System.out.println("No Contact found");
		} else
			System.out.println("Contacts not found");
	}

	@Override
	public void findContactByLastName() {
		System.out.println("Enter last name");
		String lastName = scanner.next();
		Contact[] contacts = data.findAllContacts();
		if (contacts.length > 0) {
			boolean flag = false;
			for (int i = 0; i < contacts.length; i++) {
				if (contacts[i].getLastName().equals(lastName)) {
					flag = true;
					System.out.println(contacts[i]);
				}
			}
			if (!flag)
				System.out.println("No contact found");
		} else
			System.out.println("Contacts not found");
	}

	private int id() {
		return ++id;
	}

	@Override
	public void findAllContacts() {
		Contact[] contacts = data.findAllContacts();
		if (contacts.length > 0) {
			for (int i = 0; i < contacts.length; i++) {
				System.out.println(contacts[i]);
			}
		} else
			System.out.println("Contacts not found");
	}
	
	@Override
	public void search() {
	    System.out.println("Enter pattern");
	    String patter = scanner.next();
	    
	    Contact[] contacts = data.findAllContacts();
	    boolean found = false;

	    if (contacts.length > 0) {
	        for (int i = 0; i < contacts.length; i++) {
	            Contact contact = contacts[i];

	            if (contact.getFirstName().contains(patter) || 
	                contact.getLastName().contains(patter) || 
	                String.valueOf(contact.getMobile()).contains(patter) || 
	                String.valueOf(contact.getWork()).contains(patter) || 
	                contact.getEmail().contains(patter)) {

	                System.out.println(contact);
	                found = true;
	            }
	        }

	        if (!found) {
	            System.out.println("No contacts found");
	        }
	    } else {
	        System.out.println("Contact not found");
	    }
	}


}