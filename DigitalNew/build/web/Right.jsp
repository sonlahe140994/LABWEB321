<%@page import="java.util.ArrayList"%>
<%@page import="model.Post"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="css/right.css" type="text/css">
    </head>
    <body>
        <div class="right">
            <div class="newst">
                <div class="titleNews">
                    <span>Digital News</span>
                </div>
                <%

                    if (request.getAttribute("digitalPost") != null) {
                        Post p = (Post) request.getAttribute("digitalPost");
                %>
                <div class="contentNews">
                    <%=p.getShortDesPost()%>
                </div>
                <%
                    }
                %>
            </div>
            <div class="newst">
                <div class="titleNews">
                    <span>Search</span>
                </div>
                <form action="SearchServlet" method="post">
                    <input class="searchBox" type="text" name="searchText" size="15"  required>
                    <input id="go-button" class="searchButton" type="submit" name="btnGo" value="Go">
                </form>
            </div>
            <div class="newest test" >
                <div class="titleNews">
                    <span>Last Article</span><br/>
                </div>
                <%
                    if (request.getAttribute("top5LastAr") != null) {
                        ArrayList<Post> listPost = (ArrayList<Post>) request.getAttribute("top5LastAr");
                        for (Post i : listPost) {
                %>
                <div class="lastArticles">
                    <a class="title-top5" href="HomeServlet?id=<%=i.getIdPost()%>"><%=i.getTitlePost()%></a>
                </div>
                <%}
                    }
                %>
            </div>
        </div>
        <script lang="javascript" src="js/search.js"></script>
    </body>
</html>