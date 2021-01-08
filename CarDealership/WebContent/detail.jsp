<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
   
<%@page import="src.com.back.Car"%>
<%@page import="src.com.back.Inventory"%>

<!DOCTYPE html>
<html>
<head>
<title>Vehicle Details</title>
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
	background-color: white;
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
.details {
	
	display: block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}
</style>
</head>
<body>

<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="search.jsp">Search</a></li>
			<li class="nav-item"><a class="nav-link" href="contact.jsp">Contact Us</a></li>
		</ul>
		<div class="detailpage">
			<h2 class="detailHeader">Vehicle Details</h2>
			<a href="vehicle.jsp"><button class="return"><h2>X</h2></button></a>
			<br>
			<img src="${detailvehicle.carImage}" height="300px" width="500px">
			<ul class="details">
				<li><b>Vehicle: </b><c:out value="${detailvehicle.carYear}" />
				<span></span><c:out value="${detailvehicle.carMan}" />
				<span>&nbsp;</span><c:out value="${detailvehicle.carModel}" />
				</li>
				
				<li><b>Color: </b><c:out value="${detailvehicle.carColor}" /></li>
				<li><b>Status: </b><c:out value="${detailvehicle.carCondition}" /></li>
				<c:if test="${detailvehicle.carCondition == 'USED'}">
					<li><b>Current Mileage: </b><c:out value="${detailvehicle.carMileage}" /></li>
				</c:if>
				<li>				<br>
				<c:out value="${detailvehicle.carDescription}" /></li>
				<li>				<br>
				<b>Price: $</b><c:out value="${detailvehicle.carPrice}" /></li>
			</ul>
			<c:if test="${!over120}">
			<li><a href="login.jsp"><button class="btn-buy">Buy Now!</button></a></li>
			</c:if>
			<c:if test="${over120}">
			<li>This vehicle is eligible for a discount!</li>
			<li><a href="login.jsp"><button class="btn-buy">Bid Now!</button></a></li>
			</c:if>
		</div>
		
</body>
</html>
