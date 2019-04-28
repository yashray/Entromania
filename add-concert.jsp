<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="${pageContext.request.contextPath}/Admin/">
<meta charset="utf-8">
<title>Add Concert</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="description" content="Avenxo Admin Theme">
<meta name="author" content="KaijuThemes">

<link type='text/css'
	href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400italic,600'
	rel='stylesheet'>

<link type="text/css" href="css/font-awesome.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link type="text/css" href="css/themify-icons.css" rel="stylesheet">
<!-- Themify Icons -->
<link type="text/css" href="css/styles.css" rel="stylesheet">
<!-- Core CSS with all styles -->

<link type="text/css" href="css/prettify.css" rel="stylesheet">
<!-- Code Prettifier -->
<link type="text/css" href="css/blue.css" rel="stylesheet">
<!-- iCheck -->

<!--[if lt IE 10]>
        <script type="text/javascript" src="js/media.match.min.js"></script>
        <script type="text/javascript" src="js/respond.min.js"></script>
        <script type="text/javascript" src="js/placeholder.min.js"></script>
    <![endif]-->
<!-- The following CSS are included as plugins and can be removed if unused-->


</head>

<body class="animated-content">

	<jsp:include page="Header.jsp"></jsp:include>

	<div id="wrapper">
		<div id="layout-static">
			<jsp:include page="Menu.jsp"></jsp:include>
			<div class="static-content-wrapper">
				<div class="static-content">
					<div class="page-content">
						<ol class="breadcrumb">

							<li><a href="Index.jsp">Home</a></li>
							<li class="active"><a href="add-concert.jsp">Add Concert</a></li>

						</ol>
						<div class="container-fluid">

							<div data-widget-group="group1">
								<div class="row">
									<div class="col-sm-12">

										<div class="panel panel-midnightblue"
											data-widget='{"draggable": "false"}'>
											<div class="panel-heading">
												<h2>Add Concert</h2>
												<!-- <div class="panel-ctrls" data-actions-container="" data-action-collapse='{"target": ".panel-body, .panel-footer"}'></div> -->

											</div>
											<div class="panel-body">
												<div class="tab-content">
													<div class="tab-pane active" id="horizontal-form">
														<form class="form-horizontal" action="<%=request.getContextPath()%>/concertCo" method="post">
															<div class="form-group mb-n">
																<label for="largeinput"
																	class="col-sm-2 control-label label-input-lg">Title</label>
																<div class="col-sm-8">
																	<input type="text" name="title" class="form-control input-lg"
																		id="largeinput" placeholder="Enter Title for Concert" required>
																</div>
															</div>
															<br/>
															<div class="form-group mb-n">
																<label for="largeinput"
																	class="col-sm-2 control-label label-input-lg">Singer</label>
																<div class="col-sm-8">
																	<input type="text" name="singer" class="form-control input-lg"
																		id="largeinput" placeholder="Concert By" required>
																</div>
															</div>
															<br/>
															<div class="form-group mb-n">
																<label for="largeinput"
																	class="col-sm-2 control-label label-input-lg">Select
																	Stadium</label>
																<div class="col-sm-8">
																	<select name="stadiumid" id="selector1"
																		class="form-control">
																		<c:forEach var="b" items="${sessionScope.loadstadium }">
																		<option value="${b.s_id}">${b.stadium }</option>
																		</c:forEach>
																</select>
									
																</div>
															</div>
															<br>
															<div class="form-group mb-n">
																<label for="largeinput"
																	class="col-sm-2 control-label label-input-lg">Date</label>
																<div class="col-sm-6">
																	<input type="date" name="date" class="form-control input-lg"
																		data-inputmask="'alias':'date'" required>
																</div>
															</div>
															<br>

															<div class="form-group mb-n">
																<label for="largeinput"
																	class="col-sm-2 control-label label-input-lg">Time</label>
																<div class="col-sm-8">
																	<input type="text" name="time" class="form-control input-lg"
																		id="largeinput" placeholder="Enter Timing Of Concert" required>
																</div>
															</div>
															<br />
															<div class="form-group">
																<label for="col-sm-2 mb-n"
																	class="col-sm-2 control-label label-input-lg">Concert
																	Desription</label>
																<div class="col-sm-8">
																	<textarea name="c_des" class="form-control autosize" required></textarea>
																</div>
															</div>


															<div class="row">
																<div class="col-sm-8 col-sm-offset-2">
																	<button class="btn-primary btn" name="flag" value="insertconcert">Add Concert</button>
																	<button class="btn-default btn">Cancel</button>
																</div>
															</div>

														</form>
													</div>



												</div>
											</div>

										</div>
									</div>
								</div>


							</div>
						</div>
					</div>


					<!-- Switcher -->
					<div class="demo-options">
						<div class="demo-options-icon">
							<i class="ti ti-paint-bucket"></i>
						</div>
						<div class="demo-heading">Demo Settings</div>

						<div class="demo-body">
							<div class="tabular">
								<div class="tabular-row">
									<div class="tabular-cell">Fixed Header</div>
									<div class="tabular-cell demo-switches">
										<input class="bootstrap-switch" type="checkbox" checked
											data-size="mini" data-on-color="success"
											data-off-color="default" name="demo-fixedheader"
											data-on-text="&nbsp;" data-off-text="&nbsp;">
									</div>
								</div>
								<div class="tabular-row">
									<div class="tabular-cell">Boxed Layout</div>
									<div class="tabular-cell demo-switches">
										<input class="bootstrap-switch" type="checkbox"
											data-size="mini" data-on-color="success"
											data-off-color="default" name="demo-boxedlayout"
											data-on-text="&nbsp;" data-off-text="&nbsp;">
									</div>
								</div>
								<div class="tabular-row">
									<div class="tabular-cell">Collapse Leftbar</div>
									<div class="tabular-cell demo-switches">
										<input class="bootstrap-switch" type="checkbox"
											data-size="mini" data-on-color="success"
											data-off-color="default" name="demo-collapseleftbar"
											data-on-text="&nbsp;" data-off-text="&nbsp;">
									</div>
								</div>
							</div>
						</div>

						<div class="demo-body">
							<div class="option-title">Topnav</div>
							<ul id="demo-header-color" class="demo-color-list">
								<li><span class="demo-cyan"></span></li>
								<li><span class="demo-light-blue"></span></li>
								<li><span class="demo-blue"></span></li>
								<li><span class="demo-indigo"></span></li>
								<li><span class="demo-deep-purple"></span></li>
								<li><span class="demo-purple"></span></li>
								<li><span class="demo-pink"></span></li>
								<li><span class="demo-red"></span></li>
								<li><span class="demo-teal"></span></li>
								<li><span class="demo-green"></span></li>
								<li><span class="demo-light-green"></span></li>
								<li><span class="demo-lime"></span></li>
								<li><span class="demo-yellow"></span></li>
								<li><span class="demo-amber"></span></li>
								<li><span class="demo-orange"></span></li>
								<li><span class="demo-deep-orange"></span></li>
								<li><span class="demo-midnightblue"></span></li>
								<li><span class="demo-bluegray"></span></li>
								<li><span class="demo-bluegraylight"></span></li>
								<li><span class="demo-black"></span></li>
								<li><span class="demo-gray"></span></li>
								<li><span class="demo-graylight"></span></li>
								<li><span class="demo-default"></span></li>
								<li><span class="demo-brown"></span></li>
							</ul>
						</div>

						<div class="demo-body">
							<div class="option-title">Sidebar</div>
							<ul id="demo-sidebar-color" class="demo-color-list">
								<li><span class="demo-cyan"></span></li>
								<li><span class="demo-light-blue"></span></li>
								<li><span class="demo-blue"></span></li>
								<li><span class="demo-indigo"></span></li>
								<li><span class="demo-deep-purple"></span></li>
								<li><span class="demo-purple"></span></li>
								<li><span class="demo-pink"></span></li>
								<li><span class="demo-red"></span></li>
								<li><span class="demo-teal"></span></li>
								<li><span class="demo-green"></span></li>
								<li><span class="demo-light-green"></span></li>
								<li><span class="demo-lime"></span></li>
								<li><span class="demo-yellow"></span></li>
								<li><span class="demo-amber"></span></li>
								<li><span class="demo-orange"></span></li>
								<li><span class="demo-deep-orange"></span></li>
								<li><span class="demo-midnightblue"></span></li>
								<li><span class="demo-bluegray"></span></li>
								<li><span class="demo-bluegraylight"></span></li>
								<li><span class="demo-black"></span></li>
								<li><span class="demo-gray"></span></li>
								<li><span class="demo-graylight"></span></li>
								<li><span class="demo-default"></span></li>
								<li><span class="demo-brown"></span></li>
							</ul>
						</div>



					</div>
					<!-- /Switcher -->
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

					<script type="text/javascript" src="js/bootstrap-tabdrop.js"></script>
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