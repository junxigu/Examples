package guerer.example.concurrency;

import java.util.concurrent.TimeUnit;

import guerer.example.util.Print;

class NeedsCleanup {
	private final int id;

	public NeedsCleanup(int id) {
		this.id = id;
	}

	public void cleanup() {
		Print.print("Cleaning up " + id);
	}
}

class Blocked3 implements Runnable {
	private volatile double d = 0.0;

	public void run() {
		try {
			while (!Thread.interrupted()) {
				NeedsCleanup n1 = new NeedsCleanup(1);
				try {
					Print.print("Sleeping");
					TimeUnit.SECONDS.sleep(1);

					NeedsCleanup n2 = new NeedsCleanup(2);
					try {
						Print.print("Calculating");
						for (int i = 0; i < 2500000; i++) {
							d = d + (Math.PI + Math.E) / d;
						}
						Print.print("Finish time-consuming operation.");
					} finally {
						n2.cleanup();
					}
				} finally {
					n1.cleanup();
				}
			}
			Print.print("Existing via while() test");
		} catch (InterruptedException e) {
			Print.print("Existing via InterruptedException");
		}
	}

}

public class InterruptingIdiom {

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 1) {
			Print.print("usage: java InterruptingIdiom delay-in-mS");
			System.exit(1);
		}
		Thread t = new Thread(new Blocked3());
		t.start();
		TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
		t.interrupt();
	}
}
