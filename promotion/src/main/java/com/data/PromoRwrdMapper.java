package com.data;

import java.util.Date;

public interface PromoRwrdMapper{

	int countAwardedCust();
	
	int countViewedAwardCust();
	
	int countPeriodAwardCust(Date periodStart, Date periodEnd);
	
}