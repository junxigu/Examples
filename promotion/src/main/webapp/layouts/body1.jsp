<%@ taglib prefix="s" uri="/struts-tags" %>
<div style="
width: 100%;
position: absolute;
top: 70px;
background: rgb(221, 246, 253);
height: 100%;
left: 0;
padding: 10px">
	<h1>Amazon Gift Card Load</h1>

	<s:form action="uploadaction" method="post" enctype="multipart/form-data" >

	   <s:file label="Upload" theme="simple" name="upload"/>

	   <s:submit value="Upload"/>

	</s:form>

</div>