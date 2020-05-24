<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<form:form role="form"  method="POST"
		action="${pageContext.request.contextPath}/textprocessing/getprocessedtext"
		modelAttribute="txtBean">
		<div class="form-group">
			<label for="name">Enter Text</label>
			<form:textarea path="text" class="form-control" rows="3" placeholder="Enter Text"></form:textarea>
		</div>
		
		<input type="submit" value="Get Clean Text">
	</form:form>

</body>
</html>