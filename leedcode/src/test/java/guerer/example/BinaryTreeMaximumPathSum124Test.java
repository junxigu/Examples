package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeMaximumPathSum124Test {

	@Test
	public void testMaxPathSum() {
		BinaryTreeMaximumPathSum124 bmp = new BinaryTreeMaximumPathSum124();
		assertEquals(1, bmp.maxPathSum(new BinaryTreeMaximumPathSum124.TreeNode(1)));
		
		BinaryTreeMaximumPathSum124.TreeNode root = new BinaryTreeMaximumPathSum124.TreeNode(1);
		root.left = new BinaryTreeMaximumPathSum124.TreeNode(2);
		root.right = new BinaryTreeMaximumPathSum124.TreeNode(3);
		assertEquals(6, bmp.maxPathSum(root));
		
		root = new BinaryTreeMaximumPathSum124.TreeNode(1);
		root.left = new BinaryTreeMaximumPathSum124.TreeNode(-2);
		root.right = new BinaryTreeMaximumPathSum124.TreeNode(-3);
		assertEquals(1, bmp.maxPathSum(root));
		
		root = new BinaryTreeMaximumPathSum124.TreeNode(-1);
		root.left = new BinaryTreeMaximumPathSum124.TreeNode(2);
		root.right = new BinaryTreeMaximumPathSum124.TreeNode(-3);
		assertEquals(2, bmp.maxPathSum(root));
		
		root = new BinaryTreeMaximumPathSum124.TreeNode(-1);
		root.left = new BinaryTreeMaximumPathSum124.TreeNode(-1);
		root.left.left = new BinaryTreeMaximumPathSum124.TreeNode(6);
		root.right = new BinaryTreeMaximumPathSum124.TreeNode(3);
		assertEquals(7, bmp.maxPathSum(root));
		
		root = new BinaryTreeMaximumPathSum124.TreeNode(-3);
		assertEquals(-3, bmp.maxPathSum(root));
	}

}
