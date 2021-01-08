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
<title>Search Our Vehicle Inventory</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<style>
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

.odd {
	background-color: #E6E6E6;
}

.even {
	background-color: #fff;
}
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
		<li class="nav-item"><a class="nav-link active"
			href="reporting.jsp">Reports</a></li>
		<li class="nav-item"><a class="nav-link" href="dealerprofile.jsp">Back
				to Profile</a></li>
	</ul>
	<form class="container" action="ReportVehicles" method="get">
		<h2>Inventory List</h2>
		<br>
		<h3>List of Current Vehicles</h3>
		<div class="container">
			<div class="row">
				<table class="table-responsive">
					<thead>
						<tr>
							<th scope="col">Inventory No.</th>
							<th scope="col">Date of Inventory</th>
							<th scope="col">Model</th>
							<th scope="col">Manufacturer</th>
							<th scope="col">Color</th>
							<th scope="col">Description</th>
							<th scope="col">Status</th>
							<th scope="col">Mileage</th>
							<th scope="col">Year</th>
							<th scope="col">Price</th>
							<th scope="col">VIN#</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="vehiclenotsold" items="${vehicleunsold}"
							varStatus="i">
							<c:choose>
								<c:when test="${(i.count) % 2 == 0}">
									<tr class="even">
								</c:when>
								<c:otherwise>
									<tr class="odd">
								</c:otherwise>
							</c:choose>
							<td>${i.count}</td>
							<td><c:out value="${vehiclenotsold.inventoryDate}" /></td>
							<td><c:out value="${vehiclenotsold.carModel}" /></td>
							<td><c:out value="${vehiclenotsold.carMan}" /></td>
							<td><c:out value="${vehiclenotsold.carColor}" /></td>
							<td><c:out value="${vehiclenotsold.carDescription}" /></td>
							<td><c:out value="${vehiclenotsold.carCondition}" /></td>
							<td><c:out value="${vehiclenotsold.carMileage}" /></td>
							<td><c:out value="${vehiclenotsold.carYear}" /></td>
							<td><c:out value="${vehiclenotsold.carPrice}" /></td>
							<td><c:out value="${vehiclenotsold.carVIN}" /></td>
						</c:forEach>

					</tbody>
				</table>

			</div>
		</div>
		<br> <br>
		<h3>List of Sold Inventory</h3>
		<div class="container">
			<div class="row">
				<table class="table-responsive">
					<thead>
						<tr>
							<th scope="col">Inventory No.</th>
							<th scope="col">Date of Purchase</th>
							<th scope="col">Model</th>
							<th scope="col">Manufacturer</th>
							<th scope="col">Color</th>
							<th scope="col">Description</th>
							<th scope="col">Status</th>
							<th scope="col">Mileage</th>
							<th scope="col">Year</th>
							<th scope="col">Price Sold At</th>
							<th scope="col">VIN#</th>
							<th scope="col">Buyer Information</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="vehiclesold" items="${vehiclesold}"
							varStatus="i">
							<c:choose>
								<c:when test="${(i.count) % 2 == 0}">
									<tr class="even">
								</c:when>
								<c:otherwise>
									<tr class="odd">
								</c:otherwise>
							</c:choose>
							<td>${i.count}</td>
							<td><c:out value="${vehiclesold.dateOfPurchase}" /></td>
							<td><c:out value="${vehiclesold.carModel}" /></td>
							<td><c:out value="${vehiclesold.carMan}" /></td>
							<td><c:out value="${vehiclesold.carColor}" /></td>
							<td><c:out value="${vehiclesold.carDescription}" /></td>
							<td><c:out value="${vehiclesold.carCondition}" /></td>
							<td><c:out value="${vehiclesold.carMileage}" /></td>
							<td><c:out value="${vehiclesold.carYear}" /></td>
							<td><c:out value="${vehiclesold.carPrice}" /></td>
							<td><c:out value="${vehiclesold.carVIN}" /></td>
							<td><c:forEach var="person" items="${person}">
							<i><c:out value="${person.firstName}" /><c:out value="${person.lastName}" /></i>
							</c:forEach></td>
						</c:forEach>

					</tbody>
				</table>

			</div>
		</div>



	</form>
</body>
</html>