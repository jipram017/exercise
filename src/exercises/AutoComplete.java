package exercises;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AutoComplete {
	public static class TrieNode {
		boolean isLeaf;
		HashMap<Character, TrieNode> children;
		List<String> top;
		public TrieNode() {
			isLeaf = false;
			children = new HashMap<Character, TrieNode>();
			top = new LinkedList<String>();
		}	
	}
	
	public static class Trie {
		TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		
		/** Insert a word into the Trie */
		public void insert(String word) {
			TrieNode p = root;
			for(int i=0; i<word.length(); i++) {
				HashMap<Character, TrieNode> children = p.children;
				char ch = word.charAt(i);
				if(!children.containsKey(ch)) {
					children.put(ch,  new TrieNode());
				}
				children.get(ch).top.add(word);
				if(i == word.length()-1) {
					p.isLeaf = true;
				}
				p = p.children.get(ch);
			}
		}
		
		/** Search a word from the Trie */
		private TrieNode searchNode(String pre) {
			HashMap<Character, TrieNode> children = root.children;
			TrieNode p = root;
			for(int i = 0; i < pre.length(); i++) {
				if(!children.containsKey(pre.charAt(i))) {
					return null;
				}
				p = children.get(pre.charAt(i));
				children = p.children;
			}
			return p;
		}
	}
		
    HashMap<String, Integer> counts = new HashMap<String, Integer>();
	Trie trie = new Trie();
	String current = "";
		
	/** Constructor of our AutoComplete System */
	public AutoComplete(String[] sentences, int[] times) {
		for(int i=0; i<sentences.length; i++) {
			counts.put(sentences[i], times[i]);
			trie.insert(sentences[i]);
		}
	}
	
	/** Return a list of string suggestion for each input c from the user */
	public List<String> input(char ch){
		List<String> result = new LinkedList<String>();
		if (ch != '#') {
			current += ch;
			result = getSuggestions();
		}
		else {
			if(!counts.containsKey(current)) {
				trie.insert(current);
				counts.put(current, 1);
			}
			else {
				counts.put(current, counts.get(current)+1 );
			}
			current = "";
		}
		return result;
	}
	
	/** Get the string suggestions */
	private List<String> getSuggestions(){
		List<String> result = new LinkedList<String>();
		TrieNode node = trie.searchNode(current);
		if(node == null) return result;
		List<String> top = node.top;
		Collections.sort(top, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(counts.get(s1) != counts.get(s2)) {
					return counts.get(s2) - counts.get(s1);
				}
				return s1.compareTo(s2);
			}
		});
		
		int added = 0;
		for(String s : top) {
			result.add(s);
			added++;
			if(added > 2) {
				break;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
