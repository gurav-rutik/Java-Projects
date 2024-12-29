package com.jspiders.online_food_delivey_project.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.jspiders.online_food_delivey_project.entity.FoodItem;

public class FoodItemDAO {
    private EntityManager em;

    public FoodItemDAO(EntityManager em) {
        this.em = em;
    }

    public void addFoodItem(FoodItem foodItem) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(foodItem);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public FoodItem getFoodItemById(int id) {
        return em.find(FoodItem.class, id);
    }

    // Other CRUD operations
}

