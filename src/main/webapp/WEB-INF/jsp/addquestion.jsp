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

<!-- Displaying the alert message for added question -->

<script type="text/javascript">
    function bodyLoad() {
       if (${m}) {
    	   alert('Question added Successfully.');
       } else {
           return false;
       }
    }
 </script>
</head>

<style type="text/css">
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
</head>

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

	<!--  Displaying save and save and another -->
	
	<form action="addquestion.htm" method="post">
		<table align="center" class="exaQues">
			<tr>
				<td><label for="">Session :</label></td>
				<td><label> <select name="techId">
							<option value="GE">General</option>
							<option value="AP">Aptitude</option>
							<option value="UI">SAPUI5</option>
							<option value="JS">Javascript</option>
							<option value="JA">Java</option>
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
						maxlength="250" required="required"></textarea></td>
			</tr>

			<tr>
				<td><label for=""> Option-A : </label></td>
				<td><textarea name="optionA" id="" value="" cols="50" rows="1"
						maxlength="250" required="required"></textarea></td>
			<tr>
				<td><label for=""> Option-B : </label></td>
				<td><textarea name="optionB" id="" value="" cols="50" rows="1"
						maxlength="250" required="required"></textarea></td>
			<tr>
				<td><label for=""> Option-C : </label></td>
				<td><textarea name="optionC" id="" value="" cols="50" rows="1"
						maxlength="250" required="required"></textarea></td>
			<tr>
				<td><label for=""> Option-D : </label></td>
				<td><textarea name="optionD" id="" value="" cols="50" rows="1"
						maxlength="250" required="required"></textarea></td>
			<tr>
				<td><label for=""> Key : </label></td>
				<td><label> <select name="qkey">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
					</select>
				</label></td>
			</tr>
		</table>
		<input type="hidden" name="c" id="" value="d">

		<!-- Displaying save and save and another -->
		<center style="margin-left: 184px;">
			<span>
				<button style="position: right; right: 30%; bottom: 0%;"
					class="btn btn-primary" name="s1" type="submit" value="v1">Save</button>
			</span>&nbsp;&nbsp;&nbsp;&nbsp; <span>
				<button style="position: right; right: 30%; bottom: 0%;"
					class="btn btn-primary" name="s1" type="submit" value="v2">Save
					and Another</button>
			</span>
		</center>
	</form>
</body>

</html>