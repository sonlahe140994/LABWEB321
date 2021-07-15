<%-- 
    Document   : Error
    Created on : Jun 23, 2021, 6:56:35 PM
    Author     : dinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (request.getAttribute("error") != null) {
                String mess = (String)request.getAttribute("error");
        %>
        <h1><%=mess%></h1>
        <%}%>
    </body>
</html>
