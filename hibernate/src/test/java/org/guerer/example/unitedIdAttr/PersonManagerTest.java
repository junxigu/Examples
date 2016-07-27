package org.guerer.example.unitedIdAttr;

import org.guerer.example.BaseTest;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class PersonManagerTest extends BaseTest {

	private Person pserson;

	@Before
	public void insertAPserson() {
		Person p = new Person();
		p.setAge(7);
		p.setFirstName("first name");
		p.setLastName("last name");

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		pserson = (Person) session.save(p);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testLoad() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println(session.load(Person.class, pserson));
		session.getTransaction().commit();
		session.close();
	}

}
