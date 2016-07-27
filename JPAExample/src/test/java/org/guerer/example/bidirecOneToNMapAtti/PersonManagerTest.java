package org.guerer.example.bidirecOneToNMapAtti;

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
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		Person p = new Person();
		p.setAge(7);

		Address a = new Address(new AddressPK("address 1 street",
				"address 1 detail"));
		a.setPerson(p);
		em.persist(a);

		a = new Address(new AddressPK("address 2 street", "address 2 detail"));
		a.setPerson(p);
		em.persist(a);

		em.persist(p);

		id = em.merge(p).getId();
		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void testLoad() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		System.out.println(em.getReference(Person.class, id));
		em.getTransaction().commit();
		em.close();
	}

}
