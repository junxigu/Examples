package guerer.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

class Practice15Own {
	Object lock1;
	Object lock2;
	Object lock3;

	public void m1() {
		synchronized (lock1) {
			try {
				while (true) {
					System.out.println("m1");
					TimeUnit.SECONDS.sleep(1);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void m2() {
		synchronized (lock2) {
			try {
				while (true) {
					System.out.println("m2");
					TimeUnit.SECONDS.sleep(1);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void m3() {
		synchronized (lock3) {
			try {
				while (true) {
					System.out.println("m3");
					TimeUnit.SECONDS.sleep(1);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class Practice15 {

	@Test
	public void test() throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(3);
		final Practice15Own po = new Practice15Own();
		// po.lock1 = this;
		// po.lock2 = this;
		// po.lock3 = this;
		po.lock1 = new Object();
		po.lock2 = new Object();
		po.lock3 = new Object();

		es.execute(new Runnable() {
			@Override
			public void run() {
				po.m1();
			}
		});
		es.execute(new Runnable() {
			@Override
			public void run() {
				po.m2();
			}
		});
		es.execute(new Runnable() {
			@Override
			public void run() {
				po.m3();
			}
		});
		TimeUnit.SECONDS.sleep(5);
	}

}
