package com.jspiders.ecommercewebapp.dao;

import javax.persistence.*;

import com.jspiders.ecommercewebapp.dto.ProductDTO;

import java.util.*;


public class ProductDAO {
    private static final List<ProductDTO> products = new ArrayList<>();

    static {
        products.add(new ProductDTO("Laptop", "Electronics", 750.0));
        products.add(new ProductDTO("Smartphone", "Electronics", 500.0));
    }

    public List<ProductDTO> getAllProducts() {
        return products;
    }

    public void addProduct(ProductDTO product) {
        products.add(product);
    }
}

