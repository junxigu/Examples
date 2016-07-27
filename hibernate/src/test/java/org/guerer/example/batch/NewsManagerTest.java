package org.guerer.example.batch;

import org.guerer.example.BaseTest;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class NewsManagerTest extends BaseTest {

	@Before
	public void insertANews() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(new News("test news1 title", "test news1 content"));
		session.save(new News("test news2 title", "test news2 content"));

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testUpdate() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.createQuery("update News set title = :newTitle")
				.setString("newTitle", "test news new title").executeUpdate();

		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();

		ScrollableResults news = session.createQuery("from News").scroll();
		while (news.next()) {
			System.out.print(news.get(0));
		}

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testDelete() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println(session.createQuery("delete News").executeUpdate());

		session.getTransaction().commit();
		session.close();
	}

}
