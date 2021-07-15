<%@page import="model.Concept"%>
<%@page import="dal.ConceptDAO"%>
<%@page import="model.Author"%>
<%@page import="dal.AuthorDAO"%>
<%@page import="model.Card"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="css/body-home.css">
        <link rel="stylesheet" href="css/grid.css"/>
    </head>

    <body style="margin: 0;padding: 0;">
        <div class="container">
            <div>
                <jsp:include page="Header.jsp"/>
                <div class="body">
                    <div class="notification">
                        <p><span>Psst.</span> Don't forget to confirm your mail! Just look for the message we sent you.
                            <span>Resend Email</span> or <span>change your address</span></p>
                    </div>
                    <div class="list-gallery">
                        <div class="info-card card">
                            <div class="invite-saving">
                                <p>Are your friends saving ideas you might like?</p>
                                <div class="list-img-suggest">
                                    <img src="img/limg1.jpg" alt="">
                                    <img src="img/limg2.jpg" alt="">
                                    <img src="img/limg3.jpg" alt="">
                                    <img src="img/limg4.jpg" alt="">
                                </div>
                                <div class="invite-bar">
                                    <a href="#">More ideas from friends</a>
                                    <div class="arrow"></div>
                                </div>
                            </div>
                            <div class="invite-bar">
                                <a href="#">Invite friend to Pinterest</a>
                                <div class="arrow"></div>
                            </div>
                        </div>
                        <%
                            if (request.getAttribute("listCard") != null) {
                                ArrayList<Card> col1 = (ArrayList<Card>) request.getAttribute("listCard");
                                AuthorDAO ad = new AuthorDAO();
                                ConceptDAO cd = new ConceptDAO();
                                for (Card i : col1) {
                                    Author au = ad.getAuthorById(i.getAuthorId());
                                    Concept c = cd.getConceptById(i.getConceptId());
                        %>
                        <div class="card">
                            <div class="list-img-card">
                                <div class="save-button">
                                    <div class="pin-save-icon"></div>
                                    <span>Save</span>
                                </div>
                                <img class="list-img" src="img/<%=i.getImgMain()%>" alt="">
                                <%
                                    if (i.getExpandPin() != null) {
                                %>

                                <div class="link-contact">
                                    <a href="#">
                                        <div class="logo-contact"></div>
                                        <span class="contact-text">Learn more at <%=i.getExpandPin()%></span>
                                    </a>
                                </div>
                                <%} else {%>
                                <div class="expand"><a href="">Expand Pin</a></div>
                                <%}%>
                            </div>
                            <article>
                                <%
                                    if (i.getFromUrl() != null && i.getFromLogo() != null) {
                                %>
                                <aside>
                                    <img src="img/<%=i.getFromLogo()%>" alt="">
                                    <span>from <%=i.getFromUrl()%></span>
                                </aside>
                                <%}%>
                                <title><%=i.getTitle()%></title>

                                <p><%=i.getDes()%>
                                </p>
                                <div>
                                    <i class="repin"></i>
                                    <span class="social-meta-count"><%=i.getNumOfPin()%></span>
                                </div>
                                <div>
                                    <i class="like-icon"></i>
                                    <span class="social-meta-count"><%=i.getNumOfLike()%></span>
                                </div>
                            </article>
                            <div class="credit-item">
                                <img src="img/<%=au.getImgUrl()%>" alt="<%=au.getImgUrl()%>">
                                <div class="credit-infor">
                                    <p class="credit-name"><a href="#"><%=au.getAuthorName()%></a></p>
                                    <p class="credit-type-img"><%=au.getNameConcept()%></p>
                                </div>
                                <button class="credit-button"></button>
                            </div>
                            <div class="footer-card">
                                From <%=c.getName()%>
                            </div>
                        </div>
                        <%}
                            }%>
                    </div>
                    <button onclick="initData()">Click Here</button>
                </div>
                <jsp:include page="Footer.jsp"/>
            </div>
            <script src="js/credit.js"></script>
            <script>
                        function initData() {
                            var cardsObj = document.getElementsByClassName("card");
                            var xhttp = new XMLHttpRequest();
                            xhttp.open("GET", "GetDataServlet?index="+cardsObj.length, false);
                            xhttp.onreadystatechange = function () {
                                if (xhttp.status === 200 && this.readyState === 4) {
                                    var listImg = document.getElementsByClassName("list-gallery")[0];
                                    listImg.innerHTML += xhttp.responseText;

                                }
                            };
                            xhttp.send();
                        }

            </script>
    </body>

</html>