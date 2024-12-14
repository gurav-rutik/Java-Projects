package com.jspiders.contactmanagerproject.business;

import java.util.List;

import com.jspiders.contactmanagerproject.entity.Contact;

public interface Business {

	void addContact(Contact contact);

	void deleteContact(int id);

	Contact findContactById(int id);

	void updateContact(Contact contact);  // New method for updating contact

	Contact[] findAllContacts();
}

