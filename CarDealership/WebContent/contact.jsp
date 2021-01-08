<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<html lang="en">
<head>
<title>Contact Us</title>
<meta charset="UTF-8">
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
	<div id="central">
		<div class="content">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="search.jsp">Search</a></li>
			<li class="nav-item"><a class="nav-link" href="login.jsp">Log In</a></li>
			<li class="nav-item"><a class="nav-link active" href="contact.jsp">Contact Us</a></li>
		</ul>
			<h1>Contact Us:</h1>
			<p>Send your comments through this form and we will get back to
				you.</p>
			<div id="message">
			 <img src="C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\contactus.jpg">
				<form id="frmContact" name="frmContact" action="" method="POST"
					novalidate="novalidate">
					<div class="label">First Name:</div>
					<div class="field">
						<input type="text" id="pp-name" name="firstname"
							placeholder="Enter first name" title="Please enter your first name"
							class="required" aria-required="true" required>
					</div>
					<div class="label">Last Name:</div>
					<div class="field">
						<input type="text" id="pp-name" name="lastname"
							placeholder="Enter last name" title="Please enter your last name"
							class="required" aria-required="true" required>
					</div>
					<div class="label">Email:</div>
					<div class="field">
						<input type="text" id="pp-email" name="email"
							placeholder="Enter email address"
							title="Please enter your email address" class="required email"
							aria-required="true" required>
					</div>
					<div class="label">Phone Number:</div>
					<div class="field">
						<input type="text" id="pp-phone" name="phone"
							placeholder="e.g:6185549951"
							title="Please enter your phone number" class="required phone"
							aria-required="true" required>
					</div>
					<div class="label">Message:</div>
					<div class="field">
						<textarea id="about-project" name="message"
							placeholder="enter your message here"></textarea>
					</div>
					<div id="mail-status"></div>
					<input type="submit" name="submit" value="Send Message"
						id="send-message" style="clear: both;">
				</form>
			</div>
		</div>
		<!-- content -->
	</div>
	<!-- central -->

</body>
</html>