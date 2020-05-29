package exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
	// Longest Substring without Any Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int j = 0, i = 0, longest = 0;
        Set<Character> set = new HashSet<>();
        while(i < s.length() && j < s.length()) {
        	if(!set.contains(s.charAt(i))) {
        		set.add(s.charAt(i++));
        		longest = Math.max(longest, i-j);
        	} else {
        		set.remove(s.charAt(j++));
        	}
        }
        return longest;
    }
    
    // Longest Substring with At Most Two Unique Characters
    public static int lengthOfLongestSubstring2(String s) {
        if(s.length() == 0) return 0;
        int max = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
        	if(!map.containsKey(s.charAt(i))) {
        		map.put(s.charAt(i), 1);
        	} else {
        		map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        	}
        	
        	if(map.size() > 2) {
        		max = Math.max(max, i-j);
        		while(map.size() > 2) {
        			int count = map.get(s.charAt(i));
        			if(count == 1) map.remove(s.charAt(i));
        			else map.put(s.charAt(i), map.get(s.charAt(i))-1);
        			j++;
        		}
        	}
        }   
        return max;
    }
    
    // Longest Substring with At Least k Repeating Characters
    public static int lengthOfLongestSubstring3(String s, int k) {
    	if(s.length() == 0) return 0;
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for(int i = 0; i < s.length(); i++) {
    		if(!map.containsKey(s.charAt(i))){
    			map.put(s.charAt(i), 1);
    		} else {
    			map.put(s.charAt(i), map.get(s.charAt(i))+ 1);
    		}
    	}
    	
    	HashSet<Character> charSet = new HashSet<>();
    	for(Character c : map.keySet()) {
    		int count = map.get(c);
    		if(count < k) {
    			charSet.add(c);
    		}
    	}
    	
    	if(charSet.isEmpty()) return s.length();
    	int i = 0, j = 0, max = 0;
    	while(i < s.length()) {
    		char c = s.charAt(i);
    		if(charSet.contains(c)) {
    			if(i!=j) {
    				max = Math.max(max, lengthOfLongestSubstring3(s.substring(j, i), k));
    			}
    			j = i + 1;
    		}
    		i++;
    	}
    	
			if(i!=j) {
				max = Math.max(max, lengthOfLongestSubstring3(s.substring(j, i), k));
			}
    	
    	return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
