<%@page import="model.Contact"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Right</title>
        <link rel="stylesheet" href="css/Right.css">
    </head>

    <body>

        <div class="intro-product" id="sci">
            <div class="header-right">
                <h4>Share this page</h4>
            </div>
            <%
                if (request.getAttribute("contact") != null) {
                    Contact ct = (Contact) request.getAttribute("contact");
            %>
            <div class="social">
                <div>
                    <ul class="ulsocial">
                        <li><img src="img/face.png" alt=""><a href="#" onclick="shareFb()">Share on Facebook</a></li>
                        <li><img src="img/twitter.png" alt=""><a href="<%=ct.getTwitterUrl()%>" >Share on Twitter</a></li>
                        <li><img src="img/google.png" alt=""><a href="<%=ct.getGoogleUrl()%>" >Share on Google+</a></li>
                    </ul>
                </div>
            </div>
            <%}%>
        </div>
        <script>
            window.fbAsyncInit = function () {
                FB.init({
                    appId: '464714577956097',
                    autoLogAppEvents: true,
                    xfbml: true,
                    version: 'v10.0'
                });
            };
        </script>
        <script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_US/sdk.js"></script>
        <script>
            function shareFb() {
                FB.ui({
                    method: 'share',
                    href: 'http://us-123photo.simplesite.com/'
                }, function (response) {
                });
            }
        </script>
    </body>

</html>