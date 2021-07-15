//var objBtnGo = document.getElementById("searchGoBtn");
////objBtnGo.onclick = function () {
////    var objInputSearch = document.getElementById("searchInput");
//////    objBtnGo.href = "SearchServlet?searchT=" + objInputSearch.value;
//////    alert(objInputSearch.value);
//////    console.log(objInputSearch.value);
////};
function  showPost(i) {
    window.open("HomeServlet?id=" + i);
};


