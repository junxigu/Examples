package guerer.example;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 */

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		List<TreeNode> level = new ArrayList<TreeNode>();
		level.add(root);
		while (level.size() != 0) {
			List<Integer> tmp = new ArrayList<Integer>();
			List<TreeNode> oldLevel = level;
			level = new ArrayList<TreeNode>();
			for(TreeNode n : oldLevel) {
				if(n.left != null) {
					level.add(n.left);
				}
				if(n.right != null) {
					level.add(n.right);
				}
				tmp.add(n.val);
			}
			result.add(tmp);
		}
		return result;
	}
}
