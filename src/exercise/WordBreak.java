package exercise;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
	private static class TrieNode{
		TrieNode[] next = new TrieNode[26];
		boolean word;
	}
	
	// Time complexity O(n^2)
	// Space complexity O(n^2) where n =  size of dict
	private static TrieNode buildTrie(List<String> dict) {
		TrieNode root = new TrieNode();
		for (String word : dict) {
			TrieNode node = root;
			for(char c : word.toCharArray()) {
				int i = c - 'a';
				if(node.next[i] == null) node.next[i] = new TrieNode();
				node = node.next[i];
			}
			node.word = true;
		}
		return root;
	}
	
	private static boolean wordBreak(TrieNode root, String s, boolean[] dp) {
		dp[0] = true;
		for(int i = 0; i < s.length(); i++) {
			if(dp[i]) {
				int j=i;
				TrieNode node = root;
				for(; j < s.length(); j++) {
					if(node.word) {
						dp[j] = true;
					}
					int c = s.charAt(j) - 'a';
					node = node.next[c];
					if(node == null) break;
				}
				if(node == null) continue;
				if(node.word)dp[j] = true; 
			}
		}
		return dp[s.length()];
	}
	
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return true;
        if(wordDict.isEmpty()) return false;
        return wordBreak(buildTrie(wordDict), s, new boolean[s.length()+1]);
    }
    
    public static boolean wordBreak2(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return true;
        if(wordDict.isEmpty()) return false;
        boolean[] pos = new boolean[s.length()+1];
        Arrays.fill(pos, false);
        pos[0] = true;
        
        for(int i = 0; i < s.length(); i++) {
        	if(pos[i]) {
        		for(int j = i+1; j <= s.length(); j++) {
        			String sub = s.substring(i,j);
        			if(wordDict.contains(sub)) {
        				pos[j] = true;
        			}
        		}
        	}
        }
        
        return pos[s.length() + 1];
    }
    
    public static void main(String[] args) {
    	String s = "leetcode";
    	String[] wordDict = new String[] {"leet", "code"};
    	boolean result = wordBreak(s, Arrays.asList(wordDict));
    	System.out.println(result);
    }
}
