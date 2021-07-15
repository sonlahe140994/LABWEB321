/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.QuestionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Question;
/**
 *
 * @author dinht
 */
public class MakeQuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("makequiz.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            createAQuestion(request, response);
        } catch (ClassNotFoundException | IOException | SQLException | ServletException e) {
            String err = e.getMessage();
            request.setAttribute("err", err);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    private void createAQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException, ServletException {
        PrintWriter pw = response.getWriter();
        QuestionDAO qd = new QuestionDAO();
        String ques = request.getParameter("ques");
        String op1 = request.getParameter("op1");
        String op2 = request.getParameter("op2");
        String op3 = request.getParameter("op3");
        String op4 = request.getParameter("op4");
        String ans = request.getParameterValues("cbox")[0];
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        Question q = new Question(0, ques, op1, op2, op3, op4, ans, date);
        String result = "";
        if (qd.insertQues(q)) {
            result = "Insert Success";
        } else {
            result = "Insert fail!!";
        }
        request.setAttribute("result", result);
        request.getRequestDispatcher("makequiz.jsp").forward(request, response);

    }

}
