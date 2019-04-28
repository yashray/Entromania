<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="coming-soon">
<head>
<base href="${pageContext.request.contextPath}/Admin/">
<meta charset="utf-8">
<title>Login</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="author" content="KaijuThemes">

<link
	href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400italic,600'
	rel='stylesheet' type='text/css'>
<link type="text/css" href="css/blue.css" rel="stylesheet">
<link type="text/css" href="css/font-awesome.min.css" rel="stylesheet">
<link type="text/css" href="css/themify-icons.css" rel="stylesheet">
<!-- Themify Icons -->
<link type="text/css" href="css/styles.css" rel="stylesheet">

<style>
.main-header {
	background-image: url("images/loginback.jpg"); background-repeat :
	no-repeat;
	background-position: center;
	background-size: cover;
	width: 100%;
	height: 100%;
	background-repeat: no-repeat;
}
</style>
</head>

<body class="main-header">


	<div class="container" id="login-form">
		<br /><br/><br/>
		<div align="center">
			<a href="login.jsp" class="login-logo"><img
				src="images/logo.png"></a>
		</div>
		<br />
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2>Login Form</h2>
					</div>
					<div class="panel-body">

						<form action="sa" class="form-horizontal" id="validate-form">
							<div class="form-group mb-md">
								<div class="col-xs-12">
									<div class="input-group">
										<span class="input-group-addon"> <i class="ti ti-user"></i>
										</span> <input type="text" name="email" class="form-control"
											placeholder="Email Id" data-parsley-minlength="6"
											placeholder="At least 6 characters" required>
									</div>
								</div>
							</div>

							<div class="form-group mb-md">
								<div class="col-xs-12">
									<div class="input-group">
										<span class="input-group-addon"> <i class="ti ti-key"></i>
										</span> <input type="password" name="password" class="form-control"
											id="exampleInputPassword1" placeholder="Password">
									</div>
								</div>
							</div>

							<div class="form-group mb-n">
								<div class="col-xs-12">
									<a href="forgotpassword.jsp" class="pull-left">Forgot
										password?</a>
									
								</div>
							</div>
					</div>
					<div class="panel-footer">
						<div class="clearfix">
							<a href="Registration.jsp" class="btn btn-default pull-left">Register</a>
							<input type="hidden" name="flag" value="login"> <input
								type="submit" value="Log In" class="btn btn-primary pull-right">
						</div>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>



	<!-- Load site level scripts -->

	<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script> -->

	<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
	<!-- Load jQuery -->
	<script type="text/javascript" src="js/jqueryui-1.10.3.min.js"></script>
	<!-- Load jQueryUI -->
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<!-- Load Bootstrap -->
	<script type="text/javascript" src="js/enquire.min.js"></script>
	<!-- Load Enquire -->

	<script type="text/javascript" src="js/velocity.min.js"></script>
	<!-- Load Velocity for Animated Content -->
	<script type="text/javascript" src="js/velocity.ui.min.js"></script>

	<script type="text/javascript" src="js/wijets.js"></script>
	<!-- Wijet -->

	<script type="text/javascript" src="js/prettify.js"></script>
	<!-- Code Prettifier  -->
	<script type="text/javascript" src="js/bootstrap-switch.js"></script>
	<!-- Swith/Toggle Button -->

	<script type="text/javascript" src="	js/bootstrap-tabdrop.js"></script>
	<!-- Bootstrap Tabdrop -->

	<script type="text/javascript" src="js/icheck.min.js"></script>
	<!-- iCheck -->

	<script type="text/javascript" src="js/jquery.nanoscroller.min.js"></script>
	<!-- nano scroller -->

	<script type="text/javascript" src="js/application.js"></script>
	<script type="text/javascript" src="js/demo.js"></script>
	<script type="text/javascript" src="js/demo-switcher.js"></script>

	<!-- End loading site level scripts -->
	<!-- Load page level scripts-->


	<!-- End loading page level scripts-->
</body>
</html>