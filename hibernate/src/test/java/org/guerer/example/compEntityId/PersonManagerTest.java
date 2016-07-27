package org.guerer.example.compEntityId;

import java.util.HashSet;

import org.guerer.example.BaseTest;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class PersonManagerTest extends BaseTest {

	Integer id;

	@Before
	public void insertAPserson() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Order order = new Order();
		order.setItems(new HashSet<OrderItem>());

		Product p = new Product("product 1");
		OrderItem item = new OrderItem();
		item.setProduct(p);
		item.setOrder(order);

		id = (Integer) session.save(order);
		session.save(p);
		session.save(item);

		p = new Product("product 1");
		item = new OrderItem();
		item.setProduct(p);
		item.setOrder(order);
		session.save(p);
		session.save(item);

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testLoad() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println(session.load(Order.class, id));
		session.getTransaction().commit();
		session.close();
	}

}
