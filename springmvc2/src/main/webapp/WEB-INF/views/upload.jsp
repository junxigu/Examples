<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Upload Amazon Card</title>

<link rel="stylesheet" href="jslib/bootstrap-3.2.0/css/bootstrap.min.css">

<link rel="stylesheet" href="jslib/bootstrap-3.2.0/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="styles/classic.css">

</head>
<body>
</body>

	<div class="page-header">
		<h1>SpeedPass Element</h1>
	</div>

	<h1 class="title">Upload Amazon Card</h1>

	<div></div>

	<div class="tiles-page-body">

		<div class="panel panel-default">
			<div class="panel-heading">Please Select a CSV File</div>
			<div class="panel-body">
				<form enctype="multipart/form-data"
					action="<c:url value="/uploadExcel" />" method="post">
					<lable >Upload CSV File</lable>
					<input type="file" name="file" />
					<input type="submit" value="Upload" />
				</form>
			</div>
		</div>

	</div>
	
	
</html>