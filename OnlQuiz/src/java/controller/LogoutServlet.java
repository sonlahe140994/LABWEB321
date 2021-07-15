/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dinht
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            removeAccount(request, response);
        } catch (IOException e) {
            String err = e.getMessage();
            request.setAttribute("err", err);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    private void removeAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("a") != null) {
            session.removeAttribute("a");
        }
        response.sendRedirect("homepage.jsp");
    }

}
