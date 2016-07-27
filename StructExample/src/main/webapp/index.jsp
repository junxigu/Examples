<html>
<head>
<title>Database Administrator</title>

<link rel="stylesheet" href="jslib/bootstrap-3.2.0/css/bootstrap.min.css">

<link rel="stylesheet" href="jslib/bootstrap-3.2.0/css/bootstrap-theme.min.css">

<link rel="stylesheet" href="css/index.css">

</head>
<body>

	<div class="page-header">
		<h1>Database Administrator Utility</h1>
	</div>

	<div class="panel panel-primary" id="insertTokenTable">
		<div class="panel-heading">Insert Service Merchant Token Record</div>
		<table
			class="table table-bordered table-striped table-hover table-condensed table-responsive">
			<thead>
				<tr class="active">
					<th></th>
					<th>MERCHANT ID</th>
					<th>COUNTRY CODE</th>
					<th>ALIAS</th>
					<th>PASSWORD</th>
					<th>PARTNER ID</th>
					<th>SYSTEM ID</th>
					<th>CERTIFICATE</th>
					<th>DESCRIPTION</th>
				</tr>
			</thead>
			<tbody>
				<tr class="">
					<td><button type="button" class="insert btn btn-primary">Insert</button></td>
					<td class="serviceMerchantIdTd"><select class="serviceMerchantId">
					</select></td>
					<td class="countryCodeTd"><select class="countryCode">
					</select></td>
					<td><input class="alias" type="text" /></td>
					<td><input class="password" type="text" /></td>
					<td><input class="partnerId" type="text" /></td>
					<td><input class="systemId" type="text" /></td>
					<td><input class="certificate" type="text" /></td>
					<td><input class="description" type="text" /></td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="panel panel-info" id="tokenTable">
		<div class="panel-heading">Update Or Delete Service Merchant Token
			Records</div>
		<table
			class="table table-bordered table-striped table-hover table-condensed table-responsive">
			<thead>
				<tr class="success">
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>

	<script data-main="js/main" src="js/require.js"></script>

	<script type="text/template" id="table-head-col">
		<th>{{title}}</th>
	</script>

	<script type="text/template" id="table-body-row">
		<td><button type="button" class="update btn btn-info">Update</button></td>
		<td><button type="button" class="delete btn btn-danger">Delete</button></td>
		<td class="id">{{id}}</td>
		<td class="serviceMerchantIdTd"><input type="text" class="serviceMerchantId" value="{{serviceMerchantId}}"/></td>
		<td class="countryCodeTd"><input type="text" class="countryCode" value="{{countryCode}}"/></td>
		<td><input type="text" class="alias" value="{{alias}}"/></td>
		<td><input type="text" class="password" value="{{password}}"/></td>
		<td><input type="text" class="partnerId" value="{{partnerId}}"/></td>
		<td><input type="text" class="systemId" value="{{systemId}}"/></td>
		<td><input type="text" class="certificate" value="{{certificate}}"/></td>
		<td><input type="text" class="description" value="{{description}}"/></td>
		<td>{{creationTime}}</td>
		<td>{{updateTime}}</td>
	</script>
</body>
</html>