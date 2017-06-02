package guerer.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Subscribe to see which companies asked this question.
 */

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
	
	public String toString() {
		return "Point: x: " + x + ", y: " + y;
	}
}

public class MaxPointsOnALine149 {

	// Map with Double Key can't work
	public int maxPoints2(Point[] points) {
		if (points == null)
			return 0;
		if (points.length < 3)
			return points.length;

		int result = 0;
		// foreach point in points
		for (int i = 0; i < points.length; i++) {
			// init a map to count lines start from point, init count for
			// overlap
			Map<Double, Integer> count = new HashMap<Double, Integer>();
			int overlap = 0;
			int max = 0;
			// for each other point that would belong to new line
			for (int j = i + 1; j < points.length; j++) {
				int delY = points[i].y - points[j].y;
				int delX = points[i].x - points[j].x;
				// if other point overlap with point or a X line, Y line
				if (delY == 0 && delX == 0) {
					// add overlap
					overlap++;
				} else {
					// cal the line that start from point and end with other
					double del = delX == 0 ? Double.MAX_VALUE : delY == 0 ? 0 : ((double)delY / delX);
					System.out.println(points[i]);;
					System.out.println(points[j]);;
					System.out.println("delY: " + delY + ", delX: " + delX);;
					// count the line in a Map
					if (!count.containsKey(del)) {
						count.put(del, 0);
					}
					count.put(del, count.get(del) + 1);

					// cal the max count in the map
					max = Math.max(max, count.get(del));
				}
			}
			System.out.println(count + " " + overlap);
			// get the result with max(result, maxCount + overlap + 1), 1 means
			// the start point
			result = Math.max(result, max + overlap + 1);
		}
		return result;
	}

	public int maxPoints(Point[] points) {
		if (points == null)
			return 0;
		if (points.length < 3)
			return points.length;

		int result = 0;
		// foreach point in points
		for (int i = 0; i < points.length; i++) {
			// init a map to count lines start from point, init count for
			// overlap, vertical line, horizontal line
			Map<Integer, Map<Integer, Integer>> count = new HashMap<Integer, Map<Integer, Integer>>();
			int overlap = 0;
			int max = 0;
			int verticalLine = 0;
			int horizontalLine = 0;
			// for each other point that would belong to new line
			for (int j = i + 1; j < points.length; j++) {
				int delY = points[i].y - points[j].y;
				int delX = points[i].x - points[j].x;
				// if other point overlap with point or a X line, Y line
				if (delY == 0 && delX == 0) {
					// add overlap
					overlap++;
				} else if (delY == 0) {
					horizontalLine++;
					max = Math.max(max, horizontalLine);
				} else if (delX == 0) {
					verticalLine++;
					max = Math.max(max, verticalLine);
				}
				// else
				else {
					// cal the line that start from point and end with other
					int gcd = gcd(delX, delY);
					delX /= gcd;
					delY /= gcd;

					// count the line in a Map
					if (!count.containsKey(delY)) {
						count.put(delY, new HashMap<Integer, Integer>());
					}
					Map<Integer, Integer> m = count.get(delY);
					if (!m.containsKey(delX)) {
						m.put(delX, 0);
					}
					m.put(delX, m.get(delX) + 1);
					// cal the max count in the map
					max = Math.max(max, m.get(delX));
				}
			}
			// System.out.println(max + " " + overlap);;
			// get the result with max(result, maxCount + overlap + 1), 1 means
			// the start point
			result = Math.max(result, max + overlap + 1);
		}
		return result;
	}

	public int gcd(int delX, int delY) {
		if (delX == 0)
			return delY;
		return gcd(delY % delX, delX);
	}

}
