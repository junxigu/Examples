package guerer.example;

/*
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		return root == null || (isBalanced(root.left) && isBalanced(root.right)
				&& Math.abs(height(root.left) - height(root.right)) <= 1);
	}

	static int height(TreeNode root) {
		return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
	}
}
