<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>TinyMCE - Get Data</title>
</head>
<style>
</style>
<body>
	<%-- <center> --%>



	<form:form method="POST"
		action="${pageContext.request.contextPath}/algorithm/deletealgorithm/${algoObj2.algorithm_id}"
		modelAttribute="algoObj2">
		<br>
			Title :  <form:input path="title" placeholder="Enter Title" />
		<br>
		<br>
		<form:textarea class="tinymce" path="algorithm_data" id="texteditor" />
		<br>
		<br>
		<input type="submit" value="Delete Algorithm">


	</form:form>

	<div id="data-container"></div>

	<!-- javascript -->
	<script type="text/javascript" src="../../js/jquery.min.js"></script>
	<script type="text/javascript" src="../../plugin/tinymce/tinymce.min.js"></script>
	<script type="text/javascript" src="../../plugin/tinymce/init-tinymce.js"></script>
	<script type="text/javascript" src="../../js/getdata.js"></script>

	<%-- 	</center> --%>
</body>
</html>