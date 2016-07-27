package com.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;

public class PromoRwrdMapperTest extends TestCase {

	public void testCountAwardedCust() {
		SqlSession session = null;
		try {
			session = DBUtils.getSqlSessionFactory().openSession();
			session.getMapper(PromoRwrdMapper.class).countAwardedCust();
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

	public void testCountViewedAwardCust() {
		SqlSession session = null;
		try {
			session = DBUtils.getSqlSessionFactory().openSession();
			session.getMapper(PromoRwrdMapper.class).countViewedAwardCust();
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
	
	public void testCountPeriodAwardCust() {
		SqlSession session = null;
		try {
			session = DBUtils.getSqlSessionFactory().openSession();
			int dayMil = 24*3600*1000;
			SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
			Date start =  formatDate.parse("10/13/2014");
			System.out.println(session.getMapper(PromoRwrdMapper.class).countPeriodAwardCust(new Date(start.getTime() - dayMil), new Date(start.getTime() + dayMil)));
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
