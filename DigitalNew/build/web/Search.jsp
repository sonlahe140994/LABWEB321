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
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tìm Kiếm</title>
        <link rel="stylesheet" type="text/css" href="css/home.css">
        <link rel="stylesheet" type="text/css" href="css/search.css">
    </head>

    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <h1 id="length-result"> Number of Reulst: ${nOfRe}</h1>
                <div class="bg-post">
                    <div class="main" style="padding-top: 40px;">
                        <!--show list of result-->
                        <%ArrayList<Post> listPost = null;
                            if (request.getAttribute("sResult") != null) {
                                listPost = (ArrayList<Post>) request.getAttribute("sResult");
                        %>
                        <%
                            for (Post i : listPost) {
                        %>
                        <div class="sResult">
                            <div class="sText">
                                <p class="title-search" onclick="showPost(<%=i.getIdPost()%>)" id="<%=i.getIdPost()%>"><%=i.getIdPost()%>|<%=i.getTitlePost()%></p>
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
                        <!--show pagination-->
                    </div>
                    <div class="pag">
                        <ul class="pagination">
                            <%
                                String sString = "";
                                if (request.getAttribute("sString") != null) {
                                    sString = (String) request.getAttribute("sString");
                                }
                                if (request.getAttribute("index") != null && request.getAttribute("maxPage") != null) {
                                    int maxPage = (Integer) request.getAttribute("maxPage");
                                    for (int i = 1; i <= maxPage; i++) {
                            %>
    <!--                            <a class="page-link" href="SearchServlet?index=<%=i%>&searchT=<%=sString%>"><%=i%></a>-->
                            <button class="page-link" onClick="loadPost(<%=i%>)">
                                <%=i%>
                            </button>
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
        <script src="js/highlight.js"></script>
        <script>
                                const loadPost = (index) => {
                                    console.log("load " + index);
                                    var text = document.getElementById("searchInput").value;
                                    console.log("sendRequest");
                                    var xhttp = new XMLHttpRequest();
                                    xhttp.open("GET", "SearchServlet?index=" + index + "&searchT=" + text, false);
                                    xhttp.send();
                                    document.getElementsByClassName("main")[0].innerHTML = xhttp.responseText;
                                    highLight();
                                };


        </script>
    </body>

</html>