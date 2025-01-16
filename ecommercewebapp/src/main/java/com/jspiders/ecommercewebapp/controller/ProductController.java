package com.jspiders.ecommercewebapp.controller;


import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.jspiders.ecommercewebapp.dto.ProductDTO;
import com.jspiders.ecommercewebapp.service.ProductService;

import java.io.IOException;
import java.util.List;

public class ProductController extends HttpServlet {
    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "list":
                List<ProductDTO> products = productService.getAllProducts();
                request.setAttribute("products", products);
                request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request, response);
                break;
            case "add":
                request.getRequestDispatcher("/WEB-INF/views/add_product.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if ("save".equals(action)) {
            String name = request.getParameter("name");
            String category = request.getParameter("category");
            double price = Double.parseDouble(request.getParameter("price"));
            productService.addProduct(new ProductDTO(name, category, price));
            response.sendRedirect("ProductController?action=list");
        }
    }
}

