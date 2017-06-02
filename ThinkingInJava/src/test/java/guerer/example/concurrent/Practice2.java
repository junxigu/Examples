package guerer.example.concurrent;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

class FibonacciRunnable implements Runnable {

	private int n;

	public FibonacciRunnable(int i) {
		n = i;
	}

	@Override
	public void run() {
		System.out.println(getFibonacci(n));
	}

	private List<Long> getFibonacci(int n) {
		List<Long> fibonacci = new ArrayList<Long>();
		for (int i = 1; i <= n; i++) {
			fibonacci.add(calFibonacci(i));
		}
		return fibonacci;
	}

	private Long calFibonacci(int i) {
		return i < 3 ? 1 : calFibonacci(i - 1) + calFibonacci(i - 2);
	}

}

public class Practice2 {

	@Test
	public void test() {
		for(int i = 0; i < 40; i++) {
			new Thread(new FibonacciRunnable(i + 1)).start();
		}
		new FibonacciRunnable(41).run();
	}

}
