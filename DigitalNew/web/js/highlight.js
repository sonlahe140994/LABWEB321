var objTitles = document.getElementsByClassName("title-search");
const highLightText = (text) => {
    var textSearch = document.getElementById("searchInput");
    var regex = new RegExp(textSearch.value, 'gi');
    var result = text.replace(regex, '<span class="highlight">$&</span>');
    return result;
};
const highLight = () => {
    for (var i = 0; i < objTitles.length; i++) {
        objTitles[i].innerHTML = highLightText(objTitles[i].innerHTML);
    }
};
highLight();