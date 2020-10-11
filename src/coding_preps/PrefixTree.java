package coding_preps;

import java.util.HashMap;

public class PrefixTree {
	// General constructor for a TrieNode
	public static TrieNode root;
	public PrefixTree() {
		root = new TrieNode();
	}
	
	// Definition for a TrieNode
	public static class TrieNode{
		HashMap<Integer, TrieNode> map;
		boolean isLeaf;
		public TrieNode(){
			map = new HashMap<Integer, TrieNode>();
			isLeaf = false;
		}
	}
	
	// A method to insert a complete string into the Trie
	// O(n*n) time, O(n*n) space where n is length of the string
	public static void insert(String word) {
		TrieNode p = root;
		for(int i=0; i<word.length(); i++) {
			int ch = word.charAt(i) - 'a';
			if(!p.map.containsKey(ch)) {
				TrieNode node = new TrieNode();
				p.map.put(ch, node);
			}
		    p = p.map.get(ch);
		}
		
		p.isLeaf = true;
	}
	
	// A method to check if a complete string is in the Trie
	// O(n) time, O(1) space
	public static boolean search(String word) {
		TrieNode p = searchNode(word);
		if(p==null || !p.isLeaf) return false;
		return true;
	}
	
	// A method to check if a given prefix is in the Trie
	// O(n) time, O(1) space
	public static boolean startsWith(String prefix) {
		TrieNode p = searchNode(prefix);
		if(p==null) return false;
		return true;
	}
	
	
	// General method to search if particular string is in the Trie
	// O(n) time, O(1) space
	public static TrieNode searchNode(String word) {
		TrieNode p = root;
		for(int i=0; i<word.length(); i++) {
			int ch = word.charAt(i) - 'a';
			if(!p.map.containsKey(ch)) return null;
			p = p.map.get(ch);
		}
		if(p==root) return null;
		return p;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
