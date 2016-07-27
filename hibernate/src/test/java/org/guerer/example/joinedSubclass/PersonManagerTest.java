package org.guerer.example.joinedSubclass;

import java.util.HashSet;

import org.guerer.example.BaseTest;
import org.hibernate.Session;
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

		Session session = sessionFactory.openSession();
		session.beginTransaction();

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

		id = (Integer) session.save(manager);
		session.save(employee1);
		session.save(employee2);
		session.save(customer1);
		session.save(customer2);

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
