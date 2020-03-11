package problems.tree;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	class Node {
		private boolean isWord;
		private Map<Character, Node> children;
		public void Node() {
			children = new HashMap<>();
		}
	}
	
	private Node root;
	public void Trie() {
		root = new Node();
	}
	
	public void insert(String word) {
		Node curr = root;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(!curr.children.containsKey(c)) curr.children.put(c, new Node());
			curr = curr.children.get(c);
		}
		if(! curr.isWord) curr.isWord = true;
	}
	
	public boolean search(String word) {
		Node curr = root;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(!curr.children.containsKey(c)) return false;
			curr = curr.children.get(c);
		}
		return curr.isWord;
	}
	
	public boolean startsWith(String prefix) {
		Node curr = root;
		for(int i=0; i<prefix.length(); i++) {
			char c = prefix.charAt(i);
			if(!curr.children.containsKey(c)) return false;
			curr = curr.children.get(c);
		}
		return true;
	}
}
