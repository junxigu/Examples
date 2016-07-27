package org.guerer.example.joinedSubclass;

import java.util.HashSet;

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
		p.setName("person");
		p.setAddress(new Address("address"));

		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();

		Manager manager = new Manager();
		manager.setName("manager");
		manager.setAddress(new Address("address"));
		manager.setDepartment("department");
		manager.setTitle("manager");

		Employee employee1 = new Employee();
		employee1.setName("employee 1");
		employee1.setAddress(new Address("address"));
		employee1.setCustomers(new HashSet<Customer>());
		employee1.setTitle("employee 1");
		employee1.setManager(manager);

		Employee employee2 = new Employee();
		employee2.setName("employee 2");
		employee2.setAddress(new Address("address"));
		employee2.setCustomers(new HashSet<Customer>());
		employee2.setTitle("employee 2");
		employee2.setManager(manager);

		Customer customer1 = new Customer();
		customer1.setName("customer 1");
		customer1.setAddress(new Address("address"));
		customer1.setComments("comments");
		customer1.setEmployee(employee1);

		Customer customer2 = new Customer();
		customer2.setName("customer 2");
		customer2.setAddress(new Address("address"));
		customer2.setComments("comments");
		customer2.setEmployee(employee2);

		em.persist(customer1);
		em.persist(customer2);
		id = customer1.getEmployee().getManager().getId();
		
		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void testLoad() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		System.out.println(em.find(Person.class, id));
		em.getTransaction().commit();
		em.close();
	}

}
