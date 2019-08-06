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
<title>Hotel Home</title>
</head>
<body>
<div class="container">
<p>Home Page<p>
<h1>Hotel Search</h1>
<h3>By City</h3>
	
	<form action="/results-page?theCity=${city}">
		<label>Choose City:&nbsp;</label>
		<select name="theCity">
			<option value=""default selected></option>
			<c:forEach var="city" items="${listOfCities}">
			<option value="${city}">${city}</option>
			</c:forEach>
		</select>
		
		<p>
		<label>Max Price:&nbsp;$&nbsp;</label>
		<input type="number" name="maxPrice"></input>
		</p>
		
		<p>	
		<button type="submit" class="btn btn-primary">Go</button>
		</p>
	</form>
	
</div>
</body>
</html>