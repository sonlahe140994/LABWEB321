<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Contact</title>
        <link rel="stylesheet" href="css/Header.css">
        <link rel="stylesheet" href="css/HomePage.css">
        <link rel="stylesheet" href="css/Right.css">
        <link rel="stylesheet" href="css/contact.css">
        <script type="text/javascript" src="https://www.google.com/jsapi?callback=gloader_ready"></script>
    </head>


    <body>
        <div class="container">
            <div class="main">
                <!--top-->
                <div class="top">
                    <div class="nav">
                        <div class="nav-inner">
                            <ul>
                                <li>
                                    <a href="">My Font Page</a>
                                </li>
                                <li><a href="">Gallery 1</a></li>
                                <li><a href="">Gallery 2</a></li>
                                <li><a href="">Contact</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="header">
                        <div class="image">
                            <img src="img/logo.png">
                        </div>
                        <div class="title">
                            <p class="patitle">PHOTOGRAPHER</p>
                            <p class="subtitle">Welcome to this website</p>
                        </div>
                    </div>
                </div>
                <!--Body-->
                <div class="body-page">
                    <div class="body-1">
                        <%
                            if (request.getAttribute("mess") != null) {
                                String mess = (String) request.getAttribute("mess");
                        %>
                        <h1><%=mess%></h1>
                        <%} else {%>
                        <h1>Error</h1>
                        <%}%>
                    </div>
                </div>
                <!--Footer-->
                <div class="footer">
                    <div class="link-number">
                        <a href="">Created with SimpleSite</a>
                        <span class="footer-page-counter-item">8</span>
                        <span class="footer-page-counter-item">3</span>
                        <span class="footer-page-counter-item">1</span>
                        <span class="footer-page-counter-item">9</span>
                        <span class="footer-page-counter-item">9</span>
                        <span class="footer-page-counter-item">7</span>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/contact.js"></script>
    </body>

</html>