package com.jspiders.ecommercewebapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.jspiders.ecommercewebapp.dto.OrderDTO;

public class OrderDAO {
    private static final List<OrderDTO> orders = new ArrayList<>();

    public void addOrder(OrderDTO order) {
        orders.add(order);
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }
}
