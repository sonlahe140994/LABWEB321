/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;

/**
 *
 * @author dinht
 */
public class ManageQuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            initQuestion(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            String err = e.getMessage();
            request.setAttribute("err", err);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } finally {
            request.getRequestDispatcher("managequiz.jsp").forward(request, response);
        }
    }

    private void initQuestion(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        QuestionDAO qd = new QuestionDAO();
        ArrayList<Question> ques = qd.getAllQuestion();
        request.setAttribute("listQ", ques);
    }

}
