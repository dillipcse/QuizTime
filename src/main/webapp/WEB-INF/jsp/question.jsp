<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- script for timeout  -->

<script type="text/javascript">
this.oQuizInterval = setInterval(this.displayTime,1000);
displayTime: function() {
    var time = document.getElementById("time").value;
    var val = parseInt(time);
    if (val == 0) {
          clearInterval(this.oQuizInterval);
          this.myTimeoutFunction();
    } else
          time.setText(" " + val - 1 + " Min");
},
</script>

</head>

<body>

	<!-- displaying time -->
	
	<div>
		<p id="time">30:00</p>
	</div>

</body>
</html>