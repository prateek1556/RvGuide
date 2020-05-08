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
	<h1>Algorithm</h1>
	<br>
	<a href="${pageContext.request.contextPath}/algorithm/addalgorithm">Add
		your new algorithm</a>


	<h2>Your Algorithms</h2>
	<form:form>

		<br>
		<c:if test="${not empty algorithmList}">
			<table border="2">

				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="var" items="${algorithmList}">
					<tr>
						<td>${var.algorithm_id}</td>
						<td><a
							href="${pageContext.request.contextPath}/algorithm/getalgorithm/${var.algorithm_id}">
								${var.title} </a></td>
						<td><a
							href="${pageContext.request.contextPath}/algorithm/loadupdatealgorithm/${var.algorithm_id}">Edit</a>
						</td>
						<td><a
							href="${pageContext.request.contextPath}/algorithm/loaddeletealgorithm/${var.algorithm_id}">Delete</a></td>
					</tr>
				</c:forEach>

			</table>

		</c:if>
		<c:if test="${empty algorithmList}">

			<h2>No algorithm Added</h2>

		</c:if>
	</form:form>

	<%-- 	</center> --%>

</body>
</html>