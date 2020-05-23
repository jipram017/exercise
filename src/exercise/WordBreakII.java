package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreakII {
	// Time complexity O(n^2)
	// Space complexity O(n) where n =  size of wordDict
    public static List<String> wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return new ArrayList<String>();
        if(wordDict.isEmpty()) return new ArrayList<String>();
		ArrayList<String>[] pos = new ArrayList[s.length() + 1];
        pos[0] = new ArrayList<String>();
        
        for(int i = 0; i < s.length(); i++) {
        	if(pos[i] != null) {
        		for(int j = i+1; j <= s.length(); j++) {
        			String sub = s.substring(i,j);
        			if(wordDict.contains(sub)) {
        				if(pos[j] == null) {
        					ArrayList<String> list = new ArrayList<String>();
        					list.add(sub);
        					pos[j] = list;
        				} else {
        					pos[j].add(sub);
        				}
        			}
        		}
        	}
        }
        
        if(pos[s.length()] == null) {
        	return new ArrayList<String>();
        }
        ArrayList<String> result = new ArrayList<String>();
        dfs(pos, result, "", s.length());
        return result;
	}
    
    public static void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int slen) {
    	if(slen == 0) {
    		result.add(curr.trim());
    		return;
    	}
    	
    	for(String s : pos[slen]) {
    		String combined = s + " " + curr;
    		dfs(pos, result, combined, slen-s.length());
    	}
    }

	public static void main(String[] args) {
		String s = "catsanddog";
	    List<String> wordDict = new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
	    List<String> result = wordBreak(s, wordDict);
	    for(String str : result) {
	    	System.out.println(str);
	    }
	}

}
