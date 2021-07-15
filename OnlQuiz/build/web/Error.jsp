<%-- 
    Document   : Error
    Created on : Jun 28, 2021, 5:44:35 PM
    Author     : dinht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error page</title>
    </head>
    <body>
        <%
            if (request.getAttribute("err") != null) {
                String a = (String) request.getAttribute("err");
        %>
        <h1><%=a%></h1>
        <%}%>
    </body>
</html>
