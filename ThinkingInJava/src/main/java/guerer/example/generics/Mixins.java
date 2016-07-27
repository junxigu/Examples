package guerer.example.generics;

import java.util.Date;

interface TimeStamped {
	long getStamp();
}

class TimeStampedImp implements TimeStamped {
	private final long timestamp;

	public TimeStampedImp() {
		timestamp = new Date().getTime();
	}

	public long getStamp() {
		return timestamp;
	}
}

interface SerialNumbered {
	long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
	private static long counter = 1;
	private final long serialNumber = counter++;

	public long getSerialNumber() {
		return serialNumber;
	}
}

interface Basic {
	public void set(String val);

	public String get();
}

class BasicImp implements Basic {
	private String value;

	public void set(String val) {
		value = val;
	}

	public String get() {
		return value;
	}
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered {
	private TimeStamped timestamp = new TimeStampedImp();
	private SerialNumbered serialNumber = new SerialNumberedImp();

	public long getStamp() {
		return timestamp.getStamp();
	}

	public long getSerialNumber() {
		return serialNumber.getSerialNumber();
	}
}

public class Mixins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
		mixin1.set("test string1");
		mixin2.set("test string2");
		System.out.println(mixin1.get() + " " + mixin1.getStamp() + " "
				+ mixin1.getSerialNumber());
		System.out.println(mixin2.get() + " " + mixin2.getStamp() + " "
				+ mixin2.getSerialNumber());
	}
}
