<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quiz Time</title>
<link rel="stylesheet" href="style.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

<!-- Displaying the alert message for added question -->

<script type="text/javascript">
    function bodyLoad() {
       if (${m}==2) {
    	   alert('Question Added Successfully');
       }else if(${m}==1){
    	   alert('Recruiter Added Successfully');
       } 
       else{ 
    		   return false;
    	   }
    }
 </script>

<script id="sap-ui-bootstrap"
	src="https://sapui5.hana.ondemand.com/resources/sap-ui-core.js"
	data-sap-ui-libs="sap.m">	
</script>
</head>

<style>
.ex {
	padding: 0.01cm 1.2cm;
}
.mydiv {
	overflow: hidden;
	background-color: #87CEFA;
	margin: left;
}
</style>

<!-- Disabling browser back button -->
<script>
history.pushState(null, null, document.URL);
window.addEventListener('popstate', function () {
    history.pushState(null, null, document.URL);
});
</script>

<body style="background-color: #FDF5E6" onload="bodyLoad();">

<!--  Displaying the header part, logo and logout button -->
	<center>
		<div class="mydiv">
			<img src="appLogo.png" class="quizLogo">
			<h2 align="left" class="quizText">Quiz Time</h2>
			<h5 align="right" class="quizUser">Welcome, ${adminName}</h5>
			<a href="adminlogout.htm"> <img src="logout.png"
				class="exaLogBtn">
			</a>
		</div>
	</center>

</body>

<!-- Providing the admin different operations link in adminview page  -->
<div
	style="height: 100%; margin: 35px; font-size: 20px; color: #2196F3;"
	id="tabs">
	<ul>
		<li><a href="participantResult.htm">Participants Result <span
				class="fa fa-arrow-right" style="cursor: pointer;"></span></a></li>
		<li><a href="generalmcq.htm">Question Bank <span
				class="fa fa-arrow-right" style="cursor: pointer;"></span></a></li>
		<li><a href="participantHistory2.htm">Participants History <span
				class="fa fa-arrow-right" style="cursor: pointer;"></span></a></li>
		<li><a href="addquestion.htm">Add Question <span
				class="fa fa-arrow-right" style="cursor: pointer;"></span></a></li>
				<li><a href="recruiter.htm">Add Recruiter<span
				class="fa fa-arrow-right" style="cursor: pointer;"></span></a></li>
	</ul>
	
</div>

</html>