package guerer.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class Practice22 {

	volatile boolean mark = false;

	@Test
	public void test() throws InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(new Runnable() {
			@Override
			public void run() {
				long b = System.currentTimeMillis();
				while (!mark) {
				}
				System.out.println(System.currentTimeMillis() - b);
			}
		});
		TimeUnit.SECONDS.sleep(1);
		es.execute(new Runnable() {
			@Override
			public void run() {
				mark = true;
			}
		});
		TimeUnit.SECONDS.sleep(1);
	}

}
