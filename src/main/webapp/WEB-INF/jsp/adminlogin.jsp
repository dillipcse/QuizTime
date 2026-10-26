<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
			<img src="appLogo.png" class="quizLogo">
			<h2 align="left" class="quizText">Quiz Time</h2>
		</div>
	</center>

	<h1 align="center">Admin Portal</h1>

	<!-- Displaying admin login form -->

	<form:form commandName="admin" action="adminlogin.htm">
		<table align="center">
			<tr>
				<td>UserName<span style="color: red">*</span></td>
				<td><form:input path="adminEmail" placeholder="Enter Email"
						required="required" /></td>
				<br>
			</tr>

			<tr>
				<td></td>
				<td><FONT color="red"><form:errors path="adminEmail"></form:errors></FONT>
					<br></td>
			</tr>
			<tr>
				<td>Password<span style="color: red">*</span></td>
				<td><form:password path="password" placeholder="Enter Password"
						required="required" /></td>
				<br>
			</tr>
			<tr>
				<td></td>
				<td><FONT color="red"><form:errors path="password"></form:errors></FONT>
					<br></td>
			</tr>
			<tr>
				<td colspan="2" class="ex3">
					<button class="btn btn-primary ">Login</button>
			</tr>
		</table>
	</form:form>
</body>
</html>