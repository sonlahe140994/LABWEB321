var myImg = document.getElementById("myImg");
var myModal = document.getElementById("myModal");

var imgmodal = document.getElementById("imgmodal");
var caption = document.getElementById("caption");

var closeButton = document.getElementById("close");
myImg.onclick = function () {
    imgmodal.src = myImg.src;
    myModal.style.display = "block";
    caption.innerHTML = myImg.alt;
}
closeButton.onclick = function () {
    myModal.style.display = "none";
}