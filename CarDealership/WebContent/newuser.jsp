<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page import="src.com.back.Person"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Registration</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	<script src="../Scripts/jquery-2.1.4.js" type="text/javascript"></script>
    <script src="../Scripts/jquery.validate.js" type="text/javascript"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
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

input {
     width: 10em;
     float: left;
}
input.error {
                float: none;
                color: red;
                padding-left: .5em;
                vertical-align: top;
            }

</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" href="index.jsp">Home
				Page</a></li>
		<li class="nav-item"><a class="nav-link active" href="login.jsp">User
				Registration</a></li>
		<li class="nav-item"><a class="nav-link" href="dealerlogin.jsp">Contact
				Us</a></li>
	</ul>
	<form class="container" action="RegisterServlet" method="post">

		<h2>
			<b>New User Registration</b>
		</h2>
		<br> <img
			src="C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\users.jpg"
			style="width: 130px; height: 160px;">
		<p>
			<b>Enter your Personal Information Below:</b>
		</p>
		<table style="width: 50%">
			<tr>
				<td><br>Enter Your First Name</td>
				<td><br> <input type="text" name="firstname" /></td>
			</tr>
			<tr>
				<td><br>Last Name</td>
				<td><br> <input type="text" name="lastname" /></td>
			</tr>
			<tr>
				<td><br>Enter Address</td>
				<td><br>Street (e.g. = 404 Mockingbird Lane)<input
					type="text" name="street" /></td>
			</tr>
			<tr>
				<td><br>City (e.g. = Hollywood)<input type="text"
					name="city" /></td>
			</tr>
			<tr>
				<td><br>State (e.g. = CA)<input type="text" name="state" /></td>
			</tr>
			<tr>
				<td><br>Zip Code (e.g. = 63123)<input type="text"
					name="zip" /></td>
			</tr>
			<tr>
				<td><br>Phone Number</td>
				<td><br> <input type="text" size="10" maxlength="10"
					name="phonenumber" /></td>
			</tr>
			<tr>
				<td><br> <b>Enter A User Name and Password Below:</b><br></td>
			</tr>
			<tr>
				<td><br>New User Name</td>
				<td><br> <input type="text" name="username" /></td>
			</tr>
			<tr>
				<td><br>Enter Password</td>
				<td><br> <input type="password" name="password" /></td>
			</tr>

		</table>
		<button type="submit" value="login">Continue</button>
	</form>
</body>
</html>