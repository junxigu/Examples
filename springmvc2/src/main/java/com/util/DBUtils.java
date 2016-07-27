package com.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtils {

	private static SqlSessionFactory sqlSessionFactory;

	public static void initSqlSessionFactory(String configFile)
			throws IOException {
		if (sqlSessionFactory == null) {
			LogFactory.useLog4JLogging();
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources
					.getResourceAsStream(configFile));
		}
	}

	public static SqlSession getSqlSession()
			throws IOException {
		return sqlSessionFactory.openSession();
	}

}
