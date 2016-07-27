<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title><tiles:getAsString name="title" /></title>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">

<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css">

<link rel="stylesheet"
	href="http://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="styles/classic.css">

</head>
<body>
	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="menu" />

	<tiles:insertAttribute name="body" />

	<tiles:insertAttribute name="footer" />

	<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

	<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	<script src="http://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>

	<script type="text/javascript" src="js/promo.js"></script>
</body>
</html>