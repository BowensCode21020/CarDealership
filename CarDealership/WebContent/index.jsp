<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome to the Project Dealership</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

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
</style>
</head>

<body>
<jsp:include page="/ShowVehicleServlet" />
<jsp:include page="/RegisterServlet" />

	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link active" href="index.jsp">Welcome
					Page</a></li>
			<li class="nav-item"><a class="nav-link" href="search.jsp">Search</a></li>
			<li class="nav-item"><a class="nav-link" href="login.jsp">Log In</a></li>
			<li class="nav-item"><a class="nav-link" href="contact.jsp">Contact Us</a></li>
		</ul>
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" class="active"
				data-slide-to="0"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img alt="First slide" class="d-block w-100"
					src="C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\cars-on-a-lot-near-trees.jpg">
			</div>
			<div class="carousel-item">
				<img alt="Second slide" class="d-block w-100"
					src="C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\interior.jpg">
			</div>
			<div class="carousel-item">
				<img alt="Third slide" class="d-block w-100"
					src="C:\\Users\\Brandon\\Desktop\\CarDealershipProject\\960w.jpg">
			</div>
		</div>
	<h2>Our Story:</h2>
	<p>Unlike our competitors, we wish to provide low cost, affordable transportation for all
	of your needs both in and off the road. We are a dedicated team with a passion to help you 
	find your ideal vehicle, going above and beyond to help secure a price that is right for you!</p>
	<br>
	<h3>Browse Vehicles</h3>
	<p>We provide a lovely assortment of both new and used cars that will fit well within your budget. 
	Take a look at our current line up and decide the vehicle that is best for you!	<a href ="vehicle.jsp">
	Learn More</a></p>
	<br>

	</div>
	
	
</body>
</html>