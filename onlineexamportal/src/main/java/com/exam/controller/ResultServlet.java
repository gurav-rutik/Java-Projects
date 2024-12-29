package com.exam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.exam.dao.ResultDAO;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        int score = Integer.parseInt(request.getParameter("score"));
        ResultDAO.saveResult(username, score);
        response.sendRedirect("result.jsp?score=" + score);
    }
}