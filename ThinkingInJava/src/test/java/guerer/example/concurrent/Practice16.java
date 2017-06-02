package guerer.example.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

class Practice16Own {
	private Lock l = new ReentrantLock();

	public void m1() {
		l.lock();
		try {
			while (true) {
				System.out.println("m1");
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			l.unlock();
		}

	}

	public void m2() {
		l.lock();
		try {
			while (true) {
				System.out.println("m2");
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			l.unlock();
		}
	}

	public void m3() {
		l.lock();
		try {
			while (true) {
				System.out.println("m3");
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			l.unlock();
		}
	}
}

public class Practice16 {

	@Test
	public void test() throws InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(3);
		final Practice16Own po = new Practice16Own();

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
