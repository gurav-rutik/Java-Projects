package com.jspiders.online_food_delivey_project.service;

import javax.persistence.EntityManager;

import com.jspiders.online_food_delivey_project.dao.OrderDAO;
import com.jspiders.online_food_delivey_project.entity.Order;

public class OrderService {
    private OrderDAO orderDAO;

    public OrderService(EntityManager em) {
        this.orderDAO = new OrderDAO(em);
    }

    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    public Order getOrderById(int id) {
        return orderDAO.getOrderById(id);
    }

    // Other methods
}

