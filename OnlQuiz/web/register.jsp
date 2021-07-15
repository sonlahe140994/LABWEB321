<%@page import="model.Permission"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
        <link rel="stylesheet" href="css/register.css">
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="body">
                <h1>Registration Form</h1>
                <form action="RegisterServlet" method="post" class="f-login">
                    <div class="input-area">
                        <span>User Name: </span
                        ><input type="text" name="user" class="input-data" required="true"/><br />
                    </div>
                    <div class="input-area">
                        <span>Password: </span
                        ><input type="password" name="pass" class="input-data" required="true" /><br />
                    </div>
                    <div class="input-area">
                        <span>User Type: </span>
                        <select name="types" id="" class="user-type">
                            <%
                                if (request.getAttribute("listPer") != null) {
                                    ArrayList<Permission> listPer = (ArrayList<Permission>) request.getAttribute("listPer");
                                    for (Permission i : listPer) {
                            %>
                            <option value="<%=i.getId()%>"><%=i.getName()%></option>
                            <%}
                                }%>
                        </select>
                    </div>
                    <div class="input-area">
                        <span>Email: </span>
                        <input type="text" name="email" class="input-data email-input" required="true">
                    </div>
                    <div class="input-area">
                        <input type="submit" value="Sign in" class="res-btn" />
                    </div>
                </form>
                                <h2 class="warm">${erm}</h2>
            </div>
        </div>
    </body>
</html>
