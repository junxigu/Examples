package guerer.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

 */
public class PascalsTriangleII {
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new LinkedList<Integer>();
		List<Integer> temp = new ArrayList<Integer>(Collections.nCopies(rowIndex, 1));
		result.add(1); 
		for(int i = rowIndex; i > 1; i--) {
			for(int j = 1; j < rowIndex; j++) {
				temp.set(j, temp.get(j - 1) + temp.get(j));
			}
			result.add(temp.get(i - 1));
		}
		if(rowIndex > 0) {
			result.add(1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(PascalsTriangleII.getRow(3));
	}
}
