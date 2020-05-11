<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Details by country</h1>
	
			<h3>${country.country}</h3>
			<br>
			<img src="${countryImg}" alt="" width="6%" height="6%">
			<br><br><br>
			
			Total Conformed:	${country.totalConfirmed}<br>
			Total Deaths:		${country.totalDeaths}<br>
			Total Recovered:	${country.totalRecovered}<br>
			Active Cases:		${country.activeCases }<br>
			New Conformed:		${country.newConfirmed }<br>
			New Deaths:			${country.newDeaths }<br>
			New Recovered:		${country.newRecovered }<br>
</body>
</html>