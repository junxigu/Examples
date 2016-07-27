package org.guerer.example.compOneToN;

import java.util.HashSet;
import java.util.Set;

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

		Set<School> schools = new HashSet<School>();
		schools.add(new School());
		schools.add(new School());

		Address a = new Address("address detail");
		a.setSchools(schools);

		Person p = new Person();
		p.setAge(8);
		p.setAddress(a);

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
