<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page import="src.com.back.Person"%>
<%@page import="src.com.back.Inventory"%>
<%@page import="src.com.back.Car"%>

<!DOCTYPE html>
<html>
<head>
<title>Purchase Vehicle</title>
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
	padding: 4px 6px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}

.details {
	display: block;
	color: white;
	text-align: center;
	padding: 4px 6px;
	text-decoration: none;
}

.user {
	display: block;
	color: white;
	text-align: center;
	padding: 4px 6px;
	text-decoration: none;
}
</style>
</head>
<body>

	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
		<li class="nav-item"><a class="nav-link" href="contact.jsp">Contact
				Us</a></li>
	</ul>
	<div class="detailpage">
		<h3 class="detailHeader">Vehicle Details</h3>
		<a href="detail.jsp"><button class="return">
				<h2>Return to Detail Page</h2>
			</button></a> <br> <img src="${detailvehicle.carImage}" height="300px"
			width="500px">
		<ul class="details">
			<li><b>Vehicle: </b> <c:out value="${detailvehicle.carYear}" />
				<span>&nbsp;</span> <c:out value="${detailvehicle.carMan}" /> <span>&nbsp;</span>
				<c:out value="${detailvehicle.carModel}" /></li>
			<li><b>VIN: </b> <c:out value="${detailvehicle.carVIN}" /></li>
			<li><b>Color: </b> <c:out value="${detailvehicle.carColor}" /></li>
			<li><b>Status: </b> <c:out value="${detailvehicle.carCondition}" /></li>
			<c:if test="${detailvehicle.carCondition == 'USED'}">
				<li><b>Current Mileage: </b> <c:out
						value="${detailvehicle.carMileage}" /></li>
			</c:if>
			<li><br> <c:out value="${detailvehicle.carDescription}" /></li>

			<li><br> <b>Price: $</b> <c:out
					value="${detailvehicle.carPrice}" /></li>
		</ul>
	</div>
	<div class="userpage">
		<h3 class="userHeader">User Information</h3>
		<ul class="user">
			<c:if test="${personlist != null}">
				<c:forEach var="myperson" items="${personlist}">
					<td><b>First Name: </b>
					<c:out value="${myperson.firstName}" /><br></td>
					<td><b>Last Name: </b>
					<c:out value="${myperson.lastName}" /><br></td>
					<td><b>Street: </b>
					<c:out value="${myperson.street}" /><br></td>
					<td><b>City: </b>
					<c:out value="${myperson.city}" /><br></td>
					<td><b>State: </b>
					<c:out value="${myperson.state}" /><br></td>
					<td><b>Zip: </b>
					<c:out value="${myperson.zip}" /><br></td>
					<td><b>Phone Number: </b>
					<c:out value="${myperson.phoneNumber}" /><br></td>
				</c:forEach>
			</c:if>
		</ul>
		<form class="container" action="BuyVehicleServlet" method="post">
			<h3 class="paymentHeader">Enter Account Information (Debit or
				Credit Card)</h3>
			<p>Enter your debit or credit card information down below</p>
			<img
				src="C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\carddiagram.jpg"
				style="width: 300px; height: 160px;"> <br>
			<table style="width: 50%">
				<tr>
					<td><br>
					<b>Card Number: </b><input type="text" size="16" maxlength="16"
						name="cardnumber" value="${cardlist.cardnumber}" /></td>
				</tr>
				<tr>
					<td><br>
					<b>Expiration Date Month/Year (MM)/(YY): </b><input type="text"
						size="1" maxlength="2" name="expirationmonth"
						value="${cardlist.expirationmonth}"
						<c:if test="${montherror}">style="border-bottom: 2.5px solid red; "</c:if>>
						/ <input type="text" size="1" maxlength="2" name="expirationyear"
						value="${cardlist.expirationyear}" /></td>
				</tr>
				<tr>
					<td><br>
					<b>CVC Number on Back of Card (see above image): </b><input
						type="text" size="1" maxlength="3" name="cvv"
						value="${cardlist.cvv}" /></td>
				</tr>
			</table>
			<c:if test="${!over120}">
				<br>
				<h3>Submit Payment</h3>
				<br>
				<p>
					The total amount of <b>$<c:out
							value="${detailvehicle.carPrice}" /></b> will be charged to your
					account, please click "submit" to complete the transaction.
				</p>
				<td></td>
				<li><input type="hidden" id="carVIN" name="carVIN"
					value="${detailvehicle.carVIN}">
					<div class="btn-group">
						<button type="submit" class="bn">
							<b>Proceed to Checkout</b>
						</button>
					</div></li>
			</c:if>
			<c:if test="${over120}">
				<p>
					Due to the cause of extended inventory, this car originally priced
					at <b>$<c:out value="${detailvehicle.carPrice}" /></b> is now
					available for $<b><c:out value="${detailvehicle.bidPrice}" /></b>
					Please enter your bid below:
				</p>
				<td><br>
				<b>Current Bid: </b><input type="text" size="16" maxlength="16"
					name="bid" value="${detailvehicle.bidPrice}" /></td>
				<li><input type="hidden" id="carVIN" name="carVIN"
					value="${detailvehicle.carVIN}">
					<div class="btn-group">
						<button type="submit" class="bn">Proceed to Checkout</button>
					</div></li>
				<td></td>
			</c:if>
		</form>
	</div>
</body>
</html>