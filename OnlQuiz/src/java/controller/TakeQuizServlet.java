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
public class TakeQuizServlet extends HttpServlet {

    ArrayList<Question> listQ;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            initQuestion(request, response);
        } catch (IOException | SQLException e) {
            String err = e.getMessage();
            request.setAttribute("err", err);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

    }

    private void initQuestion(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String noq = request.getParameter("noq");
        PrintWriter pw = response.getWriter();
        int numOfQues = Integer.parseInt(noq);
        QuestionDAO qd = new QuestionDAO();
        listQ = qd.getRandomQuestion(numOfQues);
        for (Question i : listQ) {
            pw.append("<div class=\"ques\">\n"
                    + "                            <h2>" + "Id: " + i.getId() + "|" + i.getQues() + "</h2>\n"
                    + "                            <ul>\n"
                    + "                                <li><div class=\"ans\"><input name=\"" + "test" + "\" type=\"checkbox\" value=\"1\">" + "Hello" + "</div></li>\n"
                    + "                                <li><div class=\"ans\"><input name=\"" + i.getId() + "\" type=\"checkbox\" value=\"1\">" + i.getOption1() + "</div></li>\n"
                    + "                                <li><div class=\"ans\"><input name=\"" + i.getId() + "\" type=\"checkbox\" value=\"2\" >" + i.getOption2() + "</div></li>\n"
                    + "                                <li><div class=\"ans\"><input name=\"" + i.getId() + "\" type=\"checkbox\" value=\"3\" >" + i.getOption3() + "</div></li>\n"
                    + "                                <li><div class=\"ans\"><input name=\"" + i.getId() + "\" type=\"checkbox\" value=\"4\" >" + i.getOption4() + "</div></li>\n"
                    + "                            </ul>\n"
                    + "                        </div>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            checkResult(request, response);
        } catch (IOException | ServletException e) {
            String err = e.getMessage();
            request.setAttribute("err", err);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    private void checkResult(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //a variable to count number right
        int numOfRight = 0;
        for (Question i : listQ) {
            //get all the checkbox of every id of question
            if (request.getParameterValues(i.getId() + "") != null) {
                //get the check box have been selected at id question
                String a = request.getParameterValues(i.getId() + "")[0];
                //check if it's equal with arraylist of questtion get from database before
                if (i.getAnswer().equalsIgnoreCase(a)) {
                    // if it's equal then count will increase to 1 
                    numOfRight++;
                }
            }
        }
        //calculate the percent of number question is right and all question
        int percent = (numOfRight * 100) / listQ.size();
        //calculate the point of number question is right and all question
        double point = (numOfRight * 10) / listQ.size();
        //create a mess status that not pass
        String pass = "Not Pass";
        if (percent >= 70) {
            //check if percent is morethan 70% then status will be pass
            pass = "Passed";
        }
        //send a request to page
        request.setAttribute("point", point);
        request.setAttribute("pass", pass);
        request.setAttribute("result", numOfRight);
        request.setAttribute("percent", percent);
        request.getRequestDispatcher("takequiz.jsp").forward(request, response);
    }

}
