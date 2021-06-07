<%@page import="dal.ImageDAO"%>
<%@page import="model.Image"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Gallery"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gallery</title>
        <link rel="stylesheet" href="css/Header.css">
        <link rel="stylesheet" href="css/HomePage.css">
        <link rel="stylesheet" href="css/Right.css">
        <link rel="stylesheet" href="css/gallery.css">
        <link rel="stylesheet" href="css/GalleryPage.css">
        <link rel="stylesheet" href="css/modal.css"/>
        <link rel="stylesheet" href="css/slide.css"/>
        <link rel="stylesheet" href="css/modelgallery.css"/>
    </head>

    <body>
        <div class="container">
            <div class="main">
                <!--top-->
                <jsp:include page="Header.jsp"/>
                <!--Body-->
                <%Gallery g = null;
                    ArrayList<Image> listSlide = null;
                    if (request.getAttribute("gal") != null && request.getAttribute("listImg") != null) {
                        g = (Gallery) request.getAttribute("gal");
                        listSlide = (ArrayList<Image>) request.getAttribute("listImg");
                    }
                %>
                <div class="body-page gla">
                    <div class="body-1">
                        <div class="intro-product">
                            <%
                                if (g != null) {
                            %>
                            <h1 class="name-gallery"><%=g.getTitleGallery()%></h1>
                            <%
                                }
                            %>
                            <div class="slide-container">
                                <%
                                    if (listSlide != null) {
                                        for (Image i : listSlide) {
                                %>
                                <div class="slide">
                                    <img src="img/<%=i.getUrl()%>" alt="">
                                </div>
                                <%}
                                    }%>
                                <div class="button">
                                    <a class="prev" onclick="prev()">&#10094;</a>
                                    <a class="next" onclick="next()">&#10095;</a>

                                </div>
                            </div>
                        </div>
                        <jsp:include page="Right.jsp"/>
                    </div>
                    <!--List Gallery-->
                    <div class="body-gallery">
                        <table>
                            <%
                                if (request.getAttribute("listImg") != null) {
                                    //ArrayList<Image> listImg = (ArrayList<Image>) request.getAttribute("listImg");
                                    ArrayList<Image> listImg = listSlide;
                                    int row = listImg.size() / 4;
                                    if (listImg.size() % 4 != 0) {
                                        row++;
                                    }
                                    int start = 0, end = 3;
                                    if (listImg.size() < 4) {
                                        end = listImg.size();
                                    }
                                    for (int i = 1; i <= row; i++) {
                                        ArrayList<Image> listBetween = new ImageDAO().getArrayBetween(listImg, start, end);
                            %>
                            <tr>
                                <%
                                    for (Image im : listBetween) {
                                %>
                                <td>
                                    <div class="item-gallery">
                                        <img class="main-img" src="img/<%=im.getUrl()%>" alt="">
                                    </div>
                                    <div class="modals">
                                        <span class="close-button">&times;</span>
                                        <img class="modal-img" alt="">
                                    </div>
                                </td>
                                <% }
                                    start = end + 1;
                                    end += 4;
                                %>
                            </tr>

                            <%
                                    }
                                }
                            %>
                        </table>

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
        <script src="js/modal.js"></script>
        <script src="js/slide.js"></script>  
    </body>

</html>