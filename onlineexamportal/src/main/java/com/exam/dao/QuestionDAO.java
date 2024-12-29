package com.exam.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.exam.model.Question;
import com.exam.util.DBConnection;

public class QuestionDAO {
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM questions")) {
            while (rs.next()) {
                Question question = new Question(rs.getInt("id"), rs.getString("question"), rs.getString("option1"), rs.getString("option2"), rs.getString("option3"), rs.getString("option4"), rs.getString("answer"));
                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
}