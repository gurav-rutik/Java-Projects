package com.jspiders.ecommercewebapp.dto;

import java.util.List;

public class OrderDTO {
    private List<ProductDTO> products;
    private double total;

    public OrderDTO(List<ProductDTO> products) {
        this.products = products;
        this.total = products.stream().mapToDouble(ProductDTO::getPrice).sum();
    }

    public List<ProductDTO> getProducts() { return products; }
    public double getTotal() { return total; }
}
