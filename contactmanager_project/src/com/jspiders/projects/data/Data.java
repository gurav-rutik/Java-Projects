package com.jspiders.projects.data;

import com.jspiders.projects.entity.Contact;

public interface Data {
	
	void addContact(Contact contact);
	
	Contact[] findAllContacts();
}
