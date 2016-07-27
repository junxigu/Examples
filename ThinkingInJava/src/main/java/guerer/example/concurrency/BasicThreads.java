package guerer.example.concurrency;

import guerer.example.util.Print;

public class BasicThreads {

	public static void main(String[] args) {
		Thread t = new Thread(new LiftOff());
		t.start();
		Print.print("Waiting for Lift off");
	}

}
