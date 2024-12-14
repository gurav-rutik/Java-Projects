package com.jspiders.contactmanagerproject.business;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.jspiders.contactmanagerproject.data.HibernateUtil;
import com.jspiders.contactmanagerproject.entity.Contact;

import java.util.List;

public class BusinessImplementation implements Business {

    @Override
    public void addContact(Contact contact) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(contact);
            transaction.commit();
            System.out.println("Contact added successfully.");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteContact(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Contact contact = entityManager.find(Contact.class, id);
            if (contact != null) {
                entityManager.remove(contact);
                transaction.commit();
                System.out.println("Contact deleted successfully.");
            } else {
                System.out.println("Contact not found.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Contact findContactById(int id) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        try {
            return entityManager.find(Contact.class, id);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void updateContact(Contact contact) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Contact existingContact = entityManager.find(Contact.class, contact.getId());
            if (existingContact != null) {
                existingContact.setFirstName(contact.getFirstName());
                existingContact.setLastName(contact.getLastName());
                existingContact.setMobile(contact.getMobile());
                existingContact.setWork(contact.getWork());
                existingContact.setEmail(contact.getEmail());
                entityManager.merge(existingContact);  // Update the existing contact
                System.out.println("Contact updated");
            } else {
                System.out.println("Contact not found");
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    // Retrieve all contacts from the database
    @Override
    public Contact[] findAllContacts() {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        Query query = entityManager.createQuery("from Contact");
        java.util.List<Contact> contactList = query.getResultList();
        entityManager.close();
        return contactList.toArray(new Contact[0]);
    }
}
