package algorithms.problems.tree;
import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
}

public class LowestCommonAncestor {
	
	// recursive
	private static TreeNode ans;
	private static TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
		ans = null;
		search(root, p, q);
		return ans;
	}
	
	private static boolean search(TreeNode currNode, TreeNode p, TreeNode q) {
		if(currNode == null) return false;
		int left = search(currNode.left, p, q)?1:0;
		int right = search(currNode.right, p, q)?1:0;
		int mid = (currNode == p || currNode == q)?1:0;
		
		if(mid + left + right >= 2) {
			ans = currNode;
		}
		
		return (mid+left+right)>0;
	}
	// iterative
	private static TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> map = new HashMap<>();   // child, parent
        LinkedList<TreeNode> queue = new LinkedList<>(); // used to store nodes in the tree
        map.put(root, null);
        queue.add(root);
        while(!queue.isEmpty()){ // iterate all the nodes in the tree and build up the tree map<child, parent>
            TreeNode node = queue.remove();
            if(node.left != null){
                map.put(node.left, node);
                queue.add(node.left);
            }
            if(node.right != null){
                map.put(node.right, node);
                queue.add(node.right);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        
        while(p != null){
            set.add(p);
            p = map.get(p);
        }
        
        while(!set.contains(q)){
            q = map.get(q);
        }
		return q;
		
	}
	public static void main(String[] args) {
		// Initialise
		TreeNode seven = new TreeNode(7);
		TreeNode four = new TreeNode(4); 
		TreeNode two = new TreeNode(2);
		two.left = seven;
		two.right = four;
		TreeNode six = new TreeNode(6);
		TreeNode five = new TreeNode(5);
		five.left = six;
		five.right = two;
		TreeNode zero = new TreeNode(0);
		TreeNode eight = new TreeNode(8);
		TreeNode one = new TreeNode(1);
		one.left = zero;
		one.right = eight;
		TreeNode three = new TreeNode(3);
		three.left = five;
		three.right = one;
		System.out.println(two.val);
		TreeNode node = lowestCommonAncestorIterative(three, five, four);
		System.out.println(node.val);
		node = lowestCommonAncestorRecursive(three, one, five);
		System.out.println(node.val);
	}
}
