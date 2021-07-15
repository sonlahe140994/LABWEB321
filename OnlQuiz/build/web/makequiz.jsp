<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Ai là</title>
        <link rel="stylesheet" href="css/makequiz.css">
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp"/>
            <div class="body">  
                <form action="MakeQuizServlet" onSubmit="return validateForm();" method="post" >
                    <div class="ques-bg">
                        <div class="question qes">
                            <span>Question: </span>
                            <textarea name="ques" cols="60"  rows="10" required="true"></textarea>
                        </div>
                        <div class="question qes">
                            <span>Option 1: </span>
                            <textarea name="op1" cols="60" rows="5" required="true"></textarea>
                        </div>
                        <div class="question qes">
                            <span>Option 2: </span>
                            <textarea name="op2" cols="60" rows="5" required="true"></textarea>
                        </div>
                        <div class="question qes">
                            <span>Option 3: </span>
                            <textarea name="op3" cols="60" rows="5" required="true"></textarea>
                        </div>
                        <div class="question qes">
                            <span>Option 4: </span>
                            <textarea name="op4" cols="60" rows="5" required="true"></textarea>
                        </div>
                    </div>
                    <div class="ans-bg">
                        <div class="asw">
                            <span>Answer(s):</span>
                            <ul class="list-answ" >
                                <li><input type="checkbox" name="cbox" value="1" onclick="validateCheckbox(this)" checked="true" ><span>Option 1</span></li>
                                <li><input type="checkbox" name="cbox" value="2" onclick="validateCheckbox(this)"><span>Option 2</span></li>
                                <li><input type="checkbox" name="cbox" value="3" onclick="validateCheckbox(this)"><span>Option 3</span></li>
                                <li><input type="checkbox" name="cbox" value="4" onclick="validateCheckbox(this)"><span>Option 4</span></li>
                            </ul>
                        </div>
                        <input type="submit" onsubmit="checkResult()" id="save-btn" value="Save"  >
                    </div
                </form>
                <h1 style="font-size: 30px; color: red;">${result}</h1>
            </div>
        </div>
        <script src="js/makequiz.js">
        </script>
    </body>
</html>
