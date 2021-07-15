package controller;

import dal.PostDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Post;

/**
 *
 * @author dinht
 */
public class SearchServlet extends HomeServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            initLoadPost(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            String mess = e.getMessage();
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    private void initResultSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        request.setCharacterEncoding("UTF-8");
        PostDAO pd = new PostDAO();
        //paging
        String searchString = "";
        if (request.getParameter("searchT") != null) {
            searchString = request.getParameter("searchT");
        }
        ArrayList<Post> listPost = pd.getSearchListPost(searchString.trim());
        int nORe = listPost.size();

        int start = 0, end = 0, maxPage = 0, index = 1;
        if (request.getParameter("index") != null) {
            String reqIndex = (String) request.getParameter("index");
            index = Integer.parseInt(reqIndex);
        }
        //the number of page will equal with the number of 
        //list devide to the number of Post you want to show in page
        maxPage = listPost.size() / 2;
        if (listPost.size() % 2 != 0) {
            maxPage++;
        }
        if (listPost.size() <= 2) {
            start = 0;
            end = listPost.size();
        } else {
            start = (index - 1) * 2;
            if (start == listPost.size() - 1) {
                end = listPost.size();
            } else {
                end = start + 2;
            }
        }

        //get list of Post between postion start and nd
        listPost = pd.getListPostBetween(listPost, start, end); // increase follow the index and page size
        if (listPost != null) {
            request.setAttribute("sResult", listPost);
            request.setAttribute("index", index);
            request.setAttribute("nOfRe", nORe);
            if (maxPage != 1) {
                request.setAttribute("maxPage", maxPage);
            }
            request.setAttribute("sString", searchString.trim());
        }
    }

    private void initLoadPost(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PostDAO pd = new PostDAO();
        PrintWriter pw = response.getWriter();
        //paging
        String searchString = "";
        if (request.getParameter("searchT") != null) {
            searchString = request.getParameter("searchT");
        }
        ArrayList<Post> listPost = pd.getSearchListPost(searchString.trim());
        int start = 0, end = 0, index = 1;
        if (request.getParameter("index") != null) {
            String reqIndex = (String) request.getParameter("index");
            index = Integer.parseInt(reqIndex);
        }
        //the number of page will equal with the number of 
        //list devide to the number of Post you want to show in page
        if (listPost.size() <= 2) {
            start = 0;
            end = listPost.size();
        } else {
            start = (index - 1) * 2;
            if (start == listPost.size() - 1) {
                end = listPost.size();
            } else {
                end = start + 2;
            }
        }

        //get list of Post between postion start and nd
        listPost = pd.getListPostBetween(listPost, start, end); // increase follow the index and page size
        String resText = "";
        for (Post i : listPost) {
            resText += "\n<div class=\"sResult\">\n"
                    + "                        <div class=\"sText\">\n"
                    + "                            <p class=\"title-search\" onclick=\"showPost(" + i.getIdPost() + ")\" id=\"" + i.getIdPost() + "\">" + i.getIdPost() + "|" + i.getTitlePost() + "</p>\n"
                    + "                        </div>\n"
                    + "                        <div>\n"
                    + "                            <img class=\"img-post\" src=\"img/" + i.getImgPost() + "\">\n"
                    + "                        </div>\n"
                    + "                        <div class=\"author-by\">\n"
                    + "                            By " + i.getAuthorPost() + " | " + i.formatDate() + "\n"
                    + "                        </div>\n"
                    + "                    </div>";
        }
        pw.print(resText);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            initResultSearch(request, response);
        } catch (IOException | ServletException | ClassNotFoundException | SQLException e) {
            String mess = e.getMessage();
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        } finally {
            digitalNewContent(request, response);
            lastArticleContent(request, response);
            request.getRequestDispatcher("Search.jsp").forward(request, response);
        }
    }

}
