/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author dinht
 */
@WebFilter(filterName = "MyFilter", urlPatterns = {"/makequiz.jsp"})
public class AuthoriFilter implements Filter {

    //list of path student and Teacher
    ArrayList<String> listPathStu = initPathStudent();
    ArrayList<String> listPathTeacher = initPathTeacher();
    private static final boolean debug = true;
    private FilterConfig filterConfig = null;

    public AuthoriFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        try {
            HttpSession session = req.getSession();
            Account a = (Account) session.getAttribute("a");
            if (a == null) {
                //String mess = req.getServletPath();
                String mess = "Please Login First!!!";
                req.setAttribute("mess", mess);
                request.getRequestDispatcher("homepage.jsp").forward(request, response);
            }
            //get path of servlet request to
            String serPath = req.getServletPath();
            //check permission of student
            if (a.getType() == 1) {
                if (!checkPermissionStu(serPath)) {
                    String mess = "You have no permistion to join it";
                    req.setAttribute("mess1", mess);
                    req.getRequestDispatcher("homepage.jsp").forward(request, response);
                }
            }
            //check permission of techer
            if (a.getType() == 2) {
                if (!checkPermissionTeacher(serPath)) {
                    String mess = "You have no permistion to join it";
                    req.setAttribute("mess1", mess);
                    req.getRequestDispatcher("homepage.jsp").forward(request, response);
                }
            }
            chain.doFilter(request, response);
        } catch (IOException | ServletException e) {
            String mess = e.getMessage();
            req.setAttribute("err", mess);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("AuthoriFilter:Initializing filter");
            }
        }
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

    private boolean checkPermissionStu(String serPath) {
        for (String path : listPathStu) {
            if (serPath.equalsIgnoreCase(path)) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<String> initPathStudent() {
        String p1 = "/takequiz.jsp";
        String p3 = "/TakeQuizServlet";
        ArrayList<String> listPathOfStudent = new ArrayList<>();
        listPathOfStudent.add(p1);
        listPathOfStudent.add(p3);
        return listPathOfStudent;
    }

    private boolean checkPermissionTeacher(String serPath) {
        for (String path : listPathTeacher) {
            if (path.equalsIgnoreCase(serPath)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<String> initPathTeacher() {
        String p1 = "/MakeQuizServlet";
        String p3 = "/ManageQuizServlet";
        String p2 = "/TakeQuizServlet";
        String p4 = "/takequiz.jsp";
        String p5 = "/makequiz.jsp";
        ArrayList<String> listPathOfAdmin = new ArrayList<>();
        listPathOfAdmin.add(p1);
        listPathOfAdmin.add(p2);
        listPathOfAdmin.add(p3);
        listPathOfAdmin.add(p4);
        listPathOfAdmin.add(p5);
        return listPathOfAdmin;
    }

}
