package guerer.example.concurrent;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class Practice14 {

	@Test
	public void test() {
		for (int i = 0; i < 1000; i++) {
			final int j = i;
			new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					System.out.println(j);
				}
			}, 500);
		}
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
