/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AuthorDAO;
import dal.CardDAO;
import dal.ConceptDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Author;
import model.Card;
import model.Concept;

/**
 *
 * @author dinht
 */
public class GetDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*init data*/
        try {
            init(request, response);
        } catch (ClassNotFoundException | IOException | SQLException e) {
            String errorMess = e.getMessage();
            request.setAttribute("error", errorMess);
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
    }

    private void init(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
        //calling contructor to using
        PrintWriter pw = response.getWriter();
        CardDAO cd = new CardDAO();
        AuthorDAO ad = new AuthorDAO();
        ConceptDAO cod = new ConceptDAO();

        ArrayList<Card> listAjax = cd.getAllCard();
        String indexStr = request.getParameter("index");
        //length of even load
        int lengOfList = 10;
        int index = Integer.parseInt(indexStr);
        //get array of index needed
        ArrayList<Card> listAjaxNext = cd.getListCardFrom(listAjax, index, index + lengOfList);
        //check if have no data then wil return
        if(listAjaxNext.isEmpty()){
            return;
        }
        //creating a string of block of HTML. 
        String cardHtml = "\n";
        for (Card i : listAjaxNext) {
            Author au = ad.getAuthorById(i.getAuthorId());
            Concept c = cod.getConceptById(i.getConceptId());
            String newCardHtmlString = "<h1>" + indexStr + "<h1/><div class=\"card\">\n"
                    + "                            <div class=\"list-img-card\">\n"
                    + "                                <div class=\"save-button\">\n"
                    + "                                    <div class=\"pin-save-icon\"></div>\n"
                    + "                                    <span>Save</span>\n"
                    + "                                </div>\n"
                    + "                                <img class=\"list-img\" src=\"img/" + i.getImgMain() + "\" alt=\"\">\n"
                    + "\n"
                    + "                                <div class=\"link-contact\">\n"
                    + "                                    <a href=\"#\">\n"
                    + "                                        <div class=\"logo-contact\"></div>\n"
                    + "                                        <span class=\"contact-text\">Learn more at " + i.getExpandPin() + "</span>\n"
                    + "                                    </a>\n"
                    + "                                </div>\n"
                    + "                                <div class=\"expand\"><a href=\"\">Expand Pin</a></div>\n"
                    + "                            </div>\n"
                    + "                            <article>\n"
                    + "                                <aside>\n"
                    + "                                    <img src=\"img/" + i.getFromLogo() + "\" alt=\"\">\n"
                    + "                                    <span>from " + i.getFromUrl() + "</span>\n"
                    + "                                </aside>\n"
                    + "                                <title>" + i.getTitle() + "</title>\n"
                    + "\n"
                    + "                                <p>" + i.getDes() + "\n"
                    + "                                </p>\n"
                    + "                                <div>\n"
                    + "                                    <i class=\"repin\"></i>\n"
                    + "                                    <span class=\"social-meta-count\">" + i.getNumOfPin() + "</span>\n"
                    + "                                </div>\n"
                    + "                                <div>\n"
                    + "                                    <i class=\"like-icon\"></i>\n"
                    + "                                    <span class=\"social-meta-count\">" + i.getNumOfLike() + "</span>\n"
                    + "                                </div>\n"
                    + "                            </article>\n"
                    + "                            <div class=\"credit-item\">\n"
                    + "                                <img src=\"img/" + au.getImgUrl() + "\" alt=\"<%=au.getImgUrl()%>\">\n"
                    + "                                <div class=\"credit-infor\">\n"
                    + "                                    <p class=\"credit-name\"><a href=\"#\">" + au.getAuthorName() + "</a></p>\n"
                    + "                                    <p class=\"credit-type-img\">" + au.getNameConcept() + "</p>\n"
                    + "                                </div>\n"
                    + "                                <button class=\"credit-button\"></button>\n"
                    + "                            </div>\n"
                    + "                            <div class=\"footer-card\">\n"
                    + "                                From " + c.getName() + "\n"
                    + "                            </div>\n"
                    + "                        </div>";
            cardHtml += newCardHtmlString;
        }
        //respone a string of BlockHTML to client
        pw.print(cardHtml);

    }

}
