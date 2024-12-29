package com.jspiders.online_food_delivey_project;

import javax.persistence.EntityManager;

import com.jspiders.online_food_delivey_project.entity.Customer;
import com.jspiders.online_food_delivey_project.entity.FoodItem;
import com.jspiders.online_food_delivey_project.entity.Order;
import com.jspiders.online_food_delivey_project.service.CustomerService;
import com.jspiders.online_food_delivey_project.service.FoodItemService;
import com.jspiders.online_food_delivey_project.service.OrderService;
import com.jspiders.online_food_delivey_project.util.HibernateUtil;
import java.util.*;
public class App {
    public static void main(String[] args) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();

        // Create services
        CustomerService customerService = new CustomerService(em);
        FoodItemService foodItemService = new FoodItemService(em);
        OrderService orderService = new OrderService(em);

        // Create sample objects and persist them
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("john@example.com");
        customer.setPhone("1234567890");
        customerService.addCustomer(customer);

        FoodItem foodItem = new FoodItem();
        foodItem.setName("Pizza");
        foodItem.setPrice(15.99);
        foodItemService.addFoodItem(foodItem);

        // Create and persist order
        Order order = new Order();
        order.setCustomer(customer);
        order.setFoodItems(List.of(foodItem));
        order.setTotalPrice(15.99);
        orderService.addOrder(order);

        System.out.println("Order placed successfully!");
        HibernateUtil.shutdown();
    }
}
