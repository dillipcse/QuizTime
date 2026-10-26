<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Example of Bootstrap 3 Tabs</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style type="text/css">
.ex {
	padding: 0.01cm 1.2cm;
}

.bs-example {
	margin: 20px;
}

.mydiv {
	margin: left;
	overflow: hidden;
	background-color: #87CEFA;
}

.button {
	position: absolute;
	bottom: 30;
	right: 20;
}

.divLast {
	position: relative;
	left: 20px;
	bottom: 100px;
}

.divLast1 {
	position: fixed;
	bottom: 10;
	right: 0;
}

.divLast2 {
	position: fixed;
	bottom: 20;
	right: 1;
}

.mydiv {
	overflow: hidden;
	background-color: #87CEFA; html { height : 100%;
	display: table;
	margin: auto;
}

body {
	height: 100%;
	display: table-cell;
	vertical-align: middle;
}

p {
	overflow: hidden;
	background-color: #87CEFA;
}
</style>

<body style="background-color: #FDF5E6">

	!-- Displaying editandsave form -->
	
	<form action="editandsave.htm" method="post">
		<table>
			<tr>
				<td><label for=""> option-A : </label></td>
				<td><input type="hidden" name="id" id="" value="id" /></td>
			</tr>
			<tr>
				<td><label for="">Session :</label></td>
				<td><label> <select name="techId">
							<option value="GE">General</option>
							<option value="AP">apti</option>
							<option value="UI">SapUI5</option>
							<option value="JS">Javascript</option>
							<option value="JA">Java</option>
					</select>
				</label></td>
			</tr>

			<tr>
				<td><label for="">ComplexType:</label></td>
				<td><label> <select name="compId">
							<option value="L">low</option>
							<option value="M">medium</option>
							<option value="H">High</option>
					</select>
				</label></td>
			</tr>

			<tr>
				<td><label for="comments">Question:</label></td>
				<td><textarea name="question" id="" cols="25" rows="3"></textarea></td>
			</tr>

			<tr>
				<td><label for=""> option-A : </label></td>
				<td><input type="text" name="optionA" id="" value="" /></td>
			</tr>


			<tr>
				<td><label for=""> option-B : </label></td>
				<td><input type="text" name="optionB" id="" value="" /></td>
			</tr>

			<tr>
				<td><label for=""> option-C : </label></td>
				<td><input type="text" name="optionC" id="" value="" /></td>
			</tr>

			<tr>
				<td><label for=""> option-D : </label></td>
				<td><input type="text" name="optionD" id="" value="" /></td>
			</tr>

			<tr>
				<td><label for=""> Key : </label></td>
				<td><input type="text" name="qkey" id="" value="" /></td>
			</tr>
		</table>
		
		<!--Displaying save button  -->
		
		<button style="position: absolute; right: 47%; bottom: 10%;"
			class="btn btn-primary">Save</button>
	</form>
</body>
</html>