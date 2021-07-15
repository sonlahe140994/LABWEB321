
function validateForm()
{
    var grCheckB = document.getElementsByName("cbox");
    var check = false;
    for (var i in grCheckB) {
        if (grCheckB[i].checked === true) {
            check = true;
        }
    }
    if(!check){
        alert("Select answer");
    }
    return check;
}

function  validateCheckbox(item) {
    var grCheckB = document.getElementsByName("cbox");
    for (var i in grCheckB) {
        if (grCheckB[i] !== item) {
            grCheckB[i].checked = false;
        }
    }
}
;

function checkResult(){
    if(validateForm()){
        alert("Add success");
    }
}
