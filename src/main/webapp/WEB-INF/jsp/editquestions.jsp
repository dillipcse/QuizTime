<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Quiz Time</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="style.css" />

<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

<style>
td {
	margin: 150px;
	padding: 10px;
}

.ex1 {
	padding: 0.01cm 20.2cm;
}

label {
	font-weight: 100;
}
</style>
<body style="background-color: #FDF5E6">

	<!--   Displaying the header part, logo and logout button -->

	<center>
		<div class="mydiv">
			<a href="generalmcq.htm"><span
				class="fa fa-arrow-left w3-xlarge quizNavBack"></span></a> <img
				src="appLogo.png" class="quizLogo">
			<h2 align="left" class="quizText">Quiz Time</h2>
			<h5 align="right" class="quizUser">Welcome, ${adminName}</h5>
			<a href="adminlogout.htm"> <img src="logout.png"
				class="exaLogBtn">
			</a>
		</div>
	</center>

	<!-- Displaying addquestion form for editing -->
	
	<form action="editque.htm" method="post">
		<table align="center">
			<tr>
				<td><label for="">Session :</label></td>
				<td><label> <select name="techId">
							<option value="${bank.techId}">${bank.techId}</option>
					</select>
				</label></td>
			</tr>

			<tr>
				<td><label for="">Complexity Type :</label></td>
				<td><label> <select name="compId">
							<option value="L">Low</option>
							<option value="M">Medium</option>
							<option value="H">High</option>
					</select>
				</label></td>
			<tr>
				<td><label for="comments">Question :</label></td>
				<td><textarea name="question" id="" cols="50" rows="3"
						maxlength="250" required="required">${bank.question}</textarea></td>
			</tr>

			<tr>
				<td><label for=""> Option-A : </label></td>
				<td><textarea name="optionA" id="" value="" cols="50" rows="1"
						maxlength="250" required="required">${bank.optionA}</textarea></td>
			<tr>
				<td><label for=""> Option-B : </label></td>
				<td><textarea name="optionB" id="" value="" cols="50" rows="1"
						maxlength="250" required="required">${bank.optionB}</textarea></td>
			<tr>
				<td><label for=""> Option-C : </label></td>
				<td><textarea name="optionC" id="" value="" cols="50" rows="1"
						maxlength="250" required="required">${bank.optionC}</textarea></td>
			<tr>
				<td><label for=""> Option-D : </label></td>
				<td><textarea name="optionD" id="" value="" cols="50" rows="1"
						maxlength="250" required="required">${bank.optionD}</textarea></td>
			<tr>
				<td><label for=""> Key : </label></td>
				<td><label> <input type="text" name="qkey" id=""
						value="${bank.qkey}"></input>

				</label></td>
			</tr>
		</table>

		<!-- Displaying save button -->
		
		<button style="position: absolute; right: 47%; bottom: 10%;"
			class="btn btn-primary">Save</button>
	</form>
</body>

</html>