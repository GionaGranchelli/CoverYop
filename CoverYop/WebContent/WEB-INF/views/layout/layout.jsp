<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<tiles:importAttribute scope="request" />
<!doctype html>
<!-- paulirish.com/2008/conditional-stylesheets-vs-css-hacks-answer-neither/ -->
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="no-js lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="no-js lt-ie9" lang="en"> <![endif]-->
<!-- Consider adding a manifest.appcache: h5bp.com/d/Offline -->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en-US">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<!--[if IE]>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" >
	<![endif]-->
<title><spring:message code="common.title" /></title>
<meta name="viewport"
	content="user-scalable=no, width=device-width, initial-scale=1, maximum-scale=1" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="description" content="Premium theme.">
<meta name="keywords" content="" />
<meta name="author" content="Squadra Genew">
<!-- Fav icon -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico"
	type="image/x-icon" />
<!-- <meta name="robots" content="index,follow"> -->

<!-- ############################# Stylesheets ############################# -->


<!-- OWL Carousel -->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/owl.carousel.css"
	media="screen" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/owl.transitions.css"
	media="screen" />
<!-- /OWL Carousel -->
<!-- Scamp Player stylesheets -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/js/scamp_player/css/scamp.player.css"
	media="screen" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/js/scamp_player/css/scamp.player.light.css"
	media="screen" />
<!-- /Scamp Player stylesheets -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/menu.css"
	media="screen" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	media="screen" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/media-queries.css"
	media="screen" />
<!-- Fancybox styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/fancybox.custom.css"
	media="screen" />
<!-- REVOLUTION BANNER CSS SETTINGS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/js/rs-plugin/css/settings.css"
	media="screen" />

<!-- ############################# Javascripts ############################# -->
<!-- jQuery -->
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"
	type="text/javascript"></script>


<!-- Add HTML5 support for older IE browsers -->
<!--[if lt IE 9]> 
		<script src="${pageContext.request.contextPath}/resources/js/html5.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/selectivizr-and-extra-selectors.min.js"></script>
	<![endif]-->
<!-- Modernizr -->
<script
	src="${pageContext.request.contextPath}/resources/js/modernizr.custom.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-validation-1.13.0/dist/jquery.validate.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<!-- JQuery File Upload -->
<!-- Bootstrap styles -->
<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"> -->
<!-- Generic page styles -->
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/upload-file/css/style.css"> --%>
<!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
<!-- <link rel="stylesheet" -->
<%-- 	href="${pageContext.request.contextPath}/resources/upload-file/css/jquery.fileupload.css"> --%>
<!-- Data Picker -->
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.ui.timepicker.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/jquery.ui.timepicker.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/datatables/css/jquery.dataTables_themeroller.css" />
<script
	src="${pageContext.request.contextPath}/resources/datatables/my.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/datatables/js/jquery.dataTables.min.js"></script>
</head>

<body>
	<tiles:insertAttribute name="menu" />

	<tiles:insertAttribute name="body" />
	<hr>
	<tiles:insertAttribute name="footer" />
</html>