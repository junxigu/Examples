package org.guerer.example.nameedQuery;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import org.guerer.example.BaseTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class PersonManagerTest extends BaseTest {

	@Before
	public void insertAPserson() {
		Person p = new Person();
		p.setAge(7);

		Set<Address> addresses = new HashSet<Address>();
		Address a = new Address("address 1 detail");
		a.setPerson(p);
		addresses.add(a);

		a = new Address("address 2 detail");
		a.setPerson(p);
		addresses.add(a);

		p.setAddresses(addresses);

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void testNameQuery() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		System.out.println(em.createNamedQuery("personQuery").getResultList());
		System.out.println(em.createNamedQuery("addressQuery").getResultList());

		em.getTransaction().commit();
		em.close();
	}
}
