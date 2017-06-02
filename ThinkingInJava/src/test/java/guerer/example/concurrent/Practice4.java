package guerer.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class Practice4 {

	@Test
	public void testCachedThreadPool() {
		printFibonacci(Executors.newCachedThreadPool());
	}

	@Test
	public void testFixedThreadPool() {
		printFibonacci(Executors.newFixedThreadPool(5));
	}

	@Test
	public void testSingleThreadExecutor() {
		printFibonacci(Executors.newSingleThreadExecutor());
	}

	private void printFibonacci(ExecutorService es) {
		for (int i = 0; i < 40; i++) {
			es.execute(new FibonacciRunnable(i + 1));
		}
		new FibonacciRunnable(41).run();
	}

}
