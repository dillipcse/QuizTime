<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<style>
.ex {
	padding: 0.01cm 1.2cm;
}

.ex1 {
	padding: 0.60cm 4.2cm;
}

.ex2 {
	padding: 0.0cm 2.4cm;
}

.ex3 {
	padding: 0.15cm 1.2cm;
}

.mydiv {
	overflow: hidden;
	background-color: #87CEFA;
	position: fixed;
	/* Set the navbar to fixed position */
	top: 0;
	/* Position the navbar at the top of the page */
	width: 100%;
}

h2 {
	color: #069;
}

h3 {
	color: #663399;
}

p1 {
	color: #D2691E;
}

.html {
	height: 100%;
	display: table;
	margin: center;
}

.body {
	height: 100%;
	display: table-cell;
	vertical-align: middle;
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

	<!--  Displaying header part -->
	<center>
		<div class="mydiv">
			<img src="appLogo.png"
				style="width: 80px; height: 50px; float: left !important; margin: 2px; margin-top: 1px;">
			<h2 class="ex" align="left"
				style="font-family: cursive; color: #0a374e">Quiz Time</h2>
		</div>
	</center>

	<!-- Displaying Instruction form -->

	<form action="getinstructions.htm" method="get">
		<br> <br> <br>
		<h1 class="ex1" style="color: #069">Instructions</h1>
		<table align="center" style="width: 950px;">

			<tr class="ex3">

				<td class="ex3" width="100%"><p1>Part 1</p1> <input
					type="hidden" name="techgeneralId" value="GE"> : General
					MCQ</td>
			</tr>

			<tr class="ex3">
				<td class="ex3"><p1>Part 2</p1> <input type="hidden"
					name="techaptiId" value="AP"> : Aptitude</td>
			</tr>

			<tr>
				<td class="ex3"><p1>Part 3</p1> : Choose your field of interest</td>
			<tr class="ex2">

				<td class="ex2"><input type="radio" name="techId" value="JA"
					required="required"> JAVA
				<td>
			</tr>

			<tr class="ex2">
				<td class="ex2"><input type="radio" name="techId" value="UI"
					required="required"> SAPUI5</td>
			</tr>

			<tr class="ex2">
				<td class="ex2"><input type="radio" name="techId" value="JS"
					required="required"> Javascript</td>
			</tr>

			<tr>
				<td class="ex3"><p1>Experience </p1>: <select name="levelId">
						<option value="L">0-2 years</option>
						<option value="M">3-5 years</option>
						<option value="H">5-10 years</option>
				</select></td>
			</tr>

			<tr>
				<td class="ex3"><p1>Number of Questions </p1>: 30 <span
					style="font-size: small;">(Part1 10 Questions + Part2 10
						Questions + Part3 10 Questions )</span></td>
			</tr>

			<tr>
				<td class="ex3"><p1>Time</p1> : 30 minutes
				<td>
			</tr>
			<tr align="right">
				<td align="right">
					<button class="btn btn-primary center-block">Start Quiz</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>