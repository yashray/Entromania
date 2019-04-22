<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Dao.matchDao" %> <%@page import="Vo.matchVo" %>
<%@page import="Vo.concertVo" %> <%@page import="Dao.concertDao" %>
<%@page import="Vo.SponserVo" %> <%@page import="Dao.SponserDao" %>
<%@page import="Vo.stadiumVo" %> <%@page import="Dao.stadiumDao" %>
<%@page import="Vo.ProductVo" %> <%@page import="Dao.ProductDao" %>
<html lang="en">
<head>
<base href="${pageContext.request.contextPath}/Admin/">
<meta charset="utf-8">
<title>EntroMania Administrator</title>
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

<link type="text/css" href="css/fullcalendar.css" rel="stylesheet">
<!-- FullCalendar -->
<link type="text/css" href="css/jquery-jvectormap-2.0.2.css"
	rel="stylesheet">
<!-- jVectorMap -->
<link type="text/css" href="css/switchery.css" rel="stylesheet">
<!-- Switchery -->
<%
	matchVo matchVo = new matchVo();
	matchDao matchDao = new matchDao();
	List ls = matchDao.search(matchVo);
	HttpSession session2 = request.getSession();
	session2.setAttribute("loadMatch", ls);
	
	concertVo concertVo = new concertVo();
	concertDao concertDao = new concertDao();
	List ls1 = concertDao.search(concertVo);
	HttpSession session3 = request.getSession();
	session3.setAttribute("loadConcert", ls1);
	
	SponserVo sponserVo = new SponserVo();
	SponserDao sponserDao = new SponserDao();
	List ls2 = sponserDao.viewSponser(sponserVo);
	HttpSession session4 = request.getSession();
	session4.setAttribute("loadSponser", ls2);
	
	stadiumVo stadiumVo = new stadiumVo();
	stadiumDao stadiumDao = new stadiumDao();
	List ls3 = stadiumDao.search(stadiumVo);
	HttpSession session5 = request.getSession();
	session5.setAttribute("loadStadium", ls3);
	
	ProductVo productVo = new ProductVo();
	ProductDao productDao = new ProductDao();
	List ls4 = productDao.viewProduct(productVo);
	HttpSession session6 = request.getSession();
	session6.setAttribute("loadProduct", ls4);
%>

</head>

<body class="animated-content" >

	<jsp:include page="Header.jsp"></jsp:include>

	<div id="wrapper">
		<div id="layout-static">
			<jsp:include page="Menu.jsp"></jsp:include>
			<div class="static-content-wrapper">
				<div class="static-content">
					<div class="page-content">
						<ol class="breadcrumb">

							<li class=""><a href="Index.jsp">Home</a></li>
							<li class="active"><a href="Index.jsp">Dashboard</a></li>

						</ol>
						<div class="container-fluid">

							<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
								<div>
									<div class="col-md-4">
										<div class="panel panel-teal"
											data-widget='{"draggable": "false"}'>
											<div class="panel-heading">
												<h2>Sponsers</h2>
												<div class="panel-ctrls button-icon-bg"
													data-actions-container=""
													data-action-collapse='{"target": ".panel-body"}'
													data-action-colorpicker=''
													data-action-refresh-demo='{"type": "circular"}'>
												</div>
											</div>
											<div class="panel-body no-padding">
												<table class="table browsers m-n">
													<tbody>
													<c:forEach items="${sessionScope.loadSponser}" var="s">
														<tr>
															<td><h4><b>${s.sponserName}</b></h4></td>
															<td class="text-right"><img height="50px" width="150px" src="${pageContext.request.contextPath }/doc/${s.attachmentVo.encryptedFileName}"></td>
															
														</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<div>
								
									<div class="col-md-4">
										<div class="panel panel-teal"
											data-widget='{"draggable": "false"}'>
											<div class="panel-heading">
											
												<h2>Stadiums</h2>
												<div class="panel-ctrls button-icon-bg"
													data-actions-container=""
													data-action-collapse='{"target": ".panel-body"}'
													data-action-colorpicker=''
													data-action-refresh-demo='{"type": "circular"}'>
												</div>
											</div>
											<div class="panel-body no-padding">
												<table class="table browsers m-n">
													<tbody>
													<c:forEach items="${sessionScope.loadStadium}" var="t">
														<tr>
															<td>${t.stadium}</td>
															
														</tr></c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
									
									
								</div>
								<div>
								
									<div class="col-md-4">
										<div class="panel panel-teal"
											data-widget='{"draggable": "false"}'>
											<div class="panel-heading">
												<h2>Matches</h2>
												<div class="panel-ctrls button-icon-bg"
													data-actions-container=""
													data-action-collapse='{"target": ".panel-body"}'
													data-action-colorpicker=''
													data-action-refresh-demo='{"type": "circular"}'>
												</div>
											</div>
											<div class="panel-body no-padding">
												<table class="table browsers m-n">
													<tbody>
													<c:forEach items="${sessionScope.loadMatch}" var="m">
														<tr>
															<td>${m.title}</td>
														</tr></c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<div>
									<div class="col-md-4">
										<div class="panel panel-teal"
											data-widget='{"draggable": "false"}'>
											<div class="panel-heading">
												<h2>Concerts</h2>
												<div class="panel-ctrls button-icon-bg"
													data-actions-container=""
													data-action-collapse='{"target": ".panel-body"}'
													data-action-colorpicker=''
													data-action-refresh-demo='{"type": "circular"}'>
												</div>
											</div>
											<div class="panel-body no-padding">
												<table class="table browsers m-n">
													<tbody>
													<c:forEach items="${sessionScope.loadConcert}" var="p">
														<tr>
															<td>${p.title}</td>
														</tr></c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<div>
									<div class="col-md-4">
										<div class="panel panel-teal"
											data-widget='{"draggable": "false"}'>
											<div class="panel-heading">
												<h2>Product</h2>
												<div class="panel-ctrls button-icon-bg"
													data-actions-container=""
													data-action-collapse='{"target": ".panel-body"}'
													data-action-colorpicker=''
													data-action-refresh-demo='{"type": "circular"}'>
												</div>
											</div>
											<div class="panel-body no-padding">
												<table class="table browsers m-n">
													<tbody>
													<c:forEach items="${sessionScope.loadProduct}" var="o">
														<tr>
															<td>${o.productName}</td>
														</tr></c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								
							</div>
						
						</div>
						<!-- .container-fluid -->
					</div>
					<!-- #page-content -->
				</div>
				<footer role="contentinfo">
				<div class="clearfix">
					<ul class="list-unstyled list-inline pull-left">
						<li><h6 style="margin: 0;">&copy; 2015 Avenxo</h6></li>
					</ul>
					<button class="pull-right btn btn-link btn-xs hidden-print"
						id="back-to-top">
						<i class="ti ti-arrow-up"></i>
					</button>
				</div>
				</footer>
				<script>
					(function(i, s, o, g, r, a, m) {
						i['GoogleAnalyticsObject'] = r;
						i[r] = i[r] || function() {
							(i[r].q = i[r].q || []).push(arguments)
						}, i[r].l = 1 * new Date();
						a = s.createElement(o),
								m = s.getElementsByTagName(o)[0];
						a.async = 1;
						a.src = g;
						m.parentNode.insertBefore(a, m)
					})(window, document, 'script',
							'//www.google-analytics.com/analytics.js', 'ga');

					ga('create', 'UA-44426473-4', 'auto');
					ga('send', 'pageview');
				</script>

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
							data-size="mini" data-on-color="success" data-off-color="default"
							name="demo-fixedheader" data-on-text="&nbsp;"
							data-off-text="&nbsp;">
					</div>
				</div>
				<div class="tabular-row">
					<div class="tabular-cell">Boxed Layout</div>
					<div class="tabular-cell demo-switches">
						<input class="bootstrap-switch" type="checkbox" data-size="mini"
							data-on-color="success" data-off-color="default"
							name="demo-boxedlayout" data-on-text="&nbsp;"
							data-off-text="&nbsp;">
					</div>
				</div>
				<div class="tabular-row">
					<div class="tabular-cell">Collapse Leftbar</div>
					<div class="tabular-cell demo-switches">
						<input class="bootstrap-switch" type="checkbox" data-size="mini"
							data-on-color="success" data-off-color="default"
							name="demo-collapseleftbar" data-on-text="&nbsp;"
							data-off-text="&nbsp;">
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

	<!-- Charts -->
	<script type="text/javascript" src="js/jquery.flot.min.js"></script>
	<!-- Flot Main File -->
	<script type="text/javascript" src="js/jquery.flot.pie.min.js"></script>
	<!-- Flot Pie Chart Plugin -->
	<script type="text/javascript" src="js/jquery.flot.stack.min.js"></script>
	<!-- Flot Stacked Charts Plugin -->
	<script type="text/javascript" src="js/jquery.flot.orderBars.min.js"></script>
	<!-- Flot Ordered Bars Plugin-->
	<script type="text/javascript" src="js/jquery.flot.resize.min.js"></script>
	<!-- Flot Responsive -->
	<script type="text/javascript" src="js/jquery.flot.tooltip.min.js"></script>
	<!-- Flot Tooltips -->
	<script type="text/javascript" src="js/jquery.flot.spline.js"></script>
	<!-- Flot Curved Lines -->

	<script type="text/javascript" src="js/jquery.sparklines.min.js"></script>
	<!-- Sparkline -->

	<script type="text/javascript" src="js/jquery-jvectormap-2.0.2.min.js"></script>
	<!-- jVectorMap -->
	<script type="text/javascript"
		src="js/jquery-jvectormap-world-mill-en.js"></script>
	<!-- jVectorMap -->

	<script type="text/javascript" src="js/switchery.js"></script>
	<!-- Switchery -->
	<script type="text/javascript" src="js/jquery.easypiechart.js"></script>
	<script type="text/javascript" src="js/moment.min.js"></script>
	<!-- Moment.js Dependency -->
	<script type="text/javascript" src="js/fullcalendar.min.js"></script>
	<!-- Calendar Plugin -->

	<script type="text/javascript" src="js/demo-index.js"></script>
	<!-- Initialize scripts for this page-->

	<!-- End loading page level scripts-->

</body>
</html>