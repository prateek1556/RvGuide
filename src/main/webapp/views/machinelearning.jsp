<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.cen {
	text-align: center;
}
</style>
<body>
	<%-- 	<center> --%>
	<h1>Implementation of Model Prediction</h1>
	<br>

	<h2>Models</h2>

	<br>

	<table border="2">

		<tr>
			<th>Model Name</th>
			<th>Model Type</th>
			<th>Algorithm Used</th>
			<th>Model Accuracy</th>
		</tr>
		<tr>
			<td><a
				href="${pageContext.request.contextPath}/mlmodels/baseballpredict"
				style="text-decoration: none">Baseball Qualification Prediction</a></td>
			<td>Classification</td>
			<td>LinearRegression</td>
			<td></td>
		</tr>
		<tr>
			<td>Model 2</td>
			<td></td>
			<td></td>
			<td></td>
		</tr>

	</table>




	<%-- 	</center> --%>

</body>
</html>