package com.data;

import java.util.ArrayList;

import com.models.Report;

public interface ReportMapper{

	ArrayList<Report> getEnrolledCust();
	
	ArrayList<Report> getEnrollingCust();
	
	ArrayList<Report> getEligibleCust();
	
	ArrayList<Report> getIneligibleCust();
	
	ArrayList<Report> getAwardedCust();
	
	ArrayList<Report> getRedeemedCust();
	
	ArrayList<Report> getTodayRedeemedCust();
	
}