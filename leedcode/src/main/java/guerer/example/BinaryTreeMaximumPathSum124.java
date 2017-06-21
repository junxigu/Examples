package guerer.example;

/*
 *  Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3

Return 6. 
 */

public class BinaryTreeMaximumPathSum124 {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	int maxV = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
		maxV = Integer.MIN_VALUE;
		maxPath(root);
		return maxV;
	}

	int maxPath(TreeNode root) {
		if (root == null)
			return 0;
		int lmp = maxPath(root.left);
		int rmp = maxPath(root.right);
		int p = (lmp > 0 ? lmp : 0) + (rmp > 0 ? rmp : 0) + root.val;
		maxV = Math.max(maxV, p);
		return root.val + Math.max(0, Math.max(lmp, rmp));
	}
}
