package guerer.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

class Share {
	private int i = 0;
	private int j = 0;

	public synchronized void increase() {
		i++;
		j++;
	}

	public synchronized boolean check() {
		return i == j;
	}

}

class MyOwnRunnable implements Runnable {
	Share s;

	MyOwnRunnable(Share s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (s.check()) {
			s.increase();
		}
		System.out.println("wrong");
	}
}

public class Practice11 {

	@Test
	public void test() {
		ExecutorService es = Executors.newCachedThreadPool();
		Share s = new Share();
		for (int i = 0; i < 1000; i++) {
			es.execute(new MyOwnRunnable(s));
		}
	}
}
