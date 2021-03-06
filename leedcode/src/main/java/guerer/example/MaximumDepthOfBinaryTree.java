package guerer.example;

/*
 * Given a binary tree, find its maximum depth.

 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		return root == null ? 0 : (Math.max(maxDepth(root.left),
			maxDepth(root.right))) + 1;
	}
}
