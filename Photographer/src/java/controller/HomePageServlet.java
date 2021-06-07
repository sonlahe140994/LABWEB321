/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ContactDAO;
import dal.GalleryDAO;
import dal.ImageDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contact;
import model.Gallery;
import model.Image;
// declare servlet infor

@WebServlet(name = "HomeControl", urlPatterns = {"/HomeControl"})
public class HomePageServlet extends HttpServlet {

    //using get to transfer data faster
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //init data
        try {
            getTop1Image(request, response);
            getDataGallery(request, response);
            getContact(request, response);
        } catch (ClassNotFoundException | SQLException | IOException | ServletException e) {
            //catch error and send it to page error
            String mess = e.getMessage();
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("HomePage.jsp").forward(request, response);
    }

    private void getDataGallery(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
        GalleryDAO gd = new GalleryDAO();
        ArrayList<Gallery> list = gd.getAllGallery();
        //get data and set pagging for page
        int start = 0;
        int end = 0;
        int index = 1;
        if (request.getParameter("index") != null) {
            index = Integer.parseInt(request.getParameter("index"));
        }
        //get the length of number page
        int pageSize = list.size() / 4;
        if (list.size() % 4 != 0) {
            pageSize++;
        }
        // get start of array by index
        start = (index - 1) * 4; // get the position of first element at every index
        if (list.size() < 4) {
            end = list.size() - 1;
        } else {
            end = start + 3;//the end index is 3 element after start index
            if (end >= list.size()) {//check if end is out of range index array
                end = list.size() - 1; // vd: list.size = 5, last element is index at 4, because array start at 0
            }

        }
        ArrayList<Gallery> gaListBetween = gd.getArrayBetween(list, start, end);
        if (!list.isEmpty()) {
            request.setAttribute("psize", pageSize);
            request.setAttribute("gaList", gaListBetween);
        }
    }

    private void getTop1Image(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        ImageDAO id = new ImageDAO();
        Image i = id.getTop1Image();
        //get news image and set data for it
        if (i != null) {
            request.setAttribute("top1Img", i);
        }
    }

    public void getContact(HttpServletRequest request, HttpServletResponse response) {
        ContactDAO cd = new ContactDAO();
        Contact c = cd.getContact();
        if (c != null) {
            request.setAttribute("contact", c);
        }
    }

}
