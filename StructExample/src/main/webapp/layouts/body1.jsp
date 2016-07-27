<%@ taglib prefix="s" uri="/struts-tags"%>
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