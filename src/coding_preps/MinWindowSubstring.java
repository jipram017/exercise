package coding_preps;

import java.util.HashMap;

/** LeetCode #76 **/
public class MinWindowSubstring {
	
	// Time complexity O(S+T), space complexity O(S+T)
    public static String minWindow(String s, String t) {
    	if(s.isEmpty() || s==null) return null;
    	if(t.isEmpty() || t==null) return s;
    	
    	HashMap<Character, Integer> targetMap = new HashMap<Character, Integer>();
    	int targetSize = t.length();
    	int k = 0, total  = 0;
    	int count;
    	int minSize = Integer.MAX_VALUE;
    	String result = "";
    	
    	for(int i=0; i<targetSize; i++) {
    		targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0)+1);
    	}
    	
    	HashMap<Character, Integer> stringMap = new HashMap<Character, Integer>();
    	for(int j=0; j<s.length(); j++) {
    		char ch = s.charAt(j);
    		if(!targetMap.containsKey(ch)) {
    			continue;
    		}
    		
    		count = stringMap.getOrDefault(ch, 0);
    		if(count < targetMap.get(ch)) {
    			total++;
    		}
    		stringMap.put(ch, count+1);
    		
    		// If total equals to target string size, trim from the left
    		if(total == targetSize) {
    			while(!targetMap.containsKey(s.charAt(k)) || stringMap.get(s.charAt(k)) > targetMap.get(s.charAt(k))){
    				if(targetMap.containsKey(s.charAt(k)) && stringMap.get(s.charAt(k)) > targetMap.get(s.charAt(k))) {
    					stringMap.put(s.charAt(k), stringMap.get(s.charAt(k))-1);
    				}
    				k++;
    			}
    			if(minSize > j-k+1) {
    				minSize = j-k+1;
    				result = s.substring(k, j+1);
    			}
    		}
    	}
    	
    	return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(input, t));
	}

}
