var objCreditItem = document.getElementsByClassName("credit-item");
var objCreditBtn = document.getElementsByClassName("credit-button");
for (let i = 0; i <= objCreditItem.length; i++) {
  if (objCreditItem[i] !== null) {
    objCreditItem[i].onmouseover = function () {
      objCreditBtn[i].style.display = "block";
    };
    objCreditItem[i].onmouseout = function () {
      objCreditBtn[i].style.display = "none";
    };
  }
}
