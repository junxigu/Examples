package guerer.example.concurrent;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

class Practice19Own {
	public void sleep() {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Practice19 {

	@Test
	public void test() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				new Practice19Own().sleep();
			}
		});
		t.start();
		t.interrupt();
	}

}
