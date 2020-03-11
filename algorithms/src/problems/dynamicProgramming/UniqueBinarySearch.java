package problems.dynamicProgramming;

import java.util.*;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		val = x;
	}
}

public class UniqueBinarySearch {
	/**
	 * @problem leetcode Unique Binary Search second
	 * @description 
	 * @solution One: recursively building subtrees for a fixed root node.
	 * 			 or consider dynamic programming using G(i) = G(i-1)*G(n-i), notify that Trees need to be 
	 * 			 stored in the list therefore, G(i) can only store and represent left branch, for the G(n-i)
	 * 			 need to deep copy right branch, by adding offset to the value of nodes in left branch.
	 * 			 Two: dynamic programming 
	 * @param n
	 * @return
	 */
	
	private static List<TreeNode> generateTrees(int n) {
		if(n == 0) {
			List<TreeNode> ans = new ArrayList<>();
			return ans;
		}
		return generate(1, n);
	}
	
	private static List<TreeNode> generate(int start, int end) {
		List<TreeNode> ans = new ArrayList<>();
		if(start > end) {
			ans.add(null);
			return ans;
		}
		if(start == end) {
			ans.add(new TreeNode(end));
			return ans;
		}
		List<TreeNode> left, right;
		for(int i=start; i<=end; i++) {
			left = generate(start, i-1);
			right = generate(i+1, end);
			for(TreeNode l:left) {
				for(TreeNode r:right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					ans.add(root);
				}
			}
		}
		return ans;
	}
	
	private static void printTree(TreeNode node) {
		if(node == null) {
			System.out.print("null ");
			return;
		}
		System.out.print(node.val + " ");
		printTree(node.left);
		printTree(node.right);
		return;
	}
	
	private static TreeNode deepCopy(TreeNode node, int offset) {
		if(node == null) return null;
		TreeNode root = new TreeNode(node.val + offset);
		root.left = deepCopy(node.left, offset);
		root.right = deepCopy(node.right, offset);
		return node;
		
	}
	private static List<TreeNode> dp(int n) {
		List<TreeNode>[] ans = new List[n+1];
		if(n == 0) return ans[0];
		ans[0] = new ArrayList<TreeNode>();
		ans[0].add(null);
		
		for(int i=1; i<=n; i++) {
			ans[i] = new ArrayList<TreeNode>();
			for(int j=0; j<i; j++) {
				for(TreeNode l: ans[j]) { // nodes one the left branch
					for(TreeNode r:ans[i-j-1]) { // number of nodes left on the right branch
						TreeNode root = new TreeNode(j+1);
						root.left = l;
						root.right = deepCopy(r, j+1);// j+1 is the offset
						ans[i].add(root);
					}
				}
			}
		}
		return ans[n];
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			// solution one: recursive
			int n = sc.nextInt();
			List<TreeNode> ans = dp(n);
//			List<TreeNode> ans = generateTrees(n);
			for(TreeNode root:ans) {
				printTree(root);
				System.out.println();
			}
			
		}
	}
}
