<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css"
	crossorigin="anonymous">
<title>Hotel Details</title>
</head>
<body>

<div class="container">
<p>Details Page<p>
<h1>Hotels in ${resultCityDisplay}</h1>

		
			<div class="list-group">
				<c:forEach var="resultList" items="${resultDetailsDisplay}">
					<a href="#" class="list-group-item">
						<h3>${ resultList.name }</h3>
						<p><label>Price per night:&nbsp;</label>$${ resultList.pricePerNight }</p>
					</a>
				</c:forEach>
			</div>
</div>

<a href="/" class="btn btn-link">Start a New Search.</a>

</body>
</html>