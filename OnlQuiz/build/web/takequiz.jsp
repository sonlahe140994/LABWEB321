<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Take Quiz</title>
        <link rel="stylesheet" href="css/takequiz.css" />
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="body">
                <%
                    if (request.getAttribute("result") == null) {
                %>
                <div class="welcome">
                    <p>Welcome <span>${sessionScope.a.getUserName()}</span></p>
                </div>
                <div class="enter">
                    <h1>Enter number of Questions:</h1>
                    <div><input type="text" id="numOfQues" value=""></div>
                    <button id="start-btn">Start</button>
                </div>
                <%}%>
                <form action="TakeQuizServlet" method="post" >
                    <div class="quiz">
                        <div class="time">Time remaining <span id="time-re"></span></div>
                        <div class="list-ques">
                            <!--
                            <div class="ques">
                                <h2>The name of capital of VietNam after year of 1975?</h2>
                                <ul>
                                    <li><div class="ans"><input name="test" value="saiGon" type="checkbox">Sai Gon</div></li>
                                    <li><div class="ans"><input type="checkbox">Ha Noi</div></li>
                                    <li><div class="ans"><input type="checkbox">Ho Chi Minh</div></li>
                                    <li><div class="ans"><input type="checkbox">Sai Gon</div></li>
                                </ul>
                            </div>-->
                        </div>
                        <div class="btn-next"><input id="next-btn" type="submit"  value="Next"></div>
                    </div>
                </form>
                <%
                    if (request.getAttribute("result") != null) {
                %>
                <div class="result">
                    <div class="score"><p>Your score <span>${point}</span> <span>(${percent}%)</span> <span>- ${pass}</span></p></div>
                    <div class="score">Take another test <button onclick="newQuiz()">Start</button></div>
                </div>
                <%}%>
            </div>
        </div>
        <script src="js/takequiz.js"></script>
    </body>
</html>
