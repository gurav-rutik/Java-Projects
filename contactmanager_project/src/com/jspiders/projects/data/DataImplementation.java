package com.jspiders.projects.data;

import com.jspiders.projects.entity.Contact;

public class DataImplementation implements Data {
	
	private Contact[] contacts = new Contact[10];
	private int capacity = contacts.length;
	private int index;

	@Override
	public void addContact(Contact contact) {
		if(index == capacity-1) {
			Contact[] temp = new Contact[2*capacity];
			for(int i=0;i<index;i++) {
				temp[i] = contacts[i];
			}
			contacts = temp;
			capacity = contacts.length;
		}
		contacts[index] = contact;
		index++;
		System.out.println("Contact added");
		
		
	}

	@Override
	public Contact[] findAllContacts() {
		Contact[] temp = new Contact[index];
		
		for(int i=0;i<index;i++) {
			temp[i] = contacts[i];
		}
		return temp;
	}



}
