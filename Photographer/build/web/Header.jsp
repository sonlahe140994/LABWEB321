<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/Header.css">
        <title>Document</title>
    </head>

    <body>
        <div class="top">
            <div class="nav">
                <div class="nav-inner">
                    <ul>
                        <li>
                            <a href="HomePageServlet">My Font Page</a>
                        </li>
                        <li><a href="GalleryServlet?id=GA1">Gallery 1</a></li>
                        <li><a href="GalleryServlet?id=GA2">Gallery 2</a></li>
                        <li><a href="GalleryServlet?id=GA3">Gallery 3</a></li>
                        <li><a href="ContactServlet">Contact</a></li>
                    </ul>
                </div>
            </div>
            <div class="header">
                <div class="image">
                    <img onclick="header()" src="img/logo.png">
                </div>
                <div class="title">
                    <p class="patitle" onclick="header()">PHOTOGRAPHER</p>
                    <p class="subtitle">Welcome to this website</p>
                </div>
            </div>
        </div>
        <script>
            function header() {
                window.open('http://localhost:8080/Photographer/HomePageServlet');
            }
        </script>
    </body>

</html>