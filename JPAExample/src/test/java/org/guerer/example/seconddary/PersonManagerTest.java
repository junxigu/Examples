package org.guerer.example.seconddary;

import javax.persistence.EntityManager;

import org.guerer.example.BaseTest;
import org.guerer.example.secondary.Person;
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
		p.setContent("content");
		p.setEmail("email");
		p.setPhone("phone");
		
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
		em.getTransaction().commit();
		em.close();
	}

}
