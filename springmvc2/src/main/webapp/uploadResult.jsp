<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Upload Result Page</title>

<link rel="stylesheet" href="css/bootstrap.min.css">

<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<link rel="stylesheet" href="css/classic.css">

</head>
<body>

	<div class="tiles-page-body">

		<div class="panel panel-success">
			<div class="panel-heading">Successfully Inserted Result</div>
			<div class="panel-body">
				<span class="resultNum">
					${result.succNum}
				</span>
				Records are Successfully Inserted.
			</div>
		</div>

		<div class="panel panel-danger">
			<div class="panel-heading">Unsuccessfully Inserted Result</div>
			<div class="panel-body">
				<ul class="list-group">
					<li class="list-group-item">
						<span class="resultNum">
							${result.existedNum}
						</span>
						Records' Code Are Already in Data Base.
					</li>
					<li class="list-group-item">
						<span class="resultNum">
							${result.formatErrNum}
						</span>
						Records' Format of 'Amount' Is Wrong.
					</li>
				</ul>
			</div>
		</div>

	</div>
</body>
</html>