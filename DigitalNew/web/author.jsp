<%-- 
    Document   : searchResult
    Created on : May 19, 2021, 10:24:14 AM
    Author     : dinht
--%>
<%@page import="model.Author"%>
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
        <link rel="stylesheet" type="text/css" href="css/author.css">
        <link rel="stylesheet" type="text/css" href="css/search.css">
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">

                <div class="list-au-bg">
                    <%
                        if (request.getAttribute("lau") != null) {
                            PostDAO pd = new PostDAO();
                            ArrayList<Author> list = (ArrayList<Author>) request.getAttribute("lau");
                            for (Author i : list) {
                                ArrayList<Post> lpost = pd.getPostByAuId(i.getAuId());
                    %>
                    <div class="au">
                        <h1 class="name-au">Author:<%=i.getAuName()%></h1>
                        <div class="list-au-post">
                            <h4>Num of Post: <%=lpost.size()%> </h4>
                            <%
                                for (Post p : lpost) {
                            %>
                            <div class="post">
                                <div class="sResult">
                                    <div class="sText">
                                        <p class="title-search"onclick="showPost(<%=p.getIdPost()%>)" ><%=p.getTitlePost()%></p>
                                    </div>
                                    <div>
                                        <img class="img-post" src="img/<%=p.getImgPost()%>">
                                    </div>
                                    <div class="author-by">
                                        By  <%=i.getAuName()%>| <%=p.getTimePost()%>
                                    </div>
                                </div>
                            </div>
                            <%}%>
                        </div>
                    </div>
                    <%
                            }
                        }
                    %>
                </div>

                <jsp:include page="Right.jsp"/>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
        <script>
            function  showPost(i) {
                window.open("HomeServlet?id=" + i);
            }
            ;
        </script>
    </body>

</html>