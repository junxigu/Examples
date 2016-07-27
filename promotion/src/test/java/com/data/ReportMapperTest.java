package com.data;

import java.util.Date;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;

public class ReportMapperTest extends TestCase {

	public void testGetReportDetails() {
		SqlSession session = null;
		try {
			session = DBUtils.getSqlSessionFactory().openSession();
			session.getMapper(ReportMapper.class).getEnrolledCust();
			assertTrue(null, true);
		} catch (Exception e) {
			e.printStackTrace();
			fail(null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void testGetEnrollingCust() {
		SqlSession session = null;
		try {
			session = DBUtils.getSqlSessionFactory().openSession();
			session.getMapper(ReportMapper.class).getEnrollingCust();
			assertTrue(null, true);
		} catch (Exception e) {
			e.printStackTrace();
			fail(null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void testGetEligibleCust() {
		SqlSession session = null;
		try {
			session = DBUtils.getSqlSessionFactory().openSession();
			session.getMapper(ReportMapper.class).getEligibleCust();
			assertTrue(null, true);
		} catch (Exception e) {
			e.printStackTrace();
			fail(null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void testGetIneligibleCust() {
		SqlSession session = null;
		try {
			session = DBUtils.getSqlSessionFactory().openSession();
			session.getMapper(ReportMapper.class).getIneligibleCust();
			assertTrue(null, true);
		} catch (Exception e) {
			e.printStackTrace();
			fail(null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void testGetAwardedCust() {
		SqlSession session = null;
		try {
			session = DBUtils.getSqlSessionFactory().openSession();
			session.getMapper(ReportMapper.class).getAwardedCust();
			assertTrue(null, true);
		} catch (Exception e) {
			e.printStackTrace();
			fail(null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void testGetRedeemedCust() {
		SqlSession session = null;
		try {
			session = DBUtils.getSqlSessionFactory().openSession();
			session.getMapper(ReportMapper.class).getRedeemedCust();
			assertTrue(null, true);
		} catch (Exception e) {
			e.printStackTrace();
			fail(null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void testGetTodayRedeemedCust() {
		SqlSession session = null;
		try {
			session = DBUtils.getSqlSessionFactory().openSession();
			session.getMapper(ReportMapper.class).getTodayRedeemedCust();
			assertTrue(null, true);
		} catch (Exception e) {
			e.printStackTrace();
			fail(null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
}
