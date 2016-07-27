package org.guerer.example.formulaAttr;

import org.guerer.example.BaseTest;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class NewsManagerTest extends BaseTest {

	private Integer id;

	@Before
	public void insertAFormulaNews() {
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
	public void testLoad() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println(session.load(News.class, id));
		session.getTransaction().commit();
		session.close();
	}

}
