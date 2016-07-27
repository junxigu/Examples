package org.guerer.example.arrayAttr;

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
		p.setName("person name");
		p.setAge(7);
		String[] schools = new String[] { "little", "middle", };
		p.setSchools(schools);

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
