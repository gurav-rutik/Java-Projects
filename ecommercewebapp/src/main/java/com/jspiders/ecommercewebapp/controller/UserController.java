package com.jspiders.ecommercewebapp.controller;


import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.jspiders.ecommercewebapp.dto.UserDTO;
import com.jspiders.ecommercewebapp.service.UserService;

import java.io.IOException;

public class UserController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        switch (action) {
            case "login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                UserDTO user = userService.login(username, password);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect("ProductController?action=list");
                } else {
                    request.setAttribute("error", "Invalid credentials");
                    request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
                }
                break;
            case "register":
                String name = request.getParameter("name");
                username = request.getParameter("username");
                password = request.getParameter("password");
                userService.register(new UserDTO(name, username, password));
                response.sendRedirect("/login.jsp");
                break;
        }
    }
}

