package com.exam.dao;

import java.sql.*;
import com.exam.util.DBConnection;

public class ResultDAO {
    public static void saveResult(String username, int score) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO results (username, score) VALUES (?, ?)")) {
            ps.setString(1, username);
            ps.setInt(2, score);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}