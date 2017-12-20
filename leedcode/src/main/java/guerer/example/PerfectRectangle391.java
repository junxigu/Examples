package guerer.example;
/*
 * Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).

Example 1:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [3,2,4,4],
  [1,3,2,4],
  [2,3,3,4]
]

Return true.

Example 2:

rectangles = [
  [1,1,2,3],
  [1,3,2,4],
  [3,1,4,2],
  [3,2,4,4]
]

Return false.

Example 3:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [3,2,4,4]
]

Return false.

Example 4:

rectangles = [
  [1,1,3,3],
  [3,1,4,2],
  [1,3,2,4],
  [2,2,4,4]
]

Return false.
 */

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle391 {
	public boolean isRectangleCover(int[][] rectangles) {
		if (rectangles.length == 0 || rectangles[0].length == 0)
			return false;

		int x1 = Integer.MAX_VALUE;
		int y1 = Integer.MAX_VALUE;
		int x2 = Integer.MIN_VALUE;
		int y2 = Integer.MIN_VALUE;

		Set<String> set = new HashSet<String>();
		int area = 0;

		for (int[] rec : rectangles) {
			x1 = Math.min(x1, rec[0]);
			y1 = Math.min(y1, rec[1]);
			x2 = Math.max(x2, rec[2]);
			y2 = Math.max(y2, rec[3]);

			if (!set.add(rec[0] + " " + rec[1]))
				set.remove(rec[0] + " " + rec[1]);
			if (!set.add(rec[2] + " " + rec[3]))
				set.remove(rec[2] + " " + rec[3]);
			if (!set.add(rec[0] + " " + rec[3]))
				set.remove(rec[0] + " " + rec[3]);
			if (!set.add(rec[2] + " " + rec[1]))
				set.remove(rec[2] + " " + rec[1]);

			area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
		}

		if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1)
				|| !set.contains(x2 + " " + y2) || set.size() != 4)
			return false;
		return area != (y2 - y1) * (x2 - x1);
	}
}
