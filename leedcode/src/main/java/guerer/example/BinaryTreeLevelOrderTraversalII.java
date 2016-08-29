package guerer.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

 */
public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		List<TreeNode> level = new LinkedList<TreeNode>();
		if (root != null) {
			level.add(root);
		}
		while (level.size() > 0) {
			List<Integer> list = new ArrayList<Integer>();
			List<TreeNode> tmp = new LinkedList<TreeNode>();
			for(TreeNode n : level) {
				if(n.left != null) {
					tmp.add(n.left);
				}
				if(n.right != null) {
					tmp.add(n.right);
				}
				list.add(n.val);
			}
			level = tmp;
			result.addFirst(list);
		}
		return result;
	}
}
