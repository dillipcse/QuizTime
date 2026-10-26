<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Quiz Time</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="style.css" />
<script id="sap-ui-bootstrap"
	src="https://sapui5.hana.ondemand.com/resources/sap-ui-core.js"
	data-sap-ui-libs="sap.m">	
	</script>

<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

<!-- Displaying the alert message for added question -->

<script type="text/javascript">
    function bodyLoad() {
    	if(${s}){	
    	alert('PDF Downloaded Successfully');
       } else {
       return false;
      }
    }
 </script>
</head>

<style type="text/css">
.exaCandidRes {
	margin: 20px;
}

table, td, th {
	border: 2px solid #ddd;
	text-align: left;
}

th, td {
	color: #0c5034;
	padding: 10px;
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

	<!--Participants result table  -->
	<table id="idTable" class="exaCandidRes" align="center" border="2">
		<caption>
			<h2 style="color: indianred; font-size: x-large;">Candidate
				Results</h2>
		</caption>
		<tr>
			<th align="center">Name</th>
			<th align="center">Email</th>
			<th align="center">Mobile</th>
			<th align="center">Date</th>
			<th align="center">Total number of question</th>
			<th align="center">Correct Answers</th>
			<th align="center">Marks Obtained</th>
			<th align="center">Quiz percentage</th>
			<th align="left">Result
				<div class="quizResultLegend">
					<h6 class="quizError">
						<span style="margin: 16px;">Fail</span>
					</h6>
					<h6 class="quizWarning">
						<span style="margin: 16px;">Average</span>
					</h6>
					<h6 class="quizSuccess">
						<span style="margin: 16px;">Outstanding</span>
					</h6>
				</div>
			</th>
			<th align="center">Result PDF</th>
		</tr>
	</table>
	
	<script>
	
	//Pdf Downloading function  
		function imgPdfClick(){
			window.location = "pdf.htm?sessionId="+this.getAttribute("pdf_data");
		}
	//  Displaying participant status 
		function resultStatus(val){
			//return val >= 50 ? "Success": "Error";
			var res = "Error";
			if(val >= 50)
				res = "Success";
			else if(val >= 20)
				res = "Warning";
			else 
				res = "Error";
			return res;
		}
	
		// script for displaying participants result -->
		var i = 0;
		var table = document.getElementById("idTable");
		<c:forEach items="${result}" var="result">
			var row = document.createElement('tr');
			var name 	= "{${result.name}}";
			var email 	= "{${result.sessionId}}";
			var date 	= "{${result.date}}";
			var cell = document.createElement("td");
			cell.innerHTML = name.substring(1,name.length-1);
			cell.setAttribute("align", "center");
			row.appendChild(cell);
			cell = document.createElement("td");
			cell.innerHTML = email.substring(1,email.length-1);
			cell.setAttribute("align", "center");
			row.appendChild(cell);
			cell = document.createElement("td");
			cell.innerHTML = ${result.mobile};
			cell.setAttribute("align", "center");
			row.appendChild(cell);
			cell = document.createElement("td");
			cell.innerHTML = date.substring(1,date.length-1);
			cell.setAttribute("align", "center");
			cell.setAttribute("width", "135px");
			row.appendChild(cell);
			cell = document.createElement("td");
			cell.innerHTML = "30";
			cell.setAttribute("align", "center");
			row.appendChild(cell);
			cell = document.createElement("td");
			cell.innerHTML = ${result.correctAns};
			row.appendChild(cell);
			cell = document.createElement("td");
			cell.innerHTML = ${result.marks};
			cell.setAttribute("align", "center");
			row.appendChild(cell);
			cell = document.createElement("td");
			cell.innerHTML = ${result.percentage};
			cell.setAttribute("align", "center");
			row.appendChild(cell);
			var oProgressIndicator1 = new sap.m.ProgressIndicator({
				width : "300px",
				percentValue : parseInt(${result.percentage}),
				displayValue : ${result.percentage}+ "%",
				state : resultStatus(parseInt(${result.percentage}))
			});
			oProgressIndicator1.placeAt("content" + i);

			var chart = document.createElement('td');
			chart.setAttribute("id", "content" + i);
			cell.setAttribute("align", "center");
			row.appendChild(chart);
			//var link="pdf.htm?sessionId=sashi@gmail.com";
			var img1 = document.createElement("Img");
			img1.onclick = imgPdfClick;
			img1.setAttribute("pdf_data","${result.sessionId}")
			img1.src = "pdf.jpg";
			var cell = document.createElement("td");
			img1.setAttribute("width", "50");
			img1.setAttribute("align", "center");
			img1.style.cursor = "pointer";
			cell.appendChild(img1);
			cell.setAttribute("align", "center");
			row.appendChild(cell);
			i++;
			table.appendChild(row);
		</c:forEach>
	</script>
</body>
</html>
