package com.service;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;

import com.data.DBUtils;
import com.data.ReportMapper;

public class PromoServiceTest extends TestCase {

	public void testGenerateExcel() {
		SqlSession session = null;
		try {
			session = DBUtils.getSqlSessionFactory().openSession();
			assertTrue(null, new PromoService().generateExcel("E:/EnrolledCust.xls", session.getMapper(ReportMapper.class).getEnrolledCust()));
			assertTrue(null, new PromoService().generateExcel("E:/EnrollingCust.xls", session.getMapper(ReportMapper.class).getEnrollingCust()));
			assertTrue(null, new PromoService().generateExcel("E:/EligibleCust.xls", session.getMapper(ReportMapper.class).getEligibleCust()));
			assertTrue(null, new PromoService().generateExcel("E:/IneligibleCust.xls", session.getMapper(ReportMapper.class).getIneligibleCust()));
			assertTrue(null, new PromoService().generateExcel("E:/AwardedCust.xls", session.getMapper(ReportMapper.class).getAwardedCust()));
			assertTrue(null, new PromoService().generateExcel("E:/RedeemedCust.xls", session.getMapper(ReportMapper.class).getRedeemedCust()));
			assertTrue(null, new PromoService().generateExcel("E:/TodayRedeemedCust.xls", session.getMapper(ReportMapper.class).getTodayRedeemedCust()));
		} catch (Exception e) {
			e.printStackTrace();
			fail(null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void testExportExcel() {
		try {
			assertTrue(null, new PromoService().exportExcel("E:/enrolled_customers.xls"));
			assertTrue(null, new PromoService().exportExcel("E:/enrolling_customers.xls"));
			assertTrue(null, new PromoService().exportExcel("E:/eligible_customers.xls"));
			assertTrue(null, new PromoService().exportExcel("E:/awarded_customers.xls"));
			assertTrue(null, new PromoService().exportExcel("E:/redeemed_customers.xls"));
			assertTrue(null, new PromoService().exportExcel("E:/ineligible_customers.xls"));
			assertTrue(null, new PromoService().exportExcel("E:/today_awarded_customers.xls"));
		} catch (Exception e) {
			e.printStackTrace();
			fail(null);
		}
	}

}
