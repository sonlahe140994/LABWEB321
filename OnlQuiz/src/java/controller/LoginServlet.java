/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author dinht
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            checkUser(request, response);
        } catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            String err = e.getMessage();
            request.setAttribute("err", err);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } finally {
        }

    }

    private void checkUser(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        AccountDAO ad = new AccountDAO();

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        Account a = ad.getAcountByUserNameAndPassword(user, pass);
        
        if (a == null) {
            String mess = "User name and password is wrong";
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("homepage.jsp").forward(request, response);
            return;
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("a", a);
        request.getRequestDispatcher("homepage.jsp").forward(request, response);

    }

}
