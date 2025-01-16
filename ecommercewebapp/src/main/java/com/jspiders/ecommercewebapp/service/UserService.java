package com.jspiders.ecommercewebapp.service;

import com.jspiders.ecommercewebapp.dao.UserDAO;
import com.jspiders.ecommercewebapp.dto.UserDTO;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public UserDTO login(String username, String password) {
        UserDTO user = userDAO.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void register(UserDTO user) {
        userDAO.addUser(user);
    }
}
