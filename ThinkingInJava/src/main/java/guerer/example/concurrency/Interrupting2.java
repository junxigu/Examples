package guerer.example.concurrency;

import guerer.example.util.Print;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockedMutex {
	private Lock lock = new ReentrantLock();

	public BlockedMutex() {
		// Acquire it right away. to demonstrate interruption
		// of a task blocked on a ReentrantLock:
		lock.lock();
	}

	public void f() {
		try {
			// This will never be available to a second task
			lock.lockInterruptibly(); // Special call
			Print.print("lock acquired in f()");
		} catch (InterruptedException e) {
			Print.print("1nterrupted from lock acquisition in f()");
		}
	}
}

class Blocked2 implements Runnable {
	BlockedMutex blocked = new BlockedMutex();

	public void run() {
		Print.print("Waiting for f() i n BlockedMutex");
		blocked.f();
		Print.print("Broken out of blocked call ");
	}
}

public class Interrupting2 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Blocked2());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		Print.print("Issuing t.interrupt()");
		t.interrupt();
	}

}
