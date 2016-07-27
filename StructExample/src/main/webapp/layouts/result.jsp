<%@ taglib prefix="s" uri="/struts-tags"%>
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