<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title><tiles:getAsString name="title" /></title>


<link rel="stylesheet"
	href="jslib/bootstrap-3.2.0/css/bootstrap.min.css">

<link rel="stylesheet"
	href="jslib/bootstrap-3.2.0/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="styles/classic.css">

<script src="jslib/jquery-1.9.1/jquery-1.9.1.min.js"></script>

<script src="jslib/bootstrap-3.2.0/js/bootstrap.min.js"></script>

</head>
<body>
	<div id="cover"></div>

	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="menu" />

	<tiles:insertAttribute name="body" />
</body>
</html>