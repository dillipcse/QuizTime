<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<title>Quiz Time</title>
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<script type="text/javascript">
	function bodyLoad2() {
		quizTabActivation();
		if ("${b}" == "general") {
			alert('Action Performed Successfully');
			window.location = "generalmcq.htm";
		} else if ("${b}" == "apti") {
			alert('Action Performed Successfully');
			window.location = "aptitude.htm";
		} else if ("${b}" == "sapui5") {
			alert('Action Performed Successfully');
			window.location = "sapui5.htm";
		} else if ("${b}" == "javascript") {
			alert('Action Performed Successfully');
			window.location = "javascript.htm";
		} else if ("${b}" == "java") {
			alert('Action Performed Successfully');
			window.location = "java.htm";
		} else {
			return false;
		}
	}
</script>

<!--script for high lighting the color of active tab  -->

<script type="text/javascript">
	function tabBgChange(evt) {
		var oCont = $(".container")[0].style;
		oCont.display = "block";
		if (typeof (Storage) !== "undefined")
			localStorage.setItem("Tabvalue", evt.parentElement
					.getAttribute("data"));
		else
			alert("Sorry, your browser does not support Web Storage...");
	}
	
	//On load one of the tab should be in active mode
	function quizTabActivation() {
		var activeTab = parseInt(localStorage.getItem("Tabvalue"));
		if (activeTab != undefined) {
			var aArr = $(".tab");
			for (var i = 0; i < aArr.length; i++) {
				if (i + 1 == activeTab)
					aArr[i].classList.value = "tab tabActive";
			}
		}
	}
	//change Tab number in local storage
	function setTabNumber() {
		localStorage.Tabvalue = 1
	}
	function setDeletedTabNumber() {
		localStorage.Tabvalue = 6
	}
	
	//Sending back deleted questions to respective technologies 
	function setMoveInbox() {
		var techId = document.getElementById("techId").value;
		if (techId == "GE") {
			localStorage.Tabvalue = 1

		} else if (techId == "AP") {
			localStorage.Tabvalue = 2

		} else if (techId == "UI") {
			localStorage.Tabvalue = 3
		} else if (techId == "JS") {
			localStorage.Tabvalue = 4

		} else if (techId == "JA") {
			localStorage.Tabvalue = 5
		}
	}
</script>

<style type="text/css">
ul.nav nav-tabs {
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 200px;
	background-color: #f1f1f1;
}

li a {
	display: block;
	color: #000;
	padding: 8px 16px;
	text-decoration: none;
}

li a.active {
	background-color: #4CAF50;
	color: white;
}

div.bs-example {
	color: white;
	padding: 3px;
}
</style>
</head>

<body style="background-color: #FDF5E6" onload="bodyLoad2()">

	<!-- Displaying the alert message for added question -->
	<center>
		<div class="mydiv">
			<a href="adminview.htm" onclick="setTabNumber()"><span
				class="fa fa-arrow-left w3-xlarge quizNavBack"></span></a> <img
				src="appLogo.png" class="quizLogo">
			<h2 align="left" class="quizText">Quiz Time</h2>
			<h5 align="right" class="quizUser">Welcome, ${adminName}</h5>
			<a href="adminlogout.htm"> <img src="logout.png"
				class="exaLogBtn">
			</a>
		</div>
	</center>

	<!--Form for displaying all the technologies with respective questions -->

	<form method="get" bgcolor="#FDF5E6" style="margin: 24px">
		<div class="container">
			<div class="bs-example">
				<div id="idGeneral" class="tab tabInActive" data="1">
					<a href="generalmcq.htm" onclick="tabBgChange(this)">General </a>
				</div>
				<div id="idAptitude" class="tab tabInActive" data="2">
					<a href="aptitude.htm" onclick="tabBgChange(this)">Aptitude</a>
				</div>
				<div id="idSapui5" class="tab tabInActive" data="3">
					<a href="sapui5.htm" onclick="tabBgChange(this)">SAPUI5</a>
				</div>
				<div id="idJS" class="tab tabInActive" data="4">
					<a href="javascript.htm" onclick="tabBgChange(this)">JavaScipt</a>
				</div>
				<div id="idJava" class="tab tabInActive" data="5">
					<a href="java.htm" onclick="tabBgChange(this)">Java</a>
				</div>
				<div id="idtrash" class="tab tabInActive" data="6">
					<a href="trash.htm" onclick="tabBgChange(this)">Trash</a>
				</div>
			</div>
		</div>

		<!-- Displaying only aptitude questions -->
		<c:forEach var="ap" items="${aptitudeq}">
			<p class="quizQuestionBank">Q)&nbsp;&nbsp;${ap.question}</p>
			<center>
				<span><a href="editque.htm?qid=${ap.qid}"><span
						class="glyphicon glyphicon-pencil"></span></a> </span>&nbsp;&nbsp;&nbsp; <span><a
					href="delete.htm?qid=${ap.qid}&question=${ap.question}&optionA=${ap.optionA}&optionB=${ap.optionB}&optionC=${ap.optionC}&optionD=${ap.optionD}&qkey=${ap.qkey}&techId=${ap.techId}&compId=${ap.compId}"><span
						class="glyphicon glyphicon-trash" onclick="setDeletedTabNumber();"></span></a>
				</span>
			</center>
			<div>A.&nbsp;${ap.optionA}</div>
			<div>B.&nbsp;${ap.optionB}</div>
			<div>C.&nbsp;${ap.optionC}</div>
			<div>D.&nbsp;${ap.optionD}</div>
			<div>Answer:&nbsp;${ap.qkey}</div>
			<hr>
		</c:forEach>

		<!-- Displaying only Java questions -->

		<c:forEach var="j" items="${javaq}">
			<p class="quizQuestionBank">Q)&nbsp;&nbsp;${j.question}</p>
			<center>
				<span><a href="editque.htm?qid=${j.qid}"><span
						class="glyphicon glyphicon-pencil"></span></a> </span>&nbsp;&nbsp;&nbsp; <span><a
					href="delete.htm?qid=${j.qid}&question=${j.question}&optionA=${j.optionA}&optionB=${j.optionB}&optionC=${j.optionC}&optionD=${j.optionD}&qkey=${j.qkey}&techId=${j.techId}&compId=${j.compId}"><span
						class="glyphicon glyphicon-trash" onclick="setDeletedTabNumber();"></span></a>
				</span>
			</center>
			<div>A.&nbsp;${j.optionA}</div>
			<div>B.&nbsp;${j.optionB}</div>
			<div>C.&nbsp;${j.optionC}</div>
			<div>D.&nbsp;${j.optionD}</div>
			<div>Answer:&nbsp;${j.qkey}</div>
			<hr>
		</c:forEach>

		<!-- Displaying only general questions -->

		<c:forEach var="u" items="${generalMcqList}">
			<p class="quizQuestionBank">Q)&nbsp;&nbsp;${u.question}</p>
			<center>
				<span><a href="editque.htm?qid=${u.qid}"><span
						class="glyphicon glyphicon-pencil"></span></a> </span>&nbsp;&nbsp;&nbsp; <span><a
					href="delete.htm?qid=${u.qid}&question=${u.question}&optionA=${u.optionA}&optionB=${u.optionB}&optionC=${u.optionC}&optionD=${u.optionD}&qkey=${u.qkey}&techId=${u.techId}&compId=${u.compId}"><span
						class="glyphicon glyphicon-trash" onclick="setDeletedTabNumber();"></span></a>
				</span>
			</center>
			<div>A.&nbsp;${u.optionA}</div>
			<div>B.&nbsp;${u.optionB}</div>
			<div>C.&nbsp;${u.optionC}</div>
			<div>D.&nbsp;${u.optionD}</div>
			<div>Answer:&nbsp;${u.qkey}</div>
			<hr>
		</c:forEach>

		<!-- Displaying only javaScript questions -->

		<c:forEach var="js" items="${javaScriptq}">
			<p class="quizQuestionBank">Q)&nbsp;&nbsp;${js.question}</p>
			<center>
				<span><a href="editque.htm?qid=${js.qid}"><span
						class="glyphicon glyphicon-pencil"></span></a> </span>&nbsp;&nbsp;&nbsp; <span><a
					href="delete.htm?qid=${js.qid}&question=${js.question}&optionA=${js.optionA}&optionB=${js.optionB}&optionC=${js.optionC}&optionD=${js.optionD}&qkey=${js.qkey}&techId=${js.techId}&compId=${js.compId}"><span
						class="glyphicon glyphicon-trash" onclick="setDeletedTabNumber();"></span></a>
				</span>
			</center>
			<div>A.&nbsp;${js.optionA}</div>
			<div>B.&nbsp;${js.optionB}</div>
			<div>C.&nbsp;${js.optionC}</div>
			<div>D.&nbsp;${js.optionD}</div>
			<div>Answer:&nbsp;${js.qkey}</div>
			<hr>
		</c:forEach>

		<!-- Displaying only SAP questions -->

		<c:forEach var="ui" items="${Sapui5q}">
			<p class="quizQuestionBank">Q)&nbsp;&nbsp;${ui.question}</p>
			<center>
				<span><a href="editque.htm?qid=${ui.qid}"><span
						class="glyphicon glyphicon-pencil"></span></a> </span>&nbsp;&nbsp;&nbsp; <span><a
					href="delete.htm?qid=${ui.qid}&question=${ui.question}&optionA=${ui.optionA}&optionB=${ui.optionB}&optionC=${ui.optionC}&optionD=${ui.optionD}&qkey=${ui.qkey}&techId=${ui.techId}&compId=${ui.compId}"><span
						class="glyphicon glyphicon-trash" onclick="setDeletedTabNumber();"></span></a>
				</span>
			</center>
			<div>A.&nbsp;${ui.optionA}</div>
			<div>B.&nbsp;${ui.optionB}</div>
			<div>C.&nbsp;${ui.optionC}</div>
			<div>D.&nbsp;${ui.optionD}</div>
			<div>Answer:&nbsp;${ui.qkey}</div>
			<hr>
		</c:forEach>

		<!-- Trash for displaying deleted questions -->

		<c:forEach var="ui" items="${trash}">
			<p>Q)&nbsp;&nbsp;${ui.question}</p>
			<center>
				<span> <a
					href="movetobank.htm?qid=${ui.qid}&question=${ui.question}&optionA=${ui.optionA}&optionB=${ui.optionB}&optionC=${ui.optionC}&optionD=${ui.optionD}&qkey=${ui.qkey}&techId=${ui.techId}&compId=${ui.compId}">
						<span class="glyphicon glyphicon-folder-open"
						onclick="setMoveInbox();"></span>
				</a></span>
			</center>

			<!-- Passing techId to setMoveInbox()  -->
			<input type="hidden" name="techId" id="techId" value=${ui.techId}>

			<div>A.&nbsp;${ui.optionA}</div>
			<div>B.&nbsp;${ui.optionB}</div>
			<div>C.&nbsp;${ui.optionC}</div>
			<div>D.&nbsp;${ui.optionD}</div>
			<div>Answer:&nbsp;${ui.qkey}</div>
			<hr>
		</c:forEach>
	</form>
</body>
</html>