<%-- 
    Document   : searchResult
    Created on : May 19, 2021, 10:24:14 AM
    Author     : dinht
--%>
<%@page import="dal.PostDAO"%>
<%@page import="model.Post"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/home.css">
        <link rel="stylesheet" type="text/css" href="css/search.css">
    </head>

    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">
                    <%ArrayList<Post> listPost = null;
                        if (request.getAttribute("sResult") != null) {
                            listPost = (ArrayList<Post>) request.getAttribute("sResult");
                            if (listPost.isEmpty()) {
                    %>
                    <h2>No result</h2>
                    <%
                        }
                        for (Post i : listPost) {
                    %>
                    <div class="sResult">
                        <div class="sText">
                            <!--<a href="HomeServlet?id=<%=i.getIdPost()%>"><p class="title-search" id="<%=i.getIdPost()%>"><%=i.getIdPost()%>|<%=i.getTitlePost()%></p></a>-->
                            <p class="title-search" id="<%=i.getIdPost()%>"><%=i.getIdPost()%>|<%=i.getTitlePost()%></p>
                        </div>
                        <div>
                            <img class="img-post" src="img/<%=i.getImgPost()%>">
                        </div>
                        <div class="author-by">
                            By <%=i.getAuthorPost()%> | <%=i.formatDate()%>
                        </div>
                    </div>
                    <% }
                        }
                    %>
                    <div class="pag">
                        <ul class="pagination">
                            <%
                                String sString = "";
                                if (request.getAttribute("sString") != null) {
                                    sString = (String) request.getAttribute("sString");
                                }
                                if (request.getAttribute("index") != null && request.getAttribute("maxPage") != null) {
                                    int index = (Integer) request.getAttribute("index");
                                    int maxPage = (Integer) request.getAttribute("maxPage");
                                    for (int i = 1; i <= maxPage; i++) {
                            %>
                            <a class="page-link" href="SearchServlet?index=<%=i%>&searchText=<%=sString%>"><%=i%></a>
                            <% }
                                }%>
                        </ul>
                    </div>
                </div>
                <jsp:include page="Right.jsp"/>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
        <script lang="javascript" src="js/search.js"></script>
    </body>

</html>