package org.guerer.example.oneToOne;

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
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Person p = new Person();
		p.setAge(8);
		p.setAddress(new Address("address 1"));
		id = (Integer) session.save(p);

		p.setAddress(new Address("address 2"));

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
