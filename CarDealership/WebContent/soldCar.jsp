<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page import="src.com.back.Car"%>
<%@page import="src.com.back.Inventory"%>
<%@page import="src.com.back.Person"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checkout</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<style>
/* ul {
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
} */
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
		<li class="nav-item"><a class="nav-link" href="contact.jsp">Contact
				Us</a></li>
	</ul>
	<div class="checkoutpage">
		<h2 class="checkoutHeader">Thank You For Your Purchase!</h2>
		<h1 class="checkoutInfo">Invoice:</h1>
		<br>
		<ul class="details">
			<li>Vehicle: <c:out value="${detailvehicle.carYear}" /> <span></span>
			<c:out value="${detailvehicle.carMan}" /> <span>&nbsp;</span>
			<c:out value="${detailvehicle.carModel}" />
			</li>

			<li>Color: <c:out value="${detailvehicle.carColor}" /></li>
			<li>Status: <c:out value="${detailvehicle.carCondition}" /></li>
			<c:if test="${detailvehicle.carCondition == 'USED'}">
				<li>Mileage: <c:out value="${detailvehicle.carMileage}" /></li>
			</c:if>
			<li><br> <c:out value="${detailvehicle.carDescription}" /></li>
			<c:if test="${!over120}">
				<li><br> Price: $<c:out value="${detailvehicle.carPrice}" /></li>
			</c:if>
			<c:if test="${over120}">
				<li><br> Price: $<c:out value="${detailvehicle.bidPrice}" /></li>
			</c:if>
		</ul>
		<ul class="user">
			<c:if test="${personlist != null}">
				<c:forEach var="myperson" items="${personlist}">
					<td>Owner: <c:out value="${myperson.firstName}" /><span>&nbsp;</span>
					<c:out value="${myperson.lastName}" /><br></td>
					<td>Address: <c:out value="${myperson.street}" /><c:out value="${myperson.city}" /><c:out value="${myperson.state}" /><c:out value="${myperson.zip}" /><br></td>
					<td>Phone Number: <c:out value="${myperson.phoneNumber}" /><br></td>
				</c:forEach>
			</c:if>
		</ul>
		<c:if test="${cardlist != null}">
			<c:forEach var="mymoney" items="${cardlist}">
				<td>Card Number (Last 4 digits): <c:out
						value="${mymoney.cardnumber}" /><br></td>

			</c:forEach>
		</c:if>

		<a href="index.jsp"><button class="return">
				<h2>Return to Home Page</h2>
			</button></a>
	</div>
</body>
</html>