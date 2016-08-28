package guerer.example;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 */

public class ClimbingStairs {
	public int climbStairs(int n) {
		if (n < 0) {
			return 0;
		}

		switch (n) {
		case 0:
			return 0;
		case 1:
			return 1;
		case 2:
			return 2;
		default:
			int s1 = 1;
			int s2 = 2;
			for (int i = 2; i < n; i++) {
				int tmp = s2;
				s2 = s1 + s2;
				s1 = tmp;
			}
			return s2;
		}
	}
}
