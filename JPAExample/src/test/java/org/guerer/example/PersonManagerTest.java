package org.guerer.example;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class PersonManagerTest extends BaseTest {

	private Name id;

	@Before
	public void insertAPserson() {
		Person p = new Person();
		p.setAge(7);
		p.setName(new Name("first name", "last name"));
		p.setCat(new Cat("cat", "red"));

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		id = em.merge(p).getName();
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
