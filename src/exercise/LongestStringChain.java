package exercise;

import java.util.Arrays;
import java.util.HashMap;

public class LongestStringChain {
    public static int longestStrChain(String[] words) {
    	if(words == null || words.length == 0) return 1;
        int longest = 1;
        HashMap<String, Integer> strCount = new HashMap<>();
        for(String str : words) {
        	strCount.put(str, 1);
        }
        
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));
        for(String str : words) {
        	for(int i = 0; i < str.length(); i++) {
        		String sub = str.substring(0,i) + str.substring(i+1);
        		if(strCount.containsKey(sub)) {
        			if(1+strCount.get(sub) > strCount.get(str)) {
        				strCount.put(str, 1+strCount.get(sub));
        				longest = Math.max(longest, strCount.get(str));
        			}
        		}
        	}
        }
        
        return longest;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
