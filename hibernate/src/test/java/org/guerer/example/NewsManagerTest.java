package org.guerer.example;

import java.util.List;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class NewsManagerTest extends BaseTest {

	private Integer id;
	
	@Before
	public void insertANews() {
		News news = new News();
		news.setContent("test news content");
		news.setTitle("test news title");

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		id = (Integer) session.save(news);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testCreateQuery() {
		Session session = sessionFactory.openSession();
		session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<News> newsList = session.createQuery("from News").list();
		for (News n : newsList) {
			System.out.println(n);
		}
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testLoad() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println(session.load(News.class, id));
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testGet() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println(session.get(News.class, id));
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testUpdate() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		News news = session.get(News.class, id);
		System.out.println(news);
		session.getTransaction().commit();
		session.close();
		
		news.setContent("test");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(news);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testDelete() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(session.get(News.class, id));
		session.getTransaction().commit();
		session.close();
	}

}
