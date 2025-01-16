package com.jspiders.ecommercewebapp.service;

import java.util.List;

import com.jspiders.ecommercewebapp.dao.OrderDAO;
import com.jspiders.ecommercewebapp.dto.OrderDTO;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();

    public List<OrderDTO> getOrders() {
        return orderDAO.getOrders();
    }
}
