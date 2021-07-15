<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Log In</title>
        <link rel="stylesheet" href="css/login.css" />
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="body">
                <%
                    if (session.getAttribute("a") == null) {
                %>
                <h1>Login Form</h1>
                <form action="LoginServlet" method="post" class="f-login">
                    <div class="input-area">
                        <span>User Name: </span
                        ><input type="text" name="user" class="input-data" required="true"/><br />
                    </div>
                    <div class="input-area">
                        <span>Password: </span><input type="password" name="pass" class="input-data" required="true"/><br />
                    </div>
                    <div class="input-area"><input type="submit" value="Sign in" /><a href="RegisterServlet">Register</a></div>
                </form>
                <h3 class="warm">${mess}</h3>
                <%} else {%>
                <h1>Welcome ${sessionScope.a.getUserName()}</h1>
                <h2>${mess1}<h2/>
                    <%}%>
            </div>
        </div>
    </body>
</html>
