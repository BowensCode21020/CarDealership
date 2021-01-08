<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page import="src.com.back.Car"%>
<%@page import="src.com.back.Inventory"%>

<!DOCTYPE html>
<html>
<head>
<title>Search Our Vehicle Inventory</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<style>
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
</style>
</head>

<body>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
		<li class="nav-item"><a class="nav-link" href="login.jsp">Log
				In</a></li>
		<li class="nav-item"><a class="nav-link" href="contact.jsp">Contact
				Us</a></li>
	</ul>

	<form class="form-inline" method="get" action="SearchServlet">
		<input class="form-control mr-sm-2" name="searchbutton" type="search"
			placeholder="Search model" aria-label="Search">
		<button class="btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	</form>

	<c:forEach var="cars" items="${search}">
		<div class="col-md-4">
			<div class="card mb-4 shadow-sm">
				<img src="${cars.carImage}" height="225" width="100%">
				<div class="card-body">
					<div class="d-flex justify-content-between align-items-center">
						<form class="container" action="SearchServlet" method="get">
							<input type="hidden" id="carVIN" name="carVIN"
								value="${cars.carVIN}">
							<div class="btn-group">
								<button type="submit" class="bn">
									<b><c:out value="${cars.carYear}" /> <span>&nbsp;</span> <c:out
											value="${cars.carMan}" /></b><span>&nbsp;</span>
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>


</body>
</html>