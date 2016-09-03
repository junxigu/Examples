package guerer.example;

import java.util.ArrayList;
import java.util.List;

/*
 *  Given a binary tree, return all root-to-leaf paths.

 For example, given the following binary tree:

 1
 /   \
 2     3
 \
 5

 All root-to-leaf paths are:

 ["1->2->5", "1->3"]

 */
public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if (root != null) {
			if (root.left == null && root.right == null) {
				result.add(root.val + "");
			} else {
				if (root.left != null) {
					for (String str : binaryTreePaths(root.left)) {
						result.add(root.val + "->" + str);
					}
				}
				if (root.right != null) {
					for (String str : binaryTreePaths(root.right)) {
						result.add(root.val + "->" + str);
					}
				}
			}
		}
		return result;
	}
}
