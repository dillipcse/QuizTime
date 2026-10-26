<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.exa.quiz.controller.InstructionController.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<title>Quiz Time</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

</head>
<script type = "text/javascript">
document.onkeydown = function(ev) {	
var key;
ev = ev || event;
key = ev.keyCode;
if (key == 116) {
return false;  // disable F5 key
}
</script>
<script>
	function incQCount(){
		this.qCount = 0;
		this.arr = [];
		this.arrIndex = 0;
	}
</script>

<!-- Disabling browser back button -->
<script>
history.pushState(null, null, document.URL);
window.addEventListener('popstate', function () {
    history.pushState(null, null, document.URL);
});
</script>

<%
	int qCount = 0;
%>
<style type="text/css">
.ex {
	padding: 0.21cm 1.2cm;
}
.headerTimerFont{
    font-size: 17px;
    font-weight: bolder;
}

.mydiv {
	overflow: hidden;
	background-color: #87CEFA; html { height : 100%;
	display: table;
	margin: auto;
}
}
</style>

<body style="background-color: #FDF5E6;" onload="incQCount()">

	<!--  Displaying header part -->
	<center>
		<div class="mydiv">
			<img src="appLogo.png"
				style="width: 80px; height: 50px; float: left !important; margin: 2px; margin-top: 9px;">
			<h2 class="ex" align="left"
				style="font-family: cursive; color: #0a374e">Quiz Time</h2>
		</div>

	</center>

	<form id="id_form" action="saveresult.htm" method="post"
		style="padding: 30px;">
		<div
			style="position: fixed;float: right !important;right: 25px; top: 17px;">
			<div style="float: right;">
				<font size="2" style="color: #f30909" class="headerTimerFont">Time Left : <span
					id="timer"></span></font>
			</div>
			<div style="margin: 15px; float: right; margin-right: -162px;">
				<font style="color: #2409f3" class="headerTimerFont">Answered Questions :<span
					id="qc">0/30</span></font>
			</div>
		</div>
		<!-- Displaying Timer -->

		<script type="text/javascript">
            document.getElementById("timer").innerHTML = 30 + ":" + 00;
            startTimer();
            

            function startTimer() {
                var presentTime = document.getElementById('timer').innerHTML;
                var timeArray = presentTime.split(/[:]+/);
                var m = timeArray[0];
                var s = checkSecond((timeArray[1] - 1));
                if (s == 59) {
                    m = m - 1
                }
                if (m < 0) {
                    
                    alert('Time is over');
                  document.getElementById("id_form").submit();  

                }
                document.getElementById('timer').innerHTML =
                    m + ":" + s;
                setTimeout(startTimer, 1000);
            }

            function checkSecond(sec) {
                if (sec < 10 && sec >= 0) {
                    sec = "0" + sec
                };
                if (sec < 0) {
                    sec = "59"
                };
                return sec;
            }
            
            /*  Displaying total number of answered question*/
            function onCount(num){
            	var flag;
            	//for first time
            	if(!this.arr.length)
                	flag =true;
            	else{
            		//store 
            		for(var i=0; i<this.arr.length; i++){
                		if(num == this.arr[i].qNum){
                			flag =false;
                			break;
                		}
                		else{
                        	flag =true;
                		}
                	}
            	}
            	
            	if(flag){
            		this.arr[this.arrIndex] = {};
                	this.arr[this.arrIndex].qNum = num;
                	this.arr[this.arrIndex].check = true; 
                	this.arrIndex++;
            		this.qCount++;
                	document.getElementById('qc').innerHTML = " "+this.qCount+"/30 ";
            	}
            }
        </script>
		<%
			int count = 1;
		%>
		<%
			int i = 1;
		%>

		<!-- Displaying the questions  -->

		<c:forEach items="${obj}" var="que">
			<c:set var="count" value="1" scope="page" />
			<p class="ex3">
				<%=count++%>.${que.question}
			</p>

			<div class="ex3">

				<div class="radio">
					<c:set var="num" value="<%=i%>"></c:set>
					<label> <input type="radio" name="<%=i%>" id="optionId"
						value="A" onclick="onCount(${que.qid})">${que.optionA}</label>
				</div>
				<div class="radio">
					<label> <input type="radio" name="<%=i%>" id="optionId"
						value="B" onclick="onCount(${que.qid})">${que.optionB}</label>
				</div>
				<div class="radio ">
					<label> <input type="radio" name="<%=i%>" id="optionId"
						value="C" onclick="onCount(${que.qid})">${que.optionC}</label>
				</div>
				<div class="radio ">
					<label> <input type="radio" name="<%=i%>" id="optionId"
						value="D" onclick="onCount(${que.qid})">${que.optionD}</label>
				</div>
				<div class="radio ">
					<label> <input type="hidden" name="question<%=i%>"
						id="questionId" value="${que.question}"> <input
						type="hidden" name="optiona<%=i%>" id="optionaId"
						value="${que.optionA}"> <input type="hidden"
						name="optionb<%=i%>" id="optionbId" value="${que.optionB}">
						<input type="hidden" name="optionc<%=i%>" id="optioncId"
						value="${que.optionC}"> <input type="hidden"
						name="optiond<%=i%>" id="optiondId" value="${que.optionD}">
						<input type="hidden" name="key<%=i%>" id="keyId"
						value="${que.qkey}">
					</label>
				</div>
			</div>
			<%
				i++;
			%>
		</c:forEach>

		<!-- Submit button  -->
		<div style="margin-left: 1200px;">
			<input class="btn btn-primary" type="submit">
		</div>

	</form>
</body>

</html>