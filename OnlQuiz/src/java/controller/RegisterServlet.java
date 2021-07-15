/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import dal.PermissionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Permission;

/**
 *
 * @author dinht
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            initDataToPage(request);
        } catch (ClassNotFoundException | SQLException e) {
            String err = e.getMessage();
            request.setAttribute("err", err);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } finally {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    private void initDataToPage(HttpServletRequest request) throws ClassNotFoundException, SQLException {
        PermissionDAO pd = new PermissionDAO();
        ArrayList<Permission> listPer = pd.getAllPermission();
        if (listPer.isEmpty()) {
            return;
        }
        request.setAttribute("listPer", listPer);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            createAccount(request, response);
        } catch (ClassNotFoundException | SQLException | IOException | ServletException e) {
            String err = e.getMessage();
            request.setAttribute("err", err);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } finally {
        }

    }

    private void createAccount(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        //calling contructor to check info
        AccountDAO ad = new AccountDAO();

        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        //request paravues will return a array. and the first index is the values selected
        String Type = request.getParameterValues("types")[0];
        String email = request.getParameter("email");

        Account checkAcUser = ad.getAccountByUserName(user);
        Account checkAcEmail = ad.getAccountByEmail(email);

        Account a = null;
        if (checkAcUser == null && checkAcEmail == null) {
            a = new Account(0, user, pass, Integer.parseInt(Type), email);
        } else {
            String erm = "Username or email have been exits!!!!";
            request.setAttribute("erm", erm);
            initDataToPage(request);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        // if insert new account succesfull. then will create a session and send to homepage
        if (ad.insertAccount(a)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("a", a);
            request.getRequestDispatcher("homepage.jsp").forward(request, response);
        } else {
            String errorMess = "Register account faill!";
            request.setAttribute("erm", errorMess);
            initDataToPage(request);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

    }

}
