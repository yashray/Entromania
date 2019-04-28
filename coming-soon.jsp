<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="full-page-image">
<head>
	<base href="${pageContext.request.contextPath}/Admin/">
    <meta charset="utf-8">
    <title>Avenxo is Coming!</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="author" content="KaijuThemes">

    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400italic,600' rel='stylesheet' type='text/css'>
    <link type="text/css" href="css/font-awesome.min.css" rel="stylesheet">        <!-- Font Awesome -->
    <link type="text/css" href="css/themify-icons.css" rel="stylesheet">               <!-- Themify Icons -->
    
    <link type="text/css" href="css/styles.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries. Placeholdr.js enables the placeholder attribute -->
    <!--[if lt IE 9]>
        <link type="text/css" href="assets/css/ie8.css" rel="stylesheet">
        <script type="text/javascript" src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The following CSS are included as plugins and can be removed if unused-->
    

    </head>

    <body class="coming-soon">
        
        
<div class="coming-soon-wrapper">
    <div class="container">
        <h1>Coming Soon!</h1>

        <div class="row">

            <p class="mb-xl">Reprehenderit corrupti debitis dolorum, et cumque in, nostrum reiciendis molestiae quod, beatae nemo possimus. A repellat praesentium provident voluptate quam distinctio voluptates. Adipisci, ipsum pariatur quae minus omnis, sint quaerat ab distinctio. Iure ratione, eaque.</p>

            <!-- The JS code replaces the inner HTML of .countdown and is not necessary, but keeping it to show the markup structure -->

            <div class="countdown clearfix">
                <div class="col-sm-3">
                    <div class="time-block">
                        <span class="digit">25</span>
                        <span class="digit-desc">Days</span>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="time-block">
                        <span class="digit">15</span>
                        <span class="digit-desc">Hours</span>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="time-block">
                        <span class="digit">32</span>
                        <span class="digit-desc">Minutes</span>
                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="time-block">
                        <span class="digit">43</span>
                        <span class="digit-desc">Seconds</span>
                    </div>
                </div>
            </div>
        </div>
    
        <div class="row">
            <div class="col-sm-12">
                <div class="input-group mt-xl mb-xl">
                    <input type="text" class="form-control" id="errsearch" placeholder="email@address.com">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Sign up!</button>
                    </span>
                </div>
            </div>
            <div class="col-sm-12">
                <ul class="demo-btns list-inline">
                    <li><a href="#" class="btn btn-social btn-rounded btn-facebook"><i class="ti ti-facebook"></i></a></li>
                    <li><a href="#" class="btn btn-social btn-rounded btn-twitter"><i class="ti ti-twitter"></i></a></li>
                    <li><a href="#" class="btn btn-social btn-rounded btn-github"><i class="ti ti-github"></i></a></li>
                    <li><a href="#" class="btn btn-social btn-rounded btn-flickr"><i class="ti ti-flickr"></i></a></li>
                    
                    <li><a href="#" class="btn btn-social btn-rounded btn-youtube"><i class="ti ti-youtube"></i></a></li>
                    <li><a href="#" class="btn btn-social btn-rounded btn-linkedin"><i class="ti ti-linkedin"></i></a></li>
                    <li><a href="#" class="btn btn-social btn-rounded btn-googleplus"><i class="ti ti-google"></i></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>



    
    
    <!-- Load site level scripts -->

<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script> -->

<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script> 							<!-- Load jQuery -->
<script type="text/javascript" src="js/jqueryui-1.10.3.min.js"></script> 							<!-- Load jQueryUI -->
<script type="text/javascript" src="js/bootstrap.min.js"></script> 								<!-- Load Bootstrap -->
<script type="text/javascript" src="js/enquire.min.js"></script> 									<!-- Load Enquire -->

<script type="text/javascript" src="js/velocity.min.js"></script>					<!-- Load Velocity for Animated Content -->
<script type="text/javascript" src="js/velocity.ui.min.js"></script>

<script type="text/javascript" src="js/wijets.js"></script>     						<!-- Wijet -->

<script type="text/javascript" src="js/prettify.js"></script> 				<!-- Code Prettifier  -->
<script type="text/javascript" src="js/bootstrap-switch.js"></script> 		<!-- Swith/Toggle Button -->

<script type="text/javascript" src="js/bootstrap-tabdrop.js"></script>  <!-- Bootstrap Tabdrop -->

<script type="text/javascript" src="js/icheck.min.js"></script>     					<!-- iCheck -->

<script type="text/javascript" src="js/jquery.nanoscroller.min.js"></script> <!-- nano scroller -->

<script type="text/javascript" src="js/application.js"></script>
<script type="text/javascript" src="js/demo.js"></script>
<script type="text/javascript" src="js/demo-switcher.js"></script>

<!-- End loading site level scripts -->
    <!-- Load page level scripts-->
    
<script type="text/javascript" src="js/countdown.js"></script>

<script>
$(function() {
    $('.countdown').countdown({
        date: "June 7, 2087 15:03:26",
        render: function(data) {
          var el = $(this.el);
          el.empty()
            //.append("<div class='col-sm-3'><div class='time-block'><span class='digit'>" + this.leadingZeros(data.years, 4) + " </span><span class='digit-desc'>years</span></div></div>")
            .append("<div class='col-sm-3'><div class='time-block'><span class='digit'>" + this.leadingZeros(data.days, 3) + " </span><span class='digit-desc'>days</span></div></div>")
            .append("<div class='col-sm-3'><div class='time-block'><span class='digit'>" + this.leadingZeros(data.hours, 2) + " </span><span class='digit-desc'>hrs</span></div></div>")
            .append("<div class='col-sm-3'><div class='time-block'><span class='digit'>" + this.leadingZeros(data.min, 2) + " </span><span class='digit-desc'>min</span></div></div>")
            .append("<div class='col-sm-3'><div class='time-block'><span class='digit'>" + this.leadingZeros(data.sec, 2) + " </span><span class='digit-desc'>sec</span></div></div>");
        }
    });
});
</script>

    <!-- End loading page level scripts-->

    </body>
</html>