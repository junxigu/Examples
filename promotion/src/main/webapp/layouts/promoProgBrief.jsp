<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="promotion">

	<div class="panel panel-default">
		<div class="panel-body">
			Total Customers That Have Enrolled:
			<s:property value="enrolledCustCnt" />
			.
			<!-- 
			<s:url id="download_enrolled_customers" action="downloadFile">
				<s:param name="report">enrolled_customers</s:param>
			</s:url>
			<s:a href="%{download_enrolled_customers}">Download This Report</s:a>
			 -->
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-body">
			Total Customers That Are Enrolled:
			<s:property value="enrollingCustCnt" />
			.
			<!-- 
			<s:url id="download_enrolling_customers" action="downloadFile">
				<s:param name="report">enrolling_customers</s:param>
			</s:url>
			<s:a href="%{download_enrolling_customers}">Download This Report</s:a>
			 -->
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-body">
			Total Customers With 3 Points:
			<s:property value="custOver3PointCnt" />
			.
			<!-- 
			<s:url id="download_eligible_customers" action="downloadFile">
				<s:param name="report">eligible_customers</s:param>
			</s:url>
			<s:a href="%{download_eligible_customers}">Download This Report</s:a>
			 -->
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-body">
			Total Customers Awarded A Card:
			<s:property value="awardedCustCnt" />
			.
			<!-- 
			<s:url id="download_awarded_customers" action="downloadFile">
				<s:param name="report">awarded_customers</s:param>
			</s:url>
			<s:a href="%{download_awarded_customers}">Download This Report</s:a>
			 -->
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-body">
			Total Customers That Have Viewed Their Reward:
			<s:property value="viewedAwardCustCnt" />
			.
			<!-- 
			<s:url id="download_redeemed_customers" action="downloadFile">
				<s:param name="report">redeemed_customers</s:param>
			</s:url>
			<s:a href="%{download_redeemed_customers}">Download This Report</s:a>
			 -->
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-body">
			Total Customers Enrolled With Less Than 3 Points:
			<s:property value="enrollingCustLess3PointCnt" />
			.
			<!-- 
			<s:url id="download_ineligible_customers" action="downloadFile">
				<s:param name="report">ineligible_customers</s:param>
			</s:url>
			<s:a href="%{download_ineligible_customers}">Download This Report</s:a>
			 -->
		</div>
	</div>

	<input type="text" id="datepicker" value="<s:property value="periodStart" />">

	<div class="panel panel-default">
		<div class="panel-body">
			Total Customers Awarded A Card During Given Time Period:
			<s:property value="periodAwardCustCount" />
			.
		</div>
	</div>

</div>