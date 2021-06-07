var objx = document.getElementsByClassName("title-search");
for (let x = 0; x <= objx.length; x++) {
    if (objx[x] != null) {
        objx[x].onmousedown = function () {
            objx[x].style.color = "red";
        }
        objx[x].onmouseup = function () {
            objx[x].style.color = "black";
        }
        objx[x].onmouseover = function () {
            objx[x].style.textDecoration = "underline";
            objx[x].style.color = "red";
        }
        objx[x].onmouseout = function () {
            objx[x].style.textDecoration = "none";
            objx[x].style.color = "black";
        }
        objx[x].onclick = function () {
            var id = objx[x].id;
            window.open("HomeServlet?id=" + id);
            objx[x].style.cursor = "progress";
        }
        objx[x].style.cursor = 'pointer';

    }

}
var objy = document.getElementsByClassName("title-top5");

for (let x = 0; x <= objy.length; x++) {
    if (objy[x] != null) {
        objy[x].onmousedown = function () {
            objy[x].style.color = "red";
        }
        objy[x].onmouseup = function () {
            objy[x].style.color = "black";
        }
        objy[x].onmouseover = function () {
            objy[x].style.textDecoration = "underline";
            objy[x].style.color = "red";
        }
        objy[x].onmouseout = function () {
            objy[x].style.color = "black";
        }
        objy[x].style.cursor = 'pointer';

    }

}
var gobtn = document.getElementById("go-button");
gobtn.onmouseover = function () {
    gobtn.style.fontSize = "130%";
    gobtn.style.color = "red";
    gobtn.style.cursor = "pointer";
}
gobtn.onmouseout = function () {
    gobtn.style.fontSize = "100%";
    gobtn.style.color = "black";
}
   