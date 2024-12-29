package com.jspiders.online_food_delivey_project.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jspiders.online_food_delivey_project.entity.Order;

public class OrderDAO {
    private EntityManager em;

    public OrderDAO(EntityManager em) {
        this.em = em;
    }

    public void addOrder(Order order) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(order);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public Order getOrderById(int id) {
        return em.find(Order.class, id);
    }

    // Other CRUD operations
}
