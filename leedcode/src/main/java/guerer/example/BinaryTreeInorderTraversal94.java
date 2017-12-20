package guerer.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> r = new ArrayList<>();
		if (root == null)
			return r;

		Stack<TreeNode> s = new Stack<>();
		TreeNode n = root;
		do {
			while (n != null) {
				s.push(n);
				n = n.left;
			}
			if (!s.isEmpty()) {
				n = s.pop();
				r.add(n.val);
				n = n.right;
			}
		} while (!s.isEmpty());
		return r;
	}
}
