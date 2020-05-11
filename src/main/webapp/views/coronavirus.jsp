<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Corona Virus world Details</h1>
	<br>
	<br> TotalConfirmed : ${corona.totalConfirmed}
	<br> TotalDeaths : ${corona.totalDeaths}
	<br> TotalRecovered : ${corona.totalRecovered}
	<br>
	<br>
	<br>

	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">Country</th>
				<th scope="col">Total Cases</th>
				<th scope="col">Total Deaths</th>
				<th scope="col">Total Recovered</th>
				<th scope="col">Active Cases</th>
				<th scope="col">New Confirmed</th>
				<th scope="col">New Deaths</th>
				<th scope="col">New Recovered</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="var" items= "${list}" >
				<tr>
					<td><a href="${pageContext.request.contextPath}/coronavirus/${var.country}">${var.country}</a></td>
					<td>${var.totalConfirmed}</td>
					<td>${var.totalDeaths}</td>
					<td>${var.totalRecovered}</td>
					<td>${var.activeCases }</td>
					<td>${var.newConfirmed }</td>
					<td>${var.newDeaths }</td>
					<td>${var.newRecovered }</td>
				</tr>
			</c:forEach>
	</table>


</body>
</html>