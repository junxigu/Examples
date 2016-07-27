package org.guerer.example.bidirecNToN;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import org.guerer.example.BaseTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class PersonManagerTest extends BaseTest {

	private Integer id;

	@Before
	public void insertAPserson() {
		Set<Address> addresses = new HashSet<Address>();
		addresses.add(new Address("address 1 detail"));
		addresses.add(new Address("address 2 detail"));

		Person p = new Person();
		p.setAge(7);
		p.setAddresses(addresses);

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		id = em.merge(p).getId();
		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void testLoad() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		System.out.println(em.getReference(Person.class, id));
		System.out.println(em.getReference(Person.class, id).getAddresses()
				.iterator().next().getPersons());
		em.getTransaction().commit();
		em.close();
	}

}
