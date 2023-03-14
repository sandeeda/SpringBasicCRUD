<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>List of Reservations</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>List of Reservations</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Source</th>
					<th>Destination</th>
					<th>Date</th>
					<th>Number of Seats</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Phone Number</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="reservation" items="${reservations}">
					<tr>
						<td>${reservation.reservationID}</td>
						<td>${reservation.source}</td>
						<td>${reservation.destination}</td>
						<td>${reservation.date}</td>
						<td>${reservation.numberOfSeats}</td>
						<td>${reservation.firstName}</td>
						<td>${reservation.lastName}</td>
						<td>${reservation.phoneNumber}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container text-center">
			<a href="add-reservation" class="btn btn-outline-success">Add More</a>
			<a href="${pageContext.request.contextPath}" class="btn btn-outline-danger">Logout</a>
		</div>
	</div>
</body>
</html>
