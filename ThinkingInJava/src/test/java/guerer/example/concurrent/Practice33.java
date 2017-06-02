package guerer.example.concurrent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

class Practice33GreenhouseScheduler {
	DelayQueue<GreenhouseTask> queue = new DelayQueue<GreenhouseTask>();

	private boolean terminated = false;

	private boolean light = false;
	private boolean water = false;
	private String thermostat = "Day";

	public String getThermostat() {
		return thermostat;
	}

	public void setThermostat(String value) {
		thermostat = value;
	}

	static class GreenhouseTask implements Runnable, Delayed {

		long trigger;

		GreenhouseTask(long delta) {
			trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
		}

		@Override
		public int compareTo(Delayed o) {
			GreenhouseTask l = (GreenhouseTask) o;
			if (l.trigger < trigger) {
				return 1;
			} else if (l.trigger > trigger) {
				return -1;
			}
			return 0;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
		}

		@Override
		public void run() {
		}

	}

	class LightOn extends GreenhouseTask {

		LightOn(long delta) {
			super(delta);
		}

		public void run() {
			System.out.println("Turning on lights");
			light = true;
			queue.add(new LightOn(200));
		}

	}

	class LightOff extends GreenhouseTask {

		LightOff(long delta) {
			super(delta);
		}

		public void run() {
			// Put hardware control code here to
			// physically turn off the light.
			System.out.println("Turning off lights");
			light = false;
			queue.add(new LightOff(400));
		}

	}

	class WaterOn extends GreenhouseTask {
		WaterOn(long delta) {
			super(delta);
		}

		public void run() {
			// Put hardware control code here.
			System.out.println("Turning greenhouse water on");
			water = true;
			queue.add(new WaterOn(600));
		}
	}

	class WaterOff extends GreenhouseTask {
		WaterOff(long delta) {
			super(delta);
		}

		public void run() {
			// Put hardware control code here.
			System.out.println("Turning greenhouse water off");
			water = false;
			queue.add(new WaterOff(800));
		}
	}

	class ThermostatNight extends GreenhouseTask {
		ThermostatNight(long delta) {
			super(delta);
		}

		public void run() {
			// Put hardware control code here.
			System.out.println("Thermostat tonight setting");
			setThermostat("Night");
			queue.add(new ThermostatNight(2000));
		}
	}

	class ThermostatDay extends GreenhouseTask {
		ThermostatDay(long delta) {
			super(delta);
		}

		public void run() {
			// Put hardware control code here.
			System.out.println("Thermostat to day setting");
			setThermostat("Day");
			queue.add(new ThermostatDay(1400));
		}
	}

	class Bell extends GreenhouseTask {
		Bell(long delta) {
			super(delta);
		}

		public void run() {
			System.out.println("Bing!");
			queue.add(new Bell(1000));
		}
	}

	class Terminate extends GreenhouseTask {
		Terminate(long delta) {
			super(delta);
		}

		public void run() {
			System.out.println("Terminating");
			for (DataPoint d : data)
				System.out.println(d);
			terminated = true;
		}
	}

	// New feature : data collection
	static class DataPoint {
		final Calendar time;
		final float temperature;
		final float humidity;

		public DataPoint(Calendar d, float temp, float hum) {
			time = d;
			temperature = temp;
			humidity = hum;
		}

		public String toString() {
			return time.getTime() + String.format(" temperature: %1$.1f humidity: %2$.2f", temperature, humidity);
		}
	}

	private Calendar lastTime = Calendar.getInstance();
	{ // Adjust date to the half hour
		lastTime.set(Calendar.MINUTE, 30);
		lastTime.set(Calendar.SECOND, 00);
	}
	private float lastTemp = 65.0f;
	private int tempDirection = +1;
	private float lastHumidity = 50.0f;
	private int humidityDirection = +1;
	private Random rand = new Random(47);
	List<DataPoint> data = Collections.synchronizedList(new ArrayList<DataPoint>());

	class CollectData extends GreenhouseTask {
		CollectData(long delta) {
			super(delta);
		}

		public void run() {
			System.out.println("Collecting data");

			// Pretend the interval is longer than it is :
			lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
			// One in 5 chances of reversing the direction :
			if (rand.nextInt(5) == 4)
				tempDirection = -tempDirection;
			// Store previous value :
			lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
			if (rand.nextInt(5) == 4)
				humidityDirection = -humidityDirection;
			lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();
			// Calendar must be cloned , otherwise all
			// Data points hold references to the same lastTime.
			// For a basic object like Calendar, clone() is OK.
			data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp, lastHumidity));

			queue.add(new CollectData(500));
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Practice33GreenhouseScheduler gh = new Practice33GreenhouseScheduler();
		// Former"Restart" class not necessary:
		schedule(gh);
		while (!gh.terminated) {
			gh.queue.take().run();
		}
	}

	public static void schedule(Practice33GreenhouseScheduler gh) {
		gh.queue.add(gh.new Terminate(5000));
		gh.queue.add(gh.new Bell(1000));
		gh.queue.add(gh.new ThermostatNight(2000));
		gh.queue.add(gh.new LightOn(200));
		gh.queue.add(gh.new LightOff(400));
		gh.queue.add(gh.new WaterOn(600));
		gh.queue.add(gh.new WaterOff(800));
		gh.queue.add(gh.new ThermostatDay(1400));
		gh.queue.add(gh.new CollectData(500));
	}

}

public class Practice33 {

	@Test
	public void test() {
		try {
			Practice33GreenhouseScheduler.main(null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
