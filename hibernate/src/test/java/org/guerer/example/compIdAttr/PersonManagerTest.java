package org.guerer.example.compIdAttr;

import org.guerer.example.BaseTest;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class PersonManagerTest extends BaseTest {

	private Name id;

	@Before
	public void insertAPserson() {
		Person p = new Person();
		p.setAge(7);
		p.setName(new Name("first name", "last name"));
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		id = (Name) session.save(p);
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
