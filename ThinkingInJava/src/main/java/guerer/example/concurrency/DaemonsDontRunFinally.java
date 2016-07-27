package guerer.example.concurrency;

import guerer.example.util.Print;

import java.util.concurrent.TimeUnit;

class ADaemon implements Runnable {
	public void run() {
		try {
			Print.print("Starting ADaemon");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			Print.print("Exiting via InterruptedException");
		} finally {
			Print.print("This should always run?");
		}
	}
}

public class DaemonsDontRunFinally {

	public static void main(String[] args) {
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	}

}
