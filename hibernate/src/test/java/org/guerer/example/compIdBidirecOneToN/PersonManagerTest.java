package org.guerer.example.compIdBidirecOneToN;

import java.util.HashSet;

import org.guerer.example.BaseTest;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class PersonManagerTest extends BaseTest {

	Person id;
	
	@Before
	public void insertAPserson() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Person p = new Person();
		p.setFirst("first");
		p.setLast("last");
		p.setAddresses(new HashSet<Address>());
		p.setAge(8);

		Address a = new Address("address 1");
		a.setPerson(p);
		session.save(a);

		a = new Address("address 2");
		a.setPerson(p);
		session.save(a);

		id = p;
		
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
