<%@page import="model.Question"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
        <link rel="stylesheet" href="css/managequiz.css" />
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="body">
                <%
                    if (request.getAttribute("listQ") != null) {
                        ArrayList<Question> listQ = (ArrayList<Question>) request.getAttribute("listQ");
                %>
                <div class="body-title">
                    <div class="noq">
                        <p>Number of Questions: <span><%=listQ.size()%></span></p>
                    </div>
                </div>
                <div class="list-ques">
                    <%
                        for (Question i : listQ) {
                    %>
                    <div class="ques-bg">
                        <div class="ques">
                            <h1>Question</h1>
                            <p><%=i.getQues()%></p>
                        </div>
                        <div class="datecreate ques">
                            <h1>DateCreated</h1>
                            <p><%=i.formatDateCreate()%></p>
                        </div>
                    </div>
                    <%}%>
                </div>
                <%}
                %>
            </div>
        </div>
    </body>
</html>
