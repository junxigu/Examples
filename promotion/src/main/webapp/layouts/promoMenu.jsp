<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="menu">
	<ul>
		<li>
			<s:url id="download_awarded_customers" action="downloadFile">
				<s:param name="report">awarded_customers</s:param>
			</s:url>
			<s:a href="%{download_awarded_customers}">Download Awarded Customers' Report</s:a>
		</li>
		<li>
			<s:url id="download_today_awarded_customers" action="downloadFile">
				<s:param name="report">today_awarded_customers</s:param>
			</s:url>
			<s:a href="%{download_today_awarded_customers}">Download Last 24 Hours Awarded Customers' Report</s:a>
		</li>
	</ul>
</div>