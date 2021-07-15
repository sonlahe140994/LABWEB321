
var index = 0;

function showSlide() {
    var index = 0;
    var objSlide = document.getElementsByClassName("slide");
    for (let i = 0; i < objSlide.length; i++) {
        objSlide[i].style.display = "none";
    }
    objSlide[index].style.display = "block";
}

function next() {
    var index = 0;
    var objSlide = document.getElementsByClassName("slide");
    for (let i = 0; i < objSlide.length; i++) {
        if (objSlide[i].style.display == "block") {
            index = i;
        }
        objSlide[i].style.display = "none";
    }
    if (index == objSlide.length - 1) {
        console.log(index);
        index = -1;
    }
    objSlide[index + 1].style.display = "block";
}

function prev() {
    var index = 0;
    var objSlide = document.getElementsByClassName("slide");
    for (let i = 0; i < objSlide.length; i++) {
        if (objSlide[i].style.display == "block") {
            index = i;
        }
        objSlide[i].style.display = "none";
    }
    if (index == 0) {
        index = objSlide.length - 1;
    }
    objSlide[index - 1].style.display = "block";
}
window.onload = showSlide();

function mouseEffect() {
    var objItem = document.getElementsByClassName("item-gallery");
    for (let i = 0; i < objItem.length; i++) {
        if (objItem[i] != null) {
            objItem[i].onmouseover = function () {
                objItem[i].style.cursor = 'pointer';
            }
            objItem[i].onclick = function () {
                showModal(i);
            }
        }
    }
}

function showModal(i) {
    var objItem = document.getElementsByClassName("item-gallery");
    var objMainImg = document.getElementsByClassName("main-img");
    var objModals = document.getElementsByClassName("modals");
    var objModalImg = document.getElementsByClassName("modal-img");
    var objCloseButton = document.getElementsByClassName("close-button");

    objModals[i].style.display = "block";
    objModalImg[i].src = objMainImg[i].src;
    objCloseButton[i].onclick = function () {
        objModals[i].style.display = 'none';
    }
}

function run() {
    setInterval(function () {
        next();
    }, 3000);
}

mouseEffect();
run();