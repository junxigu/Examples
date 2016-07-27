package org.guerer.example.asscOvvr;

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
		Address a = new Address("address detail");
		Employee p = new Employee();
		p.setAddress(a);
		p.setName("employee name");
		p.setTitle("employee title");

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		id = em.merge(p).getId();
		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void testLoad() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		System.out.println(em.getReference(Employee.class, id));
		em.getTransaction().commit();
		em.close();
	}

}
