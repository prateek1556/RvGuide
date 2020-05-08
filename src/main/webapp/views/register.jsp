<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet">
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-5 mx-auto">
				<div id="first">
					<div class="myform form ">
						<div class="logo mb-3">
							<div class="col-md-12 text-center">
								<h1>Login</h1>
							</div>
						</div>
						<form:form method="POST"
							action="${pageContext.request.contextPath}/registration"
							name="registration" modelAttribute="userBean">
							<div class="form-group">
								<label for="exampleInputEmail1">First Name</label>
								<form:input path="firstName" type="text" name="firstname"
									class="form-control" id="firstname"
									aria-describedby="emailHelp" placeholder="Enter Firstname" />
								<form:errors path="firstName" cssClass="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Last Name</label>
								<form:input path="lastName" type="text" name="lastname"
									class="form-control" id="lastname" aria-describedby="emailHelp"
									placeholder="Enter Lastname" />
								<form:errors path="lastName" cssClass="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label>
								<form:input path="email" type="email" name="email"
									class="form-control" id="email" aria-describedby="emailHelp"
									placeholder="Enter email" />
								<form:errors path="email" cssClass="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Password</label>
								<form:input path="password" type="password" name="password"
									id="password" class="form-control" aria-describedby="emailHelp"
									placeholder="Enter Password" />
								<form:errors path="password" cssClass="error"></form:errors>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Country</label>
								<%-- 								<form:select path="country" items="${countries}" /> --%>
								<form:select path="country" id="countries" name="countries"
									class="form-control" placeholder="Country">
									<form:option label="Select" value="" />
									<form:options items="${countries}" />

								</form:select>
								<form:errors path="country" cssClass="error"></form:errors>

							</div>
							${successMessage}
							<div class="col-md-12 text-center mb-3">
								<button type="submit"
									class=" btn btn-block mybtn btn-primary tx-tfm"
									>Register</button>
							</div>
							<div class="col-md-12 ">
								<div class="form-group">
									<p class="text-center">
										<a href="${pageContext.request.contextPath}/login" id="signin">Already
											have an account?</a>
									</p>
								</div>
							</div>
<!-- 							<spring:hasBindErrors name="employeeBean""> -->
<%-- 								<form:errors path="*" cssClass="error" /> --%>
<!-- 							</spring:hasBindErrors> -->
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
