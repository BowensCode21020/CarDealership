<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page import="src.com.back.Person"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Portal</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<style type="text/css">
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}

table {
	border-collapse: collapse;
	text-align: center;
}

td {
	border: 1px solid #000;
}

thead {
	background-color: #000;
	color: #fff;
	font-weight: bold;
}

thead td {
	padding: 0.5em;
}
</style>
</head>
</head>
<body>

	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
		<li class="nav-item"><a class="nav-link" href="search.jsp">Search</a></li>
		<li class="nav-item"><a class="nav-link" href="login.jsp">Log
				In</a></li>
		<li class="nav-item"><a class="nav-link" href="contact.jsp">Contact
				Us</a></li>
	</ul>

	<table class="table">
		<caption>Dealer Profile</caption>
		<thead>
			<tr>
				<th scope="col">Image</th>
				<th scope="col">User Information</th>
				<th scope="col">User ID</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><img src="C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\sleeze.jpg"
					height="100px" width="120px"></td>
				<td>User Name: <b><br> <c:out
							value="${myprofile.salesUserName}" /></b></td>
				<td>Employee ID: <b><br> <c:out
							value="${myprofile.salesID}" /></b></td>
			</tr>
		</tbody>
	</table>

	<h3>
		Welcome Back
		<c:out value="${myprofile.salesUserName}"></c:out>
	</h3>
	<p>Please choose from the options below</p>
	<br>
	<h4>Place Vehicle in Inventory</h4>
	<br>
	<p>
		<a href="addvehicle.jsp">Click here to add a vehicle</a> and please
		validate all information with at least two front-line managers before
		entering the information, including but not limited to:
	</p>
	<p>1). Make/Manufacturer</p>
	<p>2). Model</p>
	<p>3). Description, including but not limited to (color, body type,
		engine size, etc.)</p>
	<p>5). Vehicle Condition</p>
	<p>6). Mileage</p>
	<p>7) Vehicle Identification Number (VIN)</p>
	<br>
	<h4>Retrieve Reports</h4>
	<br>
	<p>Retrieve the current list of transactions and updates in
		inventory, including sale price, analytics, etc.</p>

		<form class="container" action="reporting.jsp" method="get">
			<input type="hidden" id="reports" name="reports" />
			<div class="btn-group">
				<button type="submit" class="bn">Click to Generate</button>
			</div>
		</form>

</body>
</html>