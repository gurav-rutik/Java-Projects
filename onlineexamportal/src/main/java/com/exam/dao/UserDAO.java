package com.exam.dao;

import java.sql.*;
import com.exam.util.DBConnection;

public class UserDAO {
    public static boolean validateUser(String username, String password) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?")) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}