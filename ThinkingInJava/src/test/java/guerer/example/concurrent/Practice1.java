package guerer.example.concurrent;

import org.junit.Test;

class MyRunnable implements Runnable {

	private static long id = 0L;
	private final long myId = id++;
	
	MyRunnable() {
		System.out.println("MyRunnable " + myId + " start");
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 3; i++) {
			System.out.println("MyRunnable " + myId + " running");
			Thread.yield();
		}
		System.out.println("MyRunnable " + myId + " end");
	}

}

public class Practice1 {

	@Test
	public void test() {
		for(int i = 0; i < 1000; i++) {
			new Thread(new MyRunnable()).start();
		}
	}

}
