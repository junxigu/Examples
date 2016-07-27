package org.guerer.example.bidirecOneToN;

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
		id = em.merge(p).getId();
		em.getTransaction().commit();
		em.close();
	}

	@Ignore
	@Test
	public void testLoad() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		System.out.println(em.getReference(Person.class, id));
		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void testJoin() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		System.out.println(em.createQuery(
			"select p.age, ad from Person as p left join p.addresses ad")
				.getResultList());
		em.getTransaction().commit();
		em.close();
	}

}
