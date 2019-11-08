<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	background-color: lightblue;
}

table {
	margin-left: 600px;
	margin-bottom: 200px;
}

h1 {
	color: #FF66CC;
}

.getmarks input[type="submit"] {
	background-color: green;
	border-radius: 5px;
	margin-left: 700px;
	margin-bottom:
}

.getattendence input[type="submit"] {
	background-color: green;
	border-radius: 7px;
	padding-right: -400px;
}
</style>
<body>

	<h1 align="center">WELCOME TO M.P.H.S THIPPANNAPET.....!!!
		${jspname }</h1>
	<table>
		<tr>
			<td>
				<h3>Class</h3>
			</td>
			<td><h3>:</h3></td>
			<td><h3>${jspurclass }</h3></td>
		</tr>

		<tr>
			<td>
				<h3>Phone Number</h3>
			</td>
			<td>
				<h3>:</h3>
			</td>
			<td>
				<h3>${ jspphnumber}</h3>
			</td>
		</tr>

		<tr>
			<td>
				<h3>Mail ID</h3>
			</td>
			<td>
				<h3>:</h3>
			</td>
			<td>
				<h3>${jspmailID }</h3>
			</td>
		</tr>

		<tr>
			<td>
				<h3>RollNumber</h3>
			</td>
			<td>
				<h3>:</h3>
			</td>
			<td>
				<h3>${ jsprollnumber1}</h3>
			</td>
		</tr>


	</table>
	<%
		String rollnumber3 = request.getParameter("jsprollnumber1");
	%>

	<div class="getmarks">
		<form action="Get_Marks" method="post">
			<input type="hidden" name="rollnumber3" value="<%=rollnumber3%>">
			<h2>
				<input type="submit" value="GetMarks">
			</h2>
		</form>
	</div>
	<%-- <div class="getattendence">
		<form action="" method="post">
			<input type="hidden" name="" value="<%=%>">
			<h2>
				<input type="submit" value="GetAttendence">
			</h2>
		</form>
	</div>
 --%>

</body>
</html>