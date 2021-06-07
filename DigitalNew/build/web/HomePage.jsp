<%@page import="model.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home Page</title>
        <link rel="stylesheet" href="css/home.css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">
                    <%
                        Post p = null;
                        if (request.getAttribute("post") != null) {
                            p = (Post) request.getAttribute("post");
                    %>
                    <div class="title">
                        <p><%=p.getTitlePost()%></p>
                    </div>
                    <div class="image">
                        <img src="img/<%=p.getImgPost()%>">
                    </div>
                    <div class="text">
                        <p><%=p.getDescriptPost()%></p>
                    </div>
                    <div class="signature">
                        <div class="icon1"></div>
                        <div class="icon2"></div>
                        <div>By <%= p.getAuthorPost() + " | " + p.formatDate()%></div>
                    </div>  
                    <%
                        }
                    %>
                </div>
                <jsp:include page="Right.jsp"/>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
        <script lang="javascript" src="js/search.js"></script>
    </body>
</html>