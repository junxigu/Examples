package guerer.example.concurrency;

import guerer.example.util.Print;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car {
	private boolean waxOn = false;

	public synchronized void waxed() {
		waxOn = true;
		notifyAll();
	}

	public synchronized void buffed() {
		waxOn = false;
		notifyAll();
	}

	public synchronized void waitForWaxing() throws InterruptedException {
		while (!waxOn) {
			wait();
		}
	}

	public synchronized void waitForbuffring() throws InterruptedException {
		while (waxOn) {
			wait();
		}
	}
}

class WaxOn implements Runnable {
	private Car car;

	public WaxOn(Car car) {
		this.car = car;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				Print.printnb("Wax on! ");
				car.waxed();
				TimeUnit.MILLISECONDS.sleep(200);
				car.waitForbuffring();
			}
		} catch (InterruptedException e) {
			Print.print("Existing via interrupt");
		}
		Print.print("Ending wax on task");
	}

}

class WaxOff implements Runnable {
	private Car car;

	public WaxOff(Car car) {
		this.car = car;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				car.waitForWaxing();
				Print.printnb("Wax off! ");
				car.buffed();
				TimeUnit.MILLISECONDS.sleep(200);
			}
		} catch (InterruptedException e) {
			Print.print("Existing via interrupt");
		}
		Print.print("Ending wax off task");
	}
}

public class WaxMatic {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		Car car = new Car();
		exec.execute(new WaxOn(car));
		exec.execute(new WaxOff(car));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}

}
