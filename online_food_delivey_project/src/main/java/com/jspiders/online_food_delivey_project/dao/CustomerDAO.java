package com.jspiders.online_food_delivey_project.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jspiders.online_food_delivey_project.entity.Customer;

public class CustomerDAO {
    private EntityManager em;

    public CustomerDAO(EntityManager em) {
        this.em = em;
    }

    public void addCustomer(Customer customer) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(customer);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public Customer getCustomerById(int id) {
        return em.find(Customer.class, id);
    }

    // Other CRUD operations
}

