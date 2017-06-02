package guerer.example.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

class OwnEntrance implements Runnable {
	private static List<OwnEntrance> entrances = new ArrayList<OwnEntrance>();
	private int number = 0;
	private static int ownEntranceId = 0;
	// Doesn't need synchronization to read:
	private final int id = ownEntranceId++;
	private CountDownLatch cdl;
	private static volatile boolean canceled = false; // Atomic operation on a
														// volatile field:

	public static void cancel() {
		canceled = true;
	}

	public OwnEntrance(CountDownLatch cdl) {
		this.cdl = cdl;
		// Keep this task in a list. Also prevents garbage collection of dead
		// tasks
		entrances.add(this);
	}

	public void run() {
		while (!canceled) {
			synchronized (this) {
				++number;
			}
			System.out.println(this);
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted");
			}
		}
		System.out.println("Stopping " + this);
		cdl.countDown();
	}

	public synchronized int getValue() {
		return number;
	}

	public String toString() {
		return "Entrance " + id + ": " + getValue();
	}

	public static int sumEntrances() {
		int sum = 0;
		for (OwnEntrance entrance : entrances)
			sum += entrance.getValue();
		return sum;
	}
}

class CountTotal implements Runnable {

	private CountDownLatch cdl;

	CountTotal(CountDownLatch cdl) {
		this.cdl = cdl;
	}

	@Override
	public void run() {
		try {
			cdl.await();
			System.out.println("Sum of Entrances: " + OwnEntrance.sumEntrances());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

public class Practice32 {

	@Test
	public void test() throws InterruptedException {
		final int NUM = 5;
		ExecutorService exec = Executors.newCachedThreadPool();
		CountDownLatch cdl = new CountDownLatch(NUM);

		exec.execute(new CountTotal(cdl));
		for (int i = 0; i < NUM; i++)
			exec.execute(new OwnEntrance(cdl));
		// Run for a while, then stop and collect the data:
		TimeUnit.SECONDS.sleep(1);
		OwnEntrance.cancel();
		exec.shutdown();
		if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
			System.out.println("Some tasks were not terminated!");
	}

}
