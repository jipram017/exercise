package coding_preps;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AutoComplete {
	public static class TrieNode{
		HashMap<Integer, TrieNode> map;
		boolean isLeaf;
		List<String> top;
		public TrieNode() {
			map = new HashMap<Integer, TrieNode>();
			isLeaf = false;
			top = new LinkedList<String>();
		}
	}
	
	public static class Trie {
		TrieNode root;
		public Trie() {
			root = new TrieNode();
		}
		
		/** Insert a word into the Trie **/
		public void insert(String word) {
			TrieNode p = root;
			for(int i=0; i<word.length(); i++) {
				int ch = word.charAt(i)-'a';
				if(!p.map.containsKey(ch)) {
					TrieNode node = new TrieNode();
					p.map.put(ch, node);
				}
				
				if(i==word.length()-1) {
					p.isLeaf = true;
				}
				p.map.get(ch).top.add(word);
				p = p.map.get(ch);
			}
		}
		
		/** Search if a given prefix is in the Trie **/
		public TrieNode search(String word) {
			TrieNode p = root;
			for(int i=0; i<word.length(); i++) {
				int ch = word.charAt(i)-'a';
				if(!p.map.containsKey(ch)) {
					return null;
				}
				p = p.map.get(ch);
			}
			if(p==root) return null;
			p = root;
			return p;
		}
	}
	
	Trie trie = new Trie();
	HashMap<String, Integer> counts = new HashMap<String, Integer>();
	String currentString = "";
	
	/** Constructor of our AutoComplete System */
	public AutoComplete(String[] sentences, int[] times) {
		for(int i=0; i<sentences.length; i++) {
			trie.insert(sentences[i]);
			counts.put(sentences[i], times[i]);
		}
	}
	
	public List<String> input(char ch) {
		List<String> suggestion = new LinkedList<String>();
		if(ch != '#') {
			currentString += ch;
			suggestion = getSuggestion(currentString);
		}
		else {
			if(!counts.containsKey(currentString)) {
				trie.insert(currentString);
				counts.put(currentString, 1);
			}
			else {
				counts.put(currentString, counts.get(currentString)+1);
			}
			currentString="";
		}
		
		return suggestion;
	}
	
	public List<String> getSuggestion(String str) {
		List<String> result = new LinkedList<String>();
		TrieNode node = trie.search(str);
		if(node==null) return result;
		
		List<String> topSuggestion = node.top;
		Collections.sort(topSuggestion, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(counts.get(s1) != counts.get(s2)) {
					return counts.get(s2)-counts.get(s1);
				}
				return s1.compareTo(s2);
			}
		});
		
		int added = 0;
		for(String s : topSuggestion) {
			result.add(s);
			added++;
			if(added >= 3) break;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
