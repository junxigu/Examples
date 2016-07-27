package guerer.example.concurrency;

public class NoreBasicThreads {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new LiftOff()).start();
		}
		System.out.println("Waiting for Lift off");
	}

}
