package com.jspiders.online_food_delivey_project.service;

import javax.persistence.EntityManager;

import com.jspiders.online_food_delivey_project.dao.FoodItemDAO;
import com.jspiders.online_food_delivey_project.entity.FoodItem;

public class FoodItemService {
    private FoodItemDAO foodItemDAO;

    public FoodItemService(EntityManager em) {
        this.foodItemDAO = new FoodItemDAO(em);
    }

    public void addFoodItem(FoodItem foodItem) {
        foodItemDAO.addFoodItem(foodItem);
    }

    public FoodItem getFoodItemById(int id) {
        return foodItemDAO.getFoodItemById(id);
    }

    // Other methods
}

