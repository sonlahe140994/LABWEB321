
var btnStart = document.getElementById("start-btn");
var listQuiz = document.getElementsByClassName("list-ques")[0];
var enterObj = document.getElementsByClassName("enter")[0];
var quizObj = document.getElementsByClassName("quiz")[0];
var nextBtn = document.getElementById("next-btn");
var isFinished = false;

function newQuiz(){
    window.location.href = "takequiz.jsp";
}

nextBtn.onclick = function () {
    isFinished = true;
};

btnStart.onclick = function () {
    var nOfQues = document.getElementById("numOfQues");
    var reqQues = new XMLHttpRequest();
    reqQues.open("GET", "TakeQuizServlet?noq=" + nOfQues.value, false);
    reqQues.send();
    quizObj.style.display = "block";
    listQuiz.innerHTML += reqQues.responseText;
    enterObj.style.display = "none";
    alert("Time start");
    isFinished = false;
    var minuteOfQuiz = parseInt(nOfQues.value);
    runLock(minuteOfQuiz);
};

var timeLable = document.getElementById("time-re");

function runLock(i) {
    var minute = i - 1;
    var second = 61;
    var run = setInterval(function () {
        if (second === 0) {
            minute--;
            second = 60;
        }
        second--;
        if (minute === -1) {
            timeLable.innerHTML = "TIME UP!!!";
            clearInterval(run);
        } else {
            if (second < 10) {
                timeLable.innerHTML = minute + ":0" + second;
            } else {
                timeLable.innerHTML = minute + ":" + second;
            }
        }
        if (isFinished) {
            clearInterval(run);
        }
    }, 1000);
}
;