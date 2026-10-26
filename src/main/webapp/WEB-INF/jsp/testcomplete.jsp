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

<!-- Disabling browser back button -->

<script>
history.pushState(null, null, document.URL);
window.addEventListener('popstate', function () {
    history.pushState(null, null, document.URL);
});
</script>

<style type="text/css">
.ex {
	padding: 0.21cm 1.2cm;
}

.mydiv {
	overflow: hidden;
	background-color: #87CEFA; html { height : 100%;
	display: table;
	margin: auto;
}

}
.exaMsg {
	margin: 100px 390px;
}

.cartoon {
	width: 250px;
	height: 400px;
	float: left;
}

.thanks {
	font-size: 50px;
	font-family: cursive;
	padding-top: 110px;
}
</style>

<body>
	<center>
		<div>
			<a href="index.jsp"><span class="fa fa-arrow-left w3-xlarge"
				style="margin-right: 1250px; margin-top: 20px;"></span></a>
		</div>
	</center>

	<!--  Displaying the cartoon image-->
	<div class="exaMsg">
		<img src="Cartoon.PNG" class="cartoon" />
		<div>
			<h4 class="thanks">Thank you!</h4>
		</div>
	</div>

</body>

</html>