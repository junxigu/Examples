package org.guerer.example.jpql;

import java.util.List;

import javax.persistence.EntityManager;

import org.guerer.example.BaseTest;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class PersonManagerTest extends BaseTest {

	@Before
	public void insertAPserson() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		Person p = new Person();
		p.setEmail("email 1");
		p.setPassword("password");
		em.merge(p).getId();

		p = new Person();
		p.setEmail("email 2");
		p.setPassword("password");
		em.merge(p).getId();

		em.getTransaction().commit();
		em.close();
	}

	@Ignore
	@Test
	public void testLoad() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		@SuppressWarnings("unchecked")
		List<Object[]> list = em
				.createQuery(
					"select person, person.email, person.password from Person as person where person.id > ?1 and person.email like :email")
				.setParameter(1, 1).setParameter("email", "%email%")
				.getResultList();
		for (Object[] results : list) {
			for (Object result : results) {
				System.out.println(result);
			}
		}
		em.getTransaction().commit();
		em.close();
	}

	@Ignore
	@Test
	public void testConstruct() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		@SuppressWarnings("unchecked")
		List<Person> list = em
				.createQuery(
					"select new Person(person.email, person.password) from Person as person where person.id > ?1 and person.email like :email")
				.setParameter(1, 1).setParameter("email", "%email%")
				.getResultList();
		for (Person result : list) {
			System.out.println(result);
		}
		em.getTransaction().commit();
		em.close();
	}

	@Ignore
	@Test
	public void testDistinct() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		@SuppressWarnings("unchecked")
		List<Person> list = em.createQuery(
			"select distinct new person from Person as person").getResultList();
		for (Person result : list) {
			System.out.println(result);
		}
		em.getTransaction().commit();
		em.close();
	}

	@Ignore
	@Test
	public void testUpdate() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		System.out.println(em
				.createQuery("update Person as p set p.email = ?1")
				.setParameter(1, "Test Email").executeUpdate());
		em.getTransaction().commit();
		em.close();
	}

	@Ignore
	@Test
	public void testDelete() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		System.out.println(em.createQuery("delete from Person as p")
				.executeUpdate());
		em.getTransaction().commit();
		em.close();
	}

	@Ignore
	@Test
	public void testSql() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Object[]> list = em.createNativeQuery(
			"select PERSON_ID, EMAIL, PASSWORD from Person", "person_mapping")
				.getResultList();
		for (Object[] results : list) {
			for (Object result : results) {
				System.out.println(result);
			}
		}
		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void testNamedNativeSql() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Object[]> list = em.createNamedQuery("personQuery")
				.getResultList();
		for (Object[] results : list) {
			for (Object result : results) {
				System.out.println(result);
			}
		}
		em.getTransaction().commit();
		em.close();
	}
}
