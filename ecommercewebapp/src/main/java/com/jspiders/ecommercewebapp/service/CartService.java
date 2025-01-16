package com.jspiders.ecommercewebapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jspiders.ecommercewebapp.dao.OrderDAO;
import com.jspiders.ecommercewebapp.dao.ProductDAO;
import com.jspiders.ecommercewebapp.dto.OrderDTO;
import com.jspiders.ecommercewebapp.dto.ProductDTO;

public class CartService {
    private static final Map<String, List<ProductDTO>> carts = new HashMap<>();

    public void addToCart(String username, int productId) {
        ProductDTO product = new ProductDAO().getAllProducts().stream()
                .filter(p -> p.getId() == productId)
                .findFirst()
                .orElse(null);
        if (product != null) {
            carts.computeIfAbsent(username, k -> new ArrayList<>()).add(product);
        }
    }

    public List<ProductDTO> getCartProducts(String username) {
        return carts.getOrDefault(username, Collections.emptyList());
    }

    public void checkout(String username) {
        List<ProductDTO> products = carts.remove(username);
        if (products != null && !products.isEmpty()) {
            new OrderDAO().addOrder(new OrderDTO(products));
        }
    }
}
