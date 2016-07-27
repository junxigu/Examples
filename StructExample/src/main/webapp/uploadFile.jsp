<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Upload Amazon Card</title>

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

		<div class="panel panel-default">
			<div class="panel-heading">Please Select a CSV File</div>
			<div class="panel-body">
				<s:form action="uploadaction" method="post" enctype="multipart/form-data">

					<s:file label="Upload CSV File" name="upload" />

					<s:submit value="Upload" />

				</s:form>
			</div>
		</div>

	</div>
</body>
</html>