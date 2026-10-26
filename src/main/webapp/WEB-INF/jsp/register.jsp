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

<!-- Disabling browser back button -->
<script>
	history.pushState(null, null, document.URL);
	window.addEventListener('popstate', function() {
		history.pushState(null, null, document.URL);
	});
</script>

<!--Validation for Email and mobile  -->
<script>
	function validateForm() {
		var email = $('#email').val();
		var mobile = $('#mobile').val();
		var mobileRegEx = /^\d{10}$/;
		var EmailRegEx = /^(?:[\w\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]+\.)*[\w\!\#\$\%\&\'\*\+\-\/\=\?\^\`\{\|\}\~]+@(?:(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9\-](?!\.)){0,61}[a-zA-Z0-9]?\.)+[a-zA-Z0-9](?:[a-zA-Z0-9\-](?!$)){0,61}[a-zA-Z0-9]?)|(?:\[(?:(?:[01]?\d{1,2}|2[0-4]\d|25[0-5])\.){3}(?:[01]?\d{1,2}|2[0-4]\d|25[0-5])\]))$/;
		if (email.match(EmailRegEx) && mobileRegEx.test(mobile)) {
			return true;

		} else if (!email.match(EmailRegEx)) {
			alert("Not a valid e-mail address");
			return false;
		} else if (!mobileRegEx.test(mobile)) {
			alert("Please enter 10 digit mobile number");
			return false;
		}

	}
</script>
<style>
.ex3 {
	padding: 0.1cm 18.5cm;
}
</style>

<body style="background-color: #FDF5E6">

	<!--  Displaying header part -->
	<center>
		<div class="mydiv">
			<img src="appLogo.png" class="quizLogo">
			<h2 align="left" class="quizText">Quiz Time</h2>
		</div>
	</center>

	<!--Displaying user login form  -->

	<form:form commandName="userForm" action="register.htm"
		onsubmit="return validateForm();">
		<table align="center" style="width: 550px;">
			<tr>
				<td><form:label path="name">Full Name<span
							style="color: red"> *</span>
					</form:label></td>
				<td><form:input path="name" placeholder="Enter your name" /></td>
				<br>
			</tr>
			<tr>
				<td></td>
				<td><FONT color="red"><form:errors path="name"></form:errors></FONT><br>
				</td>
			</tr>
			<tr>
				<td><form:label path="email">Email<span
							style="color: red"> *</span>
					</form:label></td>
				<td><form:input path="email" placeholder="abc@exa-ag.com" /></td>
				<br>
			</tr>
			<tr>
				<td></td>
				<td><FONT color="red"><form:errors path="email"></form:errors></FONT><br>
				</td>
			</tr>
			<tr>
				<td><form:label path="mobile">Mobile Number<span
							style="color: red"> *</span>
					</form:label></td>
				<td><form:input path="mobile" placeholder="9900990099"
						maxlength="10" /></td>
			</tr>
			<tr>
				<td></td>
				<td><FONT color="red"><form:errors path="mobile"></form:errors></FONT>
				</td>
			</tr>
		</table>

		<!--Displaying Submit button -->
		<h3 class="ex3">
			<button class="btn btn-primary">Submit</button>
		</h3>

	</form:form>
</body>
</html>