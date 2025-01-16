package com.jspiders.ecommercewebapp.dto;

public class ProductDTO {
    private int id;
    private String name;
    private String category;
    private double price;

    public ProductDTO(String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
}

