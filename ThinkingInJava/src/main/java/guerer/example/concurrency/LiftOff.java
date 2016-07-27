package guerer.example.concurrency;

import guerer.example.util.Print;

public class LiftOff implements Runnable {

	protected int countDown = 10; // Default
	private static int taskcount = 0;
	private final int id = taskcount++;

	public LiftOff() {
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Lift off!")
				+ "), ";
	}

	public void run() {
		while (countDown-- > 0) {
			Print.printnb(status());
			Thread.yield();
		}
	}

}
