<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bus Reservation System - New Reservation</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<h2>New Reservation</h2>
				<form action="handle-reservation" method="post">
					<div class="form-group">
						<label for="source">Source:</label>
						<input type="text" class="form-control" id="source" name="source" placeholder="Enter source" required>
					</div>
					<div class="form-group">
						<label for="destination">Destination:</label>
						<input type="text" class="form-control" id="destination" name="destination" placeholder="Enter destination" required>
					</div>
					<div class="form-group">
						<label for="date">Date of Journey:</label>
						<input type="date" class="form-control" id="date" name="date" required>
					</div>
					<div class="form-group">
						<label for="numberOfSeats">Number of Seats:</label>
						<input type="number" class="form-control" id="numberOfSeats" name="numberOfSeats" placeholder="Enter number of seats" required>
					</div>
					<div class="form-group">
						<label for="firstName">First Name:</label>
						<input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter first name" required>
					</div>
					<div class="form-group">
						<label for="lastName">Last Name:</label>
						<input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter last name" required>
					</div>
					<div class="form-group">
						<label for="phoneNumber">Phone Number:</label>
						<input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Enter phone number" required>
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
		<div class="container text-center">
			<a href="${pageContext.request.contextPath }/listofreservations" class="btn btn-outline-success">Show existing reservations</a>
			<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Logout</a>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
