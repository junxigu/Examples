package guerer.example;

import java.util.ArrayList;
import java.util.List;

/*
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows == 0) {
			return result;
		}
		List<Integer> tmp = new ArrayList<Integer>();
		tmp.add(1);
		result.add(tmp);

		for (int i = 1; i < numRows; i++) {
			List<Integer> old = result.get(result.size() - 1);
			tmp = new ArrayList<Integer>();
			for (int j = 0, t = 0; j < old.size(); t = old.get(j), j++) {
				tmp.add(t + old.get(j));
			}
			tmp.add(old.get(old.size() - 1));
			result.add(tmp);
		}
		return result;
	}
}
