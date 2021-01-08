<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Member Log In</title>
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
			<li class="nav-item"><a class="nav-link" href="dealerlogin.jsp">Employee Login
			</a></li>
			<li class="nav-item"><a class="nav-link active" href="login.jsp">Client Login</a></li>
			<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
		</ul>
	<form action="UserLoginServlet" method="post">
	<h3>Current Member Login</h3>
	<p>Please enter your user information below</p>
	<br>
		<table style="width: 30%">
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
		</table>
		<input type="submit" value="Login" /></form>
		<p>Don't have an account with us? <a href ="newuser.jsp">Click here</a> to get started!</p>
</body>
</html>