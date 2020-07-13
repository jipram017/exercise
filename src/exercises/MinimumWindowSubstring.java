package exercises;

import java.util.HashMap;

public class MinimumWindowSubstring {
	
	// Time complexity O(S+T), space complexity O(S+T)
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> goal = new HashMap<Character, Integer>();
        int goalSize = t.length();
        String result = "";
        int minLen = Integer.MAX_VALUE;
        
        // target dictionary
        for(int k=0; k<t.length(); k++) {
        	goal.put(t.charAt(k), goal.getOrDefault(t.charAt(k), 0)+1);
        }
        
        int i=0;
        int total=0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int j=0; j<s.length(); j++) {
        	char c = s.charAt(j);
        	if(!goal.containsKey(c)) {
        		continue;
        	}
        	
        	// If c is character in the goal and count < goal, increase the total
        	int count = map.getOrDefault(c, 0);
        	if(count < goal.get(c)) {
        		total++;
        	}
        	
        	map.put(c, count+1);
        	
        	// When total reaches goalSize, trim for left until no more character can be trimmed
        	if(total==goalSize) {
        		while(!goal.containsKey(s.charAt(i)) || map.get(s.charAt(i)) > goal.get(s.charAt(i))){
        			char ch = s.charAt(i);
        			if(goal.containsKey(ch) && map.get(ch) > goal.get(ch)) {
        				map.put(ch, map.get(ch)-1);
        			}
        			i++;
        		}
        		
        		if(minLen>j-i+1) {
        			minLen = j-i+1;
        			result = s.substring(i, j+1);
        		}
        	}
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
