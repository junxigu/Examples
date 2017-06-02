package guerer.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class Practice3 {

	@Test
	public void testCachedThreadPool() {
		runTasks(Executors.newCachedThreadPool());
	}

	@Test
	public void testFixedThreadPool() {
		runTasks(Executors.newFixedThreadPool(5));
	}

	@Test
	public void testSingleThreadExecutor() {
		runTasks(Executors.newSingleThreadExecutor());
	}

	private void runTasks(ExecutorService es) {
		for (int i = 0; i < 1000; i++) {
			es.execute(new MyRunnable());
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
