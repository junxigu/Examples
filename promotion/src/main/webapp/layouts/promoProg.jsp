<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="promotion">
	<div class="panel-group" id="accordion" role="tablist"
		aria-multiselectable="true">
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseOne" aria-expanded="true"
						aria-controls="collapseOne">Total Customers That Have Enrolled.</a>
				</h4>
			</div>
			<div id="collapseOne" class="panel-collapse collapse in"
				role="tabpanel">
				<div class="panel-body"><s:property value="enrolledCustCnt" /></div>
			</div>
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseTwo" aria-expanded="false"
						aria-controls="collapseTwo">Total Customers That Are Enrolled.</a>
				</h4>
			</div>
			<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel">
				<div class="panel-body"><s:property value="enrollingCustCnt" /></div>
			</div>
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseThree" aria-expanded="false"
						aria-controls="collapseThree">Total Customers With 3 Points.</a>
				</h4>
			</div>
			<div id="collapseThree" class="panel-collapse collapse"
				role="tabpanel">
				<div class="panel-body"><s:property value="custOver3PointCnt" /></div>
			</div>
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseFour" aria-expanded="false"
						aria-controls="collapseFour">Total Customers Awarded A Card.</a>
				</h4>
			</div>
			<div id="collapseFour" class="panel-collapse collapse"
				role="tabpanel">
				<div class="panel-body"><s:property value="awardedCustCnt" /></div>
			</div>
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseFive" aria-expanded="false"
						aria-controls="collapseFive">Total Customers That Have Viewed Their Reward.</a>
				</h4>
			</div>
			<div id="collapseFive" class="panel-collapse collapse"
				role="tabpanel">
				<div class="panel-body"><s:property value="viewedAwardCustCnt" /></div>
			</div>
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordion"
						href="#collapseSix" aria-expanded="false"
						aria-controls="collapseSix">Total Customers Enrolled With Less Than 3 Points.</a>
				</h4>
			</div>
			<div id="collapseSix" class="panel-collapse collapse"
				role="tabpanel">
				<div class="panel-body"><s:property value="enrollingCustLess3PointCnt" /></div>
			</div>
		</div>
	</div>
</div>