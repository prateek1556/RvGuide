<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome Home ${firstName}</h1>

		<h1>${email}</h1>
		<img src="${countryImg}" alt="" width="4%" height="4%">
		<br>
		<a href="${pageContext.request.contextPath}/practicecode">Practice Code</a>
		<br>
		<a href="${pageContext.request.contextPath}/algorithm">Algorithm</a>
		<br>
		<a href="${pageContext.request.contextPath}/datastructure">DataStructure</a>
		<br>
		<a href="${pageContext.request.contextPath}/machinelearning">Machine Learning</a>
		<br>
		<a href="${pageContext.request.contextPath}/testprocessing">Test Processing</a>
		<br>
		<a href="${pageContext.request.contextPath}/coronavirus">CoronaVirus Analysis</a>
		

		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value = "Logout" /t>
		</form:form>
		
</body>
</html>