package com.jspiders.online_food_delivey_project.entity;


import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;

    // Getters and Setters
}
