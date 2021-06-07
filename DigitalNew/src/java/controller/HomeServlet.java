/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.PostDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Post;

public class HomeServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getParameter("id") != null) {
                contentPostDetail(request, response);
                digitalNewContent(request, response);
                lastArticleContent(request, response);
            } else {
                mainContent(request, response);
                digitalNewContent(request, response);
                lastArticleContent(request, response);
            }
        } catch (IOException | ServletException e) {
            response.sendRedirect("Error.jsp");
        }
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void mainContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDAO pd = new PostDAO();
        PrintWriter pw = response.getWriter();
        //get post from DB
        try {
            Post p = pd.getMostRecentNews();
            // post to page
            if (p != null) {
                request.setAttribute("post", p);
            }
        } catch (ClassNotFoundException | SQLException e) {
            String mess = e.getMessage();
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }

    }

    public void digitalNewContent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PostDAO pd = new PostDAO();
        //get post from DB

        try {
            Post p = pd.getMostRecentNews();
            // post to page
            if (p != null) {
                request.setAttribute("digitalPost", p);
            }
        } catch (ClassNotFoundException | SQLException e) {
            String mess = e.getMessage();
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    public void lastArticleContent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PostDAO pd = new PostDAO();
        PrintWriter pw = response.getWriter();
        //get post from DB
        try {
            ArrayList<Post> top5ListPost = pd.getLastArticle();
            // post to page
            if (top5ListPost != null) {
                request.setAttribute("top5LastAr", top5ListPost);
            } else {
                pw.print("Khong co Post digital post");
            }
        } catch (ClassNotFoundException | SQLException e) {
            String mess = e.getMessage();
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    public void contentPostDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get detail for id post chooser
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            PostDAO pd = new PostDAO();
            Post p = pd.getPostById(id);
            if (p != null) {
                request.setAttribute("post", p);
            }
        } catch (ClassNotFoundException | SQLException e) {
            String mess = e.getMessage();
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

}
