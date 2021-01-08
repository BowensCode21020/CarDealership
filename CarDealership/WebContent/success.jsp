<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page import="src.com.back.Person"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Created!</title>

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
	<c:if test="${personlist != null}">
		<table class="table">
			<caption>New User Profile Created</caption>
			<thead>
				<tr>
					<th scope="col">Image</th>
					<th scope="col">Name</th>
					<th scope="col">User Name</th>
					<th scope="col">Phone Number</th>
					<th scope="col">Current Address</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="myperson" items="${personlist}">
					<td><img
						src="C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\defaulticon.jpg"
						height="100px" width="120px"></td>
					<td><c:out value="${myperson.firstName}" /><span>&nbsp;</span>
						<c:out value="${myperson.lastName}" /></td>
					<td><c:out value="${myperson.username}" /></td>
					<td><c:out value="${myperson.phoneNumber}" /></td>
					<td><c:out value="${myperson.street}" /></td>
					<td><c:out value="${myperson.city}" /></td>
					<td><c:out value="${myperson.state}" /></td>
					<td><c:out value="${myperson.zip}" /></td>


				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<a href="index.jsp">Continue to Checkout</a>
</body>
</html>