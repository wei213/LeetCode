package algorithms.problems.tree;

public class FlattenBinaryTree {
	/**
	 * @problem LeetCode114. Flatten Binary Tree to Linked List
	 * @description Given a binary tree, flatten it to a linked list in-place.
	 * @author WEI
	 *
	 */
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){ val = x;}
	}
	
	@SuppressWarnings("unused")
	private static void flattenBinaryTree(TreeNode root) {
		if(root == null) return ;
		flatten(root, null);
	}
	
	private static TreeNode flatten(TreeNode node, TreeNode pre) {
		if(node == null) return pre;
		pre = flatten(node.right, pre);
		pre = flatten(node.left, pre);
		node.right = pre;
		node.left = null;
		pre = node;
		return pre;
	}
	
	public static void main(String[] args) {
		// [1,2,5,3,4,null,6]
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = null;
		root.right.right = new TreeNode(6);
		
		flatten(root, null);
		while( root != null) {
			System.out.print(root.val + " ");
			root = root.right;
		}
	}
}
