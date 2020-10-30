package coding_preps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** LeetCode #395 **/
public class LongestSubstringWithKRepetition {
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is length of input string
	public static int longestSubstring(String s, int k) {
		Map<Character, Integer> count = new HashMap<>();
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(count.containsKey(ch)){
				count.put(ch, count.get(ch) + 1);
			} else {
				count.put(ch, 1);
			}
		}
		
		Set<Character> splitChars = new HashSet<>();
		for(Character ch : count.keySet()) {
			if(count.get(ch) < k) {
				splitChars.add(ch);
			}
		}
		
		if(splitChars.isEmpty()) {
			return s.length();
		}
		
		int max = 0;
		int i=0;
		for(int j=0; j<s.length(); j++) {
			char ch = s.charAt(j);
			if(splitChars.contains(ch)) {
				if(j != i) {
					max = Math.max(max, longestSubstring(s.substring(i, j), k));
				}
				i = j+1;
			}
		}
		
		if(i!=s.length()) {
			max = Math.max(max, longestSubstring(s.substring(i, s.length()), k));
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
