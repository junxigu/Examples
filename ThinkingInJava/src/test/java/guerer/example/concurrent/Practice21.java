package guerer.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class Practice21 {

	@Test
	public void test() throws InterruptedException {
		final Runnable r1 = new Runnable() {
			@Override
			public synchronized void run() {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("r1");
			}
		};
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				synchronized (r1) {
					r1.notifyAll();
				}
			}
		};
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(r1);
		TimeUnit.MILLISECONDS.sleep(100);
		es.execute(r2);
		TimeUnit.SECONDS.sleep(15);
	}

}
