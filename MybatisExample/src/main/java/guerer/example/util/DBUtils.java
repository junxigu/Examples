package guerer.example.util;

import guerer.example.Constants;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtils {

	private static SqlSessionFactory sqlSessionFactory;

	public static void initSqlSessionFactory(String env)
			throws IOException {
		if (sqlSessionFactory == null) {
			LogFactory.useLog4JLogging();
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources
					.getResourceAsStream(Constants.MYBATIS_CONFIG), env);
		}
	}
	
	public static void initSqlSessionFactory()
			throws IOException {
		initSqlSessionFactory(Constants.DEFAULT_ENV);
	}

	public static SqlSession getSqlSession() throws IOException {
		return sqlSessionFactory.openSession();
	}

}
