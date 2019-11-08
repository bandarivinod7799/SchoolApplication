<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

h2 {
	color: #FF66CC;
}

table {
	border-color: fuchsia;
	margin-left: 600px;
}

table h2 {
	color: blue;
}

a {
	color: green;
	margin-left: 650px;
	border: 1px;
	bottom: 2000px;
}
</style>

<body>

	<%
		if (session.getAttribute("jsprollnum") == null) {
			response.sendRedirect("student_login_Access.html");
		}
	%>

	<h2 align="center">RollNumber: ${jsprollnum}</h2>
	<table border="1px">
		<tr>
			<td>
				<h3>TELUGU</h3>
			</td>

			<td>
				<h3>${jsptelugu}</h3>
			</td>
		</tr>

		<tr>
			<td>
				<h3>ENGLISH</h3>
			</td>
			<td>
				<h3>${ jspenglish}</h3>
			</td>
		</tr>

		<tr>
			<td>
				<h3>MATHS</h3>
			</td>
			<td>
				<h3>${jspmaths }</h3>
			</td>
		</tr>

		<tr>
			<td>
				<h3>SCIENCE</h3>
			</td>

			<td>
				<h3>${jspscience}</h3>
			</td>
		</tr>

		<tr>
			<td>
				<h3>SOCIAL</h3>
			</td>

			<td>
				<h3>${jspsocial}</h3>
			</td>
		</tr>

		<tr>
			<td>
				<h2>TOTAL</h2>
			</td>

			<td>
				<h2>${jsptotal}</h2>
			</td>
		</tr>
	</table>
	<a href="home.html">HOME</a>


</body>
</html>
<%-- <jsp:forward page="login.jsp" /> --%>