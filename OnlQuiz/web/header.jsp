<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="css/header.css">
    </head>
    <body>
        <div class="header">
            <div class="list-btn">
                <div class="btn-header"><a href="homepage.jsp">Home</a></div>
                <div class="btn-header"><a href="takequiz.jsp">Take Quiz</a></div>
                <div class="btn-header"><a href="makequiz.jsp">Make Quiz</a></div>
                <div class="btn-header"><a href="ManageQuizServlet">Manage Quiz</a></div>

                <div class="btn-header">
                    <%
                        if (session.getAttribute("a") != null) {
                    %>
                    <a href="LogoutServlet">Log Out</a>
                    <%}%>
                </div>

            </div>
        </div>
    </body>
</html>