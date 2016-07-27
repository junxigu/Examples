package guerer.example.enumerate;

import guerer.example.util.Print;

import java.util.EnumMap;
import java.util.Map;

interface Command {
	void action();
}

public class EnumMaps {

	public static void main(String[] args) {
		EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(
				AlarmPoints.class);
		em.put(AlarmPoints.KITCHEN, new Command() {
			public void action() {
				Print.print("Kitchen fire!");
			}
		});
		em.put(AlarmPoints.BATHROOM, new Command() {
			public void action() {
				Print.print("Bathroom alert ! ");
			}
		});
		for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
			Print.printnb(e.getKey() + ": ");
			e.getValue().action();
		}
		try { // If there's no value for aparticular key
			em.get(AlarmPoints.UTILITY).action();
		} catch (Exception e) {
			Print.print(e);
		}
	}

}
