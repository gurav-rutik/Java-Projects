package com.jspiders.ecommercewebapp.controller;


import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.jspiders.ecommercewebapp.dto.ProductDTO;
import com.jspiders.ecommercewebapp.service.CartService;

import java.io.IOException;
import java.util.List;

public class CartController extends HttpServlet {
    private CartService cartService = new CartService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        switch (action) {
            case "add":
                int productId = Integer.parseInt(request.getParameter("productId"));
                cartService.addToCart(username, productId);
                response.sendRedirect("CartController?action=view");
                break;
            case "checkout":
                cartService.checkout(username);
                response.sendRedirect("orderConfirmation.jsp");
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<ProductDTO> cartProducts = cartService.getCartProducts(username);
        request.setAttribute("cart", cartProducts);
        request.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request, response);
    }
}

