<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<html>
<head>
<title>Quiz Time</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="style.css" />

<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

</head>

<style type="text/css">
td {
	padding: 2px;
}
</style>

<!-- Disabling browser back button -->

<script>
history.pushState(null, null, document.URL);
window.addEventListener('popstate', function () {
    history.pushState(null, null, document.URL);
});
</script>

<body style="background-color: #FDF5E6">

	<!--  Displaying the header part, logo and logout button -->

	<center>
		<div class="mydiv">
			<a href="adminview.htm"><span
				class="fa fa-arrow-left w3-xlarge quizNavBack"></span></a> <img
				src="appLogo.png" class="quizLogo">
			<h2 align="left" class="quizText">Quiz Time</h2>
			<h5 align="right" class="quizUser">Welcome, ${adminName}</h5>
			<a href="adminlogout.htm"> <img src="logout.png"
				class="exaLogBtn">
			</a>
		</div>
	</center>

	<!-- Displaying form  for participantHistory-->

	<form action="participantHistory2.htm" method="post">
		<table align="center" width="500px">
			<br>
			<tr>
				<td>
					<h4>
						From <span style="color: red">*</span>
					</h4>
				</td>
				<td><input type="date" name="fromdate" id="datepicker"
					required="required" /></td>
			</tr>
			<tr>
				<td>
					<h4>
						To<span style="color: red">*</span>
					</h4>
				</td>
				<td><input type="date" name="todate" id="datepicker"
					required="required" /></td>
			</tr>

			<tr align="center">
				<td colspan="2" class="ex3">
					<button class="btn btn-primary ">Submit</button>
			</tr>

		</table>

	</form>
</body>

</html>