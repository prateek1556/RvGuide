<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>BaseBall Page</h1>

	<form:form method="POST"
		action="${pageContext.request.contextPath}/mlmodels/getlcprediction"
		modelAttribute="lcBean">


		<b>on-base percentage :</b>
		<form:input path="OBP" type="text" name="OBP" id="OBP"
			placeholder="Enter OBP" value="" />
		<br>
		<br>
		<b>Slugging percentage :</b>
		<form:input path="SLG" type="text" name="SLG" id="SLG"
			placeholder="Enter SLG" />
		<br>
		<br>
		<b>Opposition on-base percentage :</b>
		<form:input path="OOBP" type="text" name="OOBP" id="OOBP"
			placeholder="Enter OOBP" />
		<br>
		<br>
		<b>Opposition Slugging percentage :</b>
		<form:input path="OSLG" type="text" name="OSLG" id="OSLG"
			placeholder="Enter OSLG" />
		<br>
		<br>
		<button type="submit" class=" btn btn-block mybtn btn-primary tx-tfm">Result</button>

	</form:form>
</body>
</html>