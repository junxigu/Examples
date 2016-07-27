package guerer.example.enumerate;

import guerer.example.util.Print;

import java.util.EnumSet;

enum AlarmPoints {
	START1, START2, LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY, KITCHEN
}

public class EnumSets {
	public static void main(String[] args) {
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
		points.add(AlarmPoints.BATHROOM);
		Print.print(points);
		points.addAll(EnumSet.of(AlarmPoints.START1, AlarmPoints.START2,
				AlarmPoints.KITCHEN));
		Print.print(points);
		points = EnumSet.allOf(AlarmPoints.class);
		Print.print(points);
		points.removeAll(EnumSet.of(AlarmPoints.START1, AlarmPoints.START2,
				AlarmPoints.KITCHEN));
		Print.print(points);
		points.removeAll(EnumSet.of(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
		Print.print(points);
		points = EnumSet.complementOf(points);
		Print.print(points);
	}
}
