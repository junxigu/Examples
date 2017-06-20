package guerer.example;

public class SelfCrossing335 {
	public boolean isSelfCrossing(int[] x) {
		for (int i = 0; i + 3 < x.length; i++) {
			if ((x[i] >= x[i + 2]) && (x[i + 1] <= x[i + 3])
					|| (i + 4 < x.length && x[i] < x[i + 2] && x[i + 1] == x[i + 3] && (x[i] + x[i + 4]) >= x[i + 2])
					|| (i + 5 < x.length && x[i] < x[i + 2] && x[i + 1] <= x[i + 3] && (x[i] + x[i + 4]) >= x[i + 2]
							&& (x[i + 1] + x[i + 5]) >= x[i + 3] && x[i + 2] >= x[i + 4])) {
				return true;
			}
		}
		return false;
	}
}
