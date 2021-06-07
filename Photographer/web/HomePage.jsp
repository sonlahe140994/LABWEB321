<%@page import="model.Contact"%>
<%@page import="model.Image"%>
<%@page import="dal.ImageDAO"%>
<%@page import="model.Gallery"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>HomePage</title>
        <link rel="stylesheet" href="css/Header.css">
        <link rel="stylesheet" href="css/HomePage.css">
        <link rel="stylesheet" href="css/Right.css">
        <link rel="stylesheet" href="css/gallery.css">
        <link rel="stylesheet" href="css/modal.css"/>
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
                            <%
                                if (request.getAttribute("top1Img") != null) {
                                    Image i = (Image) request.getAttribute("top1Img");
                            %>
                            <img id="myImg" src="img/<%=i.getUrl()%>" alt="Lorem ipsum dolor sit amet">
                            <p style="font-style: italic;">Lorem ipsum dolor sit amet</p>
                            <div id="myModal" class="modal">
                                <span class="close" id="close">X</span>
                                <img class="modal-content" id="imgmodal">
                                <div id="caption"></div>
                            </div>
                            <%}%>
                        </div>
                        <jsp:include page="Right.jsp"/>
                    </div>
                    <!--List Gallery-->
                    <%
                        int pageSize = 0;
                        if (request.getAttribute("gaList") != null & request.getAttribute("psize") != null) {
                            ArrayList<Gallery> gaList = (ArrayList<Gallery>) request.getAttribute("gaList");
                            pageSize = (Integer) request.getAttribute("psize");
                            ImageDAO id = new ImageDAO();
                    %>
                    <div class="body-2">



                        <%
                            for (int i = 0; i < gaList.size(); i++) {
                                if (gaList.get(i) != null) {
                        %>
                        <div class="view-gallery">
                            <img src="img/<%=id.getTop1UrlImageByGalleryId(gaList.get(i).getGalleryId())%>" alt="">
                            <div class="descript-galery">
                                <h2><a href="GalleryServlet?id=<%=gaList.get(i).getGalleryId()%>">View <%=gaList.get(i).getTitleGallery()%></a></h2>
                                <p>
                                    <%=gaList.get(i).getDescriptionGallery()%>
                                </p>
                            </div>
                        </div>
                        <%}
                            }
                        %>
                    </div>
                    <%}%>
                    <div class="pag">
                        <ul class="pagination">
                            <%
                                if (pageSize != 0) {
                                    for (int i = 1; i <= pageSize; i++) {
                            %>
                            <li class="page-item"><a class="page-link" href="HomePageServlet?index=<%=i%>"><%=i%></a></li> 
                                <%                                 }
                                    }
                                %>
                        </ul>
                    </div>
                    <%                        if (request.getAttribute("contact") != null) {
                            Contact ct = (Contact) request.getAttribute("contact");
                    %>
                    <div class="about-script">
                        <h1>About Me</h1>
                        <div>
                            <p><%=ct.getAboutContact()%></p>
                        </div>
                    </div>
                    <%}%>
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
    </body>
    <script src="js/modal.js"></script>
</html>