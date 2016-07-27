<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Upload Result Page</title>

<link rel="stylesheet" href="jslib/bootstrap-3.2.0/css/bootstrap.min.css">

<link rel="stylesheet" href="jslib/bootstrap-3.2.0/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="styles/classic.css">

<script src="jslib/jquery-1.9.1/jquery-1.9.1.min.js"></script>

<script src="jslib/bootstrap-3.2.0/js/bootstrap.min.js"></script>

</head>
<body>
	<div id="cover"></div>

	<div class="page-header">
		<h1>SpeedPass Element</h1>
	</div>

	<h1 class="title">Upload Amazon Card</h1>

	<div></div>

	<div class="tiles-page-body">

		<div class="panel panel-success">
			<div class="panel-heading">Successfully Inserted Result</div>
			<div class="panel-body">
				<span class="resultNum">
					<s:property value="result.succNum" />
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
							<s:property value="result.existedNum" />
						</span>
						Records' Code Are Already in Data Base.
					</li>
					<li class="list-group-item">
						<span class="resultNum">
							<s:property value="result.formatErrNum" />
						</span>
						Records' Format of 'Amount' Is Wrong.
					</li>
				</ul>
			</div>
		</div>

	</div>
</body>
</html>