/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.CardDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Card;

/**
 *
 * @author dinht
 */
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //init data
        try {
            initColumn(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            String errorMess = e.getMessage();
            request.setAttribute("error", errorMess);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } finally {
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
    }

    private void initColumn(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        CardDAO cd = new CardDAO();
        ArrayList<Card> listCard = cd.getTop10Card();
        request.setAttribute("listCard", listCard);
    }

}
