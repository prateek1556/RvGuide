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
						<form:form
							action="${pageContext.request.contextPath}/authenticateTheUser"
							method="POST" modelAttribute="loginBean">

							<c:if test="${param.error != null}">

								<div class="alert alert-danger col-xs-offset-1 col-xs-10">Sorry!
									You entered invalid username/password.</div>

							</c:if>

							<c:if test="${param.logout != null}">

								<div class="alert alert-success col-xs-offset-1 col-xs-10">
									You have been logged out.</div>

							</c:if>

							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label>
								<form:input path="email" type="email" name="email"
									class="form-control" id="email" aria-describedby="emailHelp"
									placeholder="Enter email" />
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Password</label>
								<form:input path="password" type="password" name="password"
									id="password" class="form-control" aria-describedby="emailHelp"
									placeholder="Enter Password" />
							</div>
							<div class="form-group">
								<p class="text-center">
									By signing up you accept our <a href="#">Terms Of Use</a>
								</p>
							</div>
							<div class="col-md-12 text-center ">
								<input type="submit"
									class=" btn btn-block mybtn btn-primary tx-tfm" value="Login">
							</div>
							<div class="col-md-12 ">
								<div class="login-or">
									<hr class="hr-or">
									<span class="span-or">or</span>
								</div>
							</div>
							<div class="col-md-12 mb-3">
								<p class="text-center">
									<a href="javascript:void();" class="google btn mybtn"><i
										class="fa fa-google-plus"> </i> Signup using Google </a>
								</p>
							</div>
							<div class="form-group">
								<p class="text-center">
									Don't have account? <a
										href="${pageContext.request.contextPath}/loadregistration" id="signup">Sign
										up here</a>
								</p>
							</div>
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
