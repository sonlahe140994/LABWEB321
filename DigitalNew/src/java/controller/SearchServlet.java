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
        process(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PostDAO pd = new PostDAO();
        //paging
        try {
            //PrintWriter pw = response.getWriter();
            String searchString = request.getParameter("searchText");
            ArrayList<Post> listPost = pd.getSearchListPost(searchString.trim());
//            String a = "";
//            for (Post p : listPost) {
//                a += p.getIdPost() + "\n";
//            }
//            pw.print(a);
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
                if (maxPage != 1) {
                    request.setAttribute("maxPage", maxPage);
                }
                request.setAttribute("sString", searchString.trim());
            }
        } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
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
