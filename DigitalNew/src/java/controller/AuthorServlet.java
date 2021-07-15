/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AuthorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Author;

public class AuthorServlet extends HomeServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            initAuthorPost(request, response);
        } catch (Exception e) {
            String mess = e.getMessage();
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
        digitalNewContent(request, response);
        lastArticleContent(request, response);
        request.getRequestDispatcher("author.jsp").forward(request, response);

    }

    private void initAuthorPost(HttpServletRequest request, HttpServletResponse response) {
        AuthorDAO ad = new AuthorDAO();
        ArrayList<Author> list = ad.getAllAuthor();
        request.setAttribute("lau", list);
    }

}
