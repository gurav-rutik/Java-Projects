package com.jspiders.ecommercewebapp.dao;

import java.util.HashMap;
import java.util.Map;

import com.jspiders.ecommercewebapp.dto.UserDTO;

public class UserDAO {
    private static final Map<String, UserDTO> users = new HashMap<>();

    static {
        users.put("admin", new UserDTO("Admin", "admin", "admin123"));
    }

    public UserDTO getUser(String username) {
        return users.get(username);
    }

    public void addUser(UserDTO user) {
        users.put(user.getUsername(), user);
    }
}
