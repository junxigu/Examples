package org.guerer.example.mapKeyCompAttr;

import java.util.HashMap;

import org.guerer.example.BaseTest;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class PersonManagerTest extends BaseTest {

	private Integer id;

	@Before
	public void insertAPserson() {
		Person p = new Person();
		p.setAge(7);
		p.setNicks(new HashMap<Name, Integer>() {
			{
				put(new Name("first name1", "last name1"), 1);
				put(new Name("first name2", "last name2"), 1);
			}
		});
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		id = (Integer) session.save(p);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testLoad() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println(session.load(Person.class, id));
		session.getTransaction().commit();
		session.close();
	}

}
