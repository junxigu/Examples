package guerer.example.concurrency;

import guerer.example.util.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal {
	private final int orderNum;

	public Meal(int orderNum) {
		this.orderNum = orderNum;
	}

	public String toString() {
		return "Meal " + orderNum;
	}
}

class WaitPerson implements Runnable {
	private Restaurant Restaurant;

	public WaitPerson(Restaurant r) {
		Restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (Restaurant.meal == null)
						wait(); // ... for the chef to produce a meal
				}
				Print.print("WaitPerson got " + Restaurant.meal);
				synchronized (Restaurant.chef) {
					Restaurant.meal = null;
					Restaurant.chef.notifyAll(); // Ready for another
				}
			}
		} catch (InterruptedException e) {
			Print.print("WaitPerson int e r r u p t e d ");
		}
	}
}

class Chef implements Runnable {
	private Restaurant Restaurant;
	private int count = 0;

	public Chef(Restaurant r) {
		Restaurant = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (Restaurant.meal != null)
						wait(); // ... for the meal to be taken
				}
				if (++count == 10) {
					Print.print("0ut of food. c l o s i n g ");
					Restaurant.exec.shutdownNow();
				}
				Print.printnb("0rder up! ");
				synchronized (Restaurant.waitPerson) {
					Restaurant.meal = new Meal(count);
					Restaurant.waitPerson.notifyAll();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			Print.print("Chef int e r r u p t e d ");
		}
	}
}

public class Restaurant {

	Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);

	public Restaurant() {
		exec.execute(chef);
		exec.execute(waitPerson);
	}

	public static void main(String[] args) {
		new Restaurant();
	}

}
