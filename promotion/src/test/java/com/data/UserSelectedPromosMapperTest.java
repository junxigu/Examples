package com.data;

import java.io.IOException;
import java.util.Date;

import junit.framework.TestCase;

import org.apache.ibatis.session.SqlSession;

public class UserSelectedPromosMapperTest extends TestCase {

	private SqlSession getSqlSession() throws IOException {
		return DBUtils.getSqlSessionFactory().openSession();
	}

	public void testCountEnrolledCust() {
		SqlSession session = null;
		try {
			getSqlSession().getMapper(UserSelectedPromosMapper.class)
					.countEnrolledCust();
			assertTrue(null, true);
		} catch (Exception e) {
			fail(null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void testCountEnrollingCust() {
		SqlSession session = null;
		try {
			getSqlSession().getMapper(UserSelectedPromosMapper.class)
					.countEnrollingCust();
			assertTrue(null, true);
		} catch (Exception e) {
			fail(null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void testCountCustOver3Point() {
		SqlSession session = null;
		try {
			getSqlSession().getMapper(UserSelectedPromosMapper.class)
					.countCustOver3Point();
			assertTrue(null, true);
		} catch (Exception e) {
			fail(null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void testCountEnrollingCustLess3Point() {
		SqlSession session = null;
		try {
			getSqlSession().getMapper(UserSelectedPromosMapper.class)
					.countEnrollingCustLess3Point();
			assertTrue(null, true);
		} catch (Exception e) {
			fail(null);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
