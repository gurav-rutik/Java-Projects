package com.jspiders.online_food_delivey_project.service;

import javax.persistence.EntityManager;

import com.jspiders.online_food_delivey_project.dao.CustomerDAO;
import com.jspiders.online_food_delivey_project.entity.Customer;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService(EntityManager em) {
        this.customerDAO = new CustomerDAO(em);
    }

    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    // Other methods
}

