package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContactServlet extends HomePageServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            getContact(request, response);
        } catch (Exception e) {
            String mess = e.getMessage();
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("Contact.jsp").forward(request, response);
    }

}
