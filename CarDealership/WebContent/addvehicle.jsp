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

.form-description {

  width: 100%;
  padding: 52px 80px;
  margin: 8px 0;
  box-sizing: border-box;
  
}
</style>
</head>
<body>
<ul class="nav nav-tabs">
			<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
			<li class="nav-item"><a class="nav-link active" href="addvehicle.jsp">Add to Inventory</a></li>
			<li class="nav-item"><a class="nav-link" href="dealerprofile.jsp">Back to Profile</a></li>
		</ul>
<form class="container" action="AddVehicleServlet" method="post">
<h4>Add New Vehicle</h4>
<p>Please have all information ready about the vehicle you wish to add to the inventory. Please enter your
information below.</p>
<div class="form-group">
<label for="Model">Model:</label>
<input type="text" class="form-control" name="model" id="model" placeholder="Enter the model">
</div>

<div class="form-group">
<label for="Manufacturer">Manufacturer:</label>
<input type="text" class="form-control" name="manufacturer" id="manufacturer" placeholder="Enter the car manufacturer">
</div>

<div class="form-group">
<label for="Car Year">Year:</label>
<input type="text" class="form-control" name="year" id="year" placeholder="Enter the year of the vehicle">
</div>

<div class="form-group">
<label for="Price">Price:</label>
<input type="text" class="form-control" name="price" id="price" placeholder="Enter the vehicle price agreed upon">
</div>
<div class="form-group">
<label for="Color">Color:</label>
<input type="text" class="form-control" name="color" id="color" placeholder="Enter the vehicle color">
</div>

<div class="form-group">
<label for="Mileage">Mileage:</label>
<input type="text" class="form-control" name="mileage" id="mileage" placeholder="Enter the vehicle mileage">
</div>

Condition: <select class="form-group" name="condition">
	<option value="default">Select</option>
	<option value="NEW">NEW</option>
	<option value="USED">USED</option>
</select>

<div class="form-group">
<label for="VIN">Vehicle Identification Number (VIN):</label>
<input type="text" class="form-control" name="vin" id="vin" 
placeholder="Enter the vehicle identification number">
</div>


<div class="form-group">
<label for="description">Detailed Description:</label>
<input type="text" class="form-description" name="description" id="description" 
placeholder="Enter the vehicle description, include the engine size, number of doors, etc.">
</div>


<div class="form-group">
<label for="image">Upload Image: </label>
<input type="file" name="image" size="50" />

</div>

<button type="submit" class="btn btn-primary">Submit</button>
		<p style="color:red">${error}</p>
</form>
</body>
</html>