package guerer.example.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

class Food {
	private static int counter = 0;
	private final int id = counter++;

	public String toString() {
		return "Food " + id;
	}
}

// This is given to the waiter, who gives it to the chef:
class Order { // (A data-transfer object)
	static int counter = 0;
	final int id = counter++;
	private final OwnCustomer customer;
	private final OwnWaitPerson waitPerson;
	private final Food food;

	public Order(OwnCustomer cust, OwnWaitPerson wp, Food f) {
		customer = cust;
		waitPerson = wp;
		food = f;
	}

	public Food item() {
		return food;
	}

	public OwnCustomer getOwnCustomer() {
		return customer;
	}

	public OwnWaitPerson getOwnWaitPerson() {
		return waitPerson;
	}

	public String toString() {
		return "Order: " + id + "item: " + food + " for: " + customer + " served by: " + waitPerson;
	}
}

// This i s what comes back from the chef:
class Plate {
	private final Order order;
	private final Food food;

	public Plate(Order ord, Food f) {
		order = ord;
		food = f;
	}

	public Order getOrder() {
		return order;
	}

	public Food getFood() {
		return food;
	}

	public String toString() {
		return food.toString();
	}
}

class OwnCustomer implements Runnable {

	// Only private
	static int counter = 0;
	final int id = counter++;
	final OwnWaitPerson waitPerson;
	private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<Plate>();

	public OwnCustomer(OwnWaitPerson w) {
		waitPerson = w;
	}

	public void deliver(Plate p) throws InterruptedException {
		// Only blocks if customer is still // eating the previous course:
		placeSetting.put(p);
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			Food food = new Food();
			try {
				waitPerson.placeOrder(this, food);
				// Blocks until course has been delivered:
				System.out.println(this + "eating " + placeSetting.take());
			} catch (InterruptedException e) {
				System.out.println(this + "waiting for " + food + " interrupted");
				break;
			}
		}
		System.out.println(this + "finished meal, leaving");
	}

	public String toString() {
		return "OwnCustomer " + id + " ";
	}
}

class OwnWaitPerson implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final OwnRestaurant restaurant;
	BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<Plate>();

	public OwnWaitPerson(OwnRestaurant rest) {
		restaurant = rest;
	}

	public void placeOrder(OwnCustomer cust, Food food) {
		try {
			// Shouldn't actually block because this is a
			// LinkedBlockingQueuewith no size limit:
			restaurant.orders.put(new Order(cust, this, food));
		} catch (InterruptedException e) {
			System.out.println(this + " placeorder interrupted");
		}
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until a course i s ready
				Plate plate = filledOrders.take();
				System.out.println(this + "received " + plate + " delivering to " + plate.getOrder().getOwnCustomer());
				plate.getOrder().getOwnCustomer().deliver(plate);
			}
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted");
		}
		System.out.println(this + " off duty");
	}

	public String toString() {
		return "OwnWaitPerson " + id + " ";
	}
}

class OwnChef implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final OwnRestaurant restaurant;
	private static Random rand = new Random(47);

	public OwnChef(OwnRestaurant rest) {
		restaurant = rest;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until an order appears:
				Order order = restaurant.orders.take();
				Food requestedItem = order.item();
				// Time t o prepare order:
				TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				Plate plate = new Plate(order, requestedItem);
				order.getOwnWaitPerson().filledOrders.put(plate);
			}
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted");
		}
		System.out.println(this + " off duty");
	}

	public String toString() {
		return "OwnChef " + id + " ";
	}
}

class OwnRestaurant implements Runnable {
	private List<OwnWaitPerson> waitPersons = new ArrayList<OwnWaitPerson>();
	private List<OwnChef> chefs = new ArrayList<OwnChef>();
	private ExecutorService exec;
	private static Random rand = new Random(47);
	BlockingQueue<Order> orders = new LinkedBlockingQueue<Order>();

	public OwnRestaurant(ExecutorService e, int nOwnWaitPersons, int nOwnChefs) {
		exec = e;
		for (int i = 0; i < nOwnWaitPersons; i++) {
			OwnWaitPerson waitPerson = new OwnWaitPerson(this);
			waitPersons.add(waitPerson);
			exec.execute(waitPerson);
		}

		for (int i = 0; i < nOwnChefs; i++) {
			OwnChef chef = new OwnChef(this);
			chefs.add(chef);
			exec.execute(chef);
		}
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// A new customer arrives; assign a OwnWaitPerson:
				OwnWaitPerson wp = waitPersons.get(rand.nextInt(waitPersons.size()));
				OwnCustomer c = new OwnCustomer(wp);
				exec.execute(c);
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (

		InterruptedException e) {
			System.out.println("OwnRestaurant interrupted");
		}

		System.out.println("OwnRestaurant closing");
	}
}

public class RestaurantWithQueues {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		OwnRestaurant restaurant = new OwnRestaurant(exec, 5, 2);
		exec.execute(restaurant);
		System.out.println("Press 'Enter' to quit");
		System.in.read();
		exec.shutdownNow();
	}
}
