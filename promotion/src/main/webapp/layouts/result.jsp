<%@ taglib prefix="s" uri="/struts-tags" %>
<div style="
width: 100%;
position: absolute;
top: 70px;
background: rgb(221, 246, 253);
height: 100%;
left: 0;
padding: 10px">
	<h1>Upload Result</h1>
	<h2>Successully insert: <s:property value="succNum" /></h2>
	<h2>Unsuccessully insert: <s:property value="errorNum" /></h2>
</div>