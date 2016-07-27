package org.guerer.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {

	public static EntityManagerFactory entityManagerFactory;

	@BeforeClass
	public static void classSetUp() throws Exception {
		// A SessionFactory is set up once for an application!
		entityManagerFactory = Persistence
				.createEntityManagerFactory("JPAExample");
	}

	@AfterClass
	public static void classTearDown() throws Exception {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
	}

}
