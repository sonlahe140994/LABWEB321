<%-- 
    Document   : Error
    Created on : May 19, 2021, 9:22:40 AM
    Author     : dinht
--%>

<%@page import="model.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="content">
                <div class="main">
                    <h1>Not Found</h1>
                    <%
                        if (request.getAttribute("mess") != null) {
                            String mess = (String) request.getAttribute("mess");

                    %>
                    <h2><%=mess%></h2>
                    <%
                        }%>
                </div>
                <jsp:include page="Right.jsp"/>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
