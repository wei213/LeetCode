package algorithms.problems.bfs;
import java.util.*;
public class LeastNumOfOperations {
	private static class Node{
		int num;
		int depth;
		public Node(int num, int depth) {
			this.num = num;
			this.depth = depth;
		}
	}
	public static int leastNumOfOperations(int a, int b) {
		if(a == b) return 0;
		LinkedList<Node> queue = new LinkedList<>();
		Node node = new Node(a, 0);
		queue.add(node);
		while(!queue.isEmpty()) {
			Node temp = queue.remove();
			if(temp.num == b) return temp.depth;
			queue.add(new Node(temp.num-1, temp.depth+1));
			queue.add(new Node(temp.num*2, temp.depth+1));
		}
		return -1;
		
	}
	public static void main(String[] args) {
		int a = 3;
		int b = 8;
		System.out.println(leastNumOfOperations(a, 8));
	}
}
