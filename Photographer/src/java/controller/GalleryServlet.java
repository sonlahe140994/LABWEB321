package controller;

import dal.GalleryDAO;
import dal.ImageDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gallery;
import model.Image;

public class GalleryServlet extends HomePageServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String gaId = "GA1";
        //check to get parameter id from request of Page
        if (request.getParameter("id") != null) {
            gaId = request.getParameter("id");
        }
        try {
            getGalleryByGaId(request, gaId);
            getListImgOfGalleryById(request, gaId);
            getContact(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            String mess = e.getMessage();
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("Gallery.jsp").forward(request, response);
    }

    private void getGalleryByGaId(HttpServletRequest request, String gaId) throws ClassNotFoundException, SQLException {
        GalleryDAO gd = new GalleryDAO();
        Gallery g = gd.getGalleryById(gaId);
        //get gallery
        if (g != null) {
            request.setAttribute("gal", g);
        }
    }

    private void getListImgOfGalleryById(HttpServletRequest request, String gaId) throws ClassNotFoundException, SQLException {
        ImageDAO id = new ImageDAO();
        ArrayList<Image> listImage = id.getImageByGalleryId(gaId);
        //get data for gallery imgae
        if (!listImage.isEmpty()) {
            request.setAttribute("listImg", listImage);
        }
    }

}
