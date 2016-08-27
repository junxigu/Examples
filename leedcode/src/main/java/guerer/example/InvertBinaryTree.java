package guerer.example;

/*
 * Invert a binary tree.

 4
 /   \
 2     7
 / \   / \
 1   3 6   9

 to

 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class InvertBinaryTree {
	public static TreeNode invertTree(TreeNode root) {
		if(root != null) {
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;
			invertTree(root.left);
			invertTree(root.right);
		}
		return root;
	}
}
