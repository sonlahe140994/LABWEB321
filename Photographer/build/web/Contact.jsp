<%@page import="model.Contact"%>
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
                <jsp:include page="Header.jsp"/>
                <!--Body-->
                <div class="body-page">
                    <div class="body-1">
                        <div class="intro-product">
                            <div>
                                <h1 id="h1">Contact</h1>

                                <%Contact c = null;
                                    if (request.getAttribute("contact") != null) {
                                        c = (Contact) request.getAttribute("contact");
                                    }
                                %>
                                <%if (c != null) {%>
                                <h1><%=c.getNameContact()%></h1>
                                <%}%>
                                <table id="tb1">
                                    <tr>
                                        <td>Address:</td>
                                        <%if (c != null) {%>
                                        <td><%=c.getAddressContact()%></td>
                                        <%}%>
                                    </tr>
                                    <tr>
                                        <td>City: </td>
                                        <%if (c != null) {%>
                                        <td><%=c.getCityContact()%></td>
                                        <%}%>
                                    </tr>
                                    <tr>
                                        <td>Country: </td>
                                        <%if (c != null) {%>
                                        <td><%=c.getCountryContact()%></td>
                                        <%}%>
                                    </tr>

                                </table>
                                <table id="tb2">
                                    <tr>

                                        <td>Tel: </td>
                                        <%if (c != null) {%>
                                        <td><%=c.getTelephoneContact()%></td>
                                        <%}%>
                                    </tr>
                                    <tr>
                                        <td>Email: </td>
                                        <%if (c != null) {%>
                                        <td><%=c.getEmailContact()%></td>
                                        <%}%>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="intro-product" id="sci">
                            <div class="header-right">
                                <h4>Share this page</h4>
                            </div>
                            <div class="social">
                                <div>
                                    <ul class="ulsocial">
                                        <li><img src="img/face.png" alt=""><a href="">Share on Facebook</a></li>
                                        <li><img src="img/twitter.png" alt=""><a href="">Share on Twitter</a></li>
                                        <li><img src="img/google.png" alt=""><a href="">Share on Google+</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--List Gallery-->
                    <div class="map">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.477154718109!2d105.52461355117495!3d21.013585578352618!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x0!2zMjHCsDAwJzQ4LjkiTiAxMDXCsDMxJzM1LjQiRQ!5e0!3m2!1svi!2s!4v1622087286866!5m2!1svi!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
                        <div style="white-space: nowrap; text-align: center; width: 500px; padding: 6px 0;"></div>
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