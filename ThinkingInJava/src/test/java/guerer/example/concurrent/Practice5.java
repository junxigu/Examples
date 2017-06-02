package guerer.example.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

class FibonacciSumCallable implements Callable<Long> {

	private int n;

	public FibonacciSumCallable(int i) {
		n = i;
	}

	private List<Long> getFibonacci(int n) {
		List<Long> fibonacci = new ArrayList<Long>();
		for (int i = 1; i <= n; i++) {
			fibonacci.add(calFibonacci(i));
		}
		return fibonacci;
	}

	private long calFibonacci(int i) {
		return i < 3 ? 1 : calFibonacci(i - 1) + calFibonacci(i - 2);
	}

	@Override
	public Long call() throws Exception {
		long result = 0;
		for (long l : getFibonacci(n)) {
			result += l;
		}
		return result;
	}

}

public class Practice5 {

	@Test
	public void test() {
		ExecutorService es = Executors.newCachedThreadPool();
		List<Future<Long>> results = new ArrayList<Future<Long>>();
		for (int i = 0; i < 40; i++) {
			results.add(es.submit(new FibonacciSumCallable(i + 1)));
		}
		try {
			for (Future<Long> result : results) {
				System.out.println(result.get());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
