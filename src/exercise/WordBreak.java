package exercise;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
	// Time complexity O(n^2)
	// Space complexity O(n) where n =  size of wordDict
    public static boolean wordBreak(String s, List<String> wordDict) {
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
        
        return pos[s.length()];
    }
    
    public static void main(String[] args) {
    	String s = "leetcode";
    	String[] wordDict = new String[] {"leet", "code"};
    	boolean result = wordBreak(s, Arrays.asList(wordDict));
    	System.out.println(result);
    }
}
