<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<!-- search filter for email -->
<script>
function myFunction() {
  var input, filter, table, tr, td, i;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("idTable");
  tr = document.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>

</head>

<style type="text/css">
.exa {
	margin-left: 700px;
	padding: 0.0cm 3.3cm;
	margin-top: -35px
}

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

<!--script for displaying ascending and descending order -->

<script>
function sortTable(n) {
  var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
  table = document.getElementById("idTable");
  switching = true;
  
  dir = "asc"; 
  
  while (switching) {
    
    switching = false;
    rows = table.getElementsByTagName("TR");
   
    for (i = 1; i < (rows.length - 1); i++) {
      
      shouldSwitch = false;
     
      x = rows[i].getElementsByTagName("TD")[n];
      y = rows[i + 1].getElementsByTagName("TD")[n];
      
      if (dir == "asc") {
        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
          
          shouldSwitch= true;
          break;
        }
      } else if (dir == "desc") {
        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
         
          shouldSwitch= true;
          break;
        }
      }
    }
    if (shouldSwitch) {
     
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
      
      switchcount ++;      
    } else {
      
      if (switchcount == 0 && dir == "asc") {
        dir = "desc";
        switching = true;
      }
    }
  }
}
</script>

<body style="background-color: #FDF5E6">

<!--  Displaying the header part, logo and logout button -->

	<center>
		<div class="mydiv">
			<a href="participantHistory2.htm"><span
				class="fa fa-arrow-left w3-xlarge quizNavBack"></span></a> <img
				src="appLogo.png" class="quizLogo">
			<h2 align="left" class="quizText">Quiz Time</h2>
			<h5 align="right" class="quizUser">Welcome, ${adminName}</h5>
			<a href="adminlogout.htm"> <img src="logout.png"
				class="exaLogBtn">

			</a>
		</div>
	</center>

	<!--table containing participant details -->

	<table id="idTable" class="exaCandidRes" align="center" border="2">
		<caption>
			<h2 style="color: indianred; font-size: x-large;">Candidate
				Results</h2>
			<input type="text" class="exa" id="myInput" onkeyup="myFunction()"
				placeholder="Search for email.." title="Type in a name">
		</caption>
		<tr>

			<th align="center">Name &nbsp;&nbsp;<span
				class="glyphicon glyphicon-sort" onclick="sortTable(0)"></span>
			</th>

			<th align="center">Email &nbsp;&nbsp;<span
				class="glyphicon glyphicon-sort" onclick="sortTable(1)"></span>
			</th>
			<th align="center">Mobile &nbsp;&nbsp;<span
				class="glyphicon glyphicon-sort" onclick="sortTable(2)"></span></th>

			<th align="center">Date &nbsp;&nbsp;&nbsp;&nbsp;<span
				class="glyphicon glyphicon-sort" onclick="sortTable(3)"></span></th>

			<th align="center">Quiz percentage &nbsp;&nbsp;<span
				class="glyphicon glyphicon-sort" onclick="sortTable(4)"></span></th>
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
		</tr>
	</table>

	<!-- script for displaying participants information -->
	
	<script>
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
		var i = 0;
		var table = document.getElementById("idTable");
		<c:forEach items="${resultList}" var="resultList">
			var row = document.createElement('tr');
			
			var name 	= "{${resultList.name}}";
			var email 	= "{${resultList.sessionId}}";
			var date 	= "{${resultList.date}}";
				
			var cell = document.createElement("td");
			cell.innerHTML = name.substring(1,name.length-1);
			cell.setAttribute("align", "center");
			row.appendChild(cell);
			cell = document.createElement("td");
			cell.innerHTML = email.substring(1,email.length-1);
			cell.setAttribute("align", "center");
			row.appendChild(cell);
			cell = document.createElement("td");
			cell.innerHTML = ${resultList.mobile};
			cell.setAttribute("align", "center");
			row.appendChild(cell);
			cell = document.createElement("td");
			cell.innerHTML = date.substring(1,date.length-1);
			cell.setAttribute("align", "center");
			cell.setAttribute("width", "135px");
			row.appendChild(cell);
			cell = document.createElement("td");
			cell.innerHTML = ${resultList.percentage};
			cell.setAttribute("align", "center");
			row.appendChild(cell);
			var oProgressIndicator1 = new sap.m.ProgressIndicator({
				width : "300px",
				percentValue : parseInt(${resultList.percentage}),
				displayValue : ${resultList.percentage}+ "%",
				state : resultStatus(parseInt(${resultList.percentage}))
			});
			oProgressIndicator1.placeAt("content" + i);

			var chart = document.createElement('td');
			chart.setAttribute("id", "content" + i);
			cell.setAttribute("align", "center");
			row.appendChild(chart);
			i++;
			
			table.appendChild(row);
		</c:forEach>
	</script>
</body>
</html>