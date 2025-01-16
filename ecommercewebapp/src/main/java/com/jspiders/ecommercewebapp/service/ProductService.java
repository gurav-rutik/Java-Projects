package com.jspiders.ecommercewebapp.service;

import java.util.List;

import com.jspiders.ecommercewebapp.dao.ProductDAO;
import com.jspiders.ecommercewebapp.dto.ProductDTO;

public class ProductService {
    private ProductDAO productDAO = new ProductDAO();

    public List<ProductDTO> getAllProducts() {
        return productDAO.getAllProducts();
    }

    public void addProduct(ProductDTO product) {
        productDAO.addProduct(product);
    }
}
