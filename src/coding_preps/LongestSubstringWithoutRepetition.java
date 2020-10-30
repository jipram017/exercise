package coding_preps;

import java.util.HashMap;
import java.util.Map;

/** LeetCode #3 **/
public class LongestSubstringWithoutRepetition {
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is length of input string
	public static int lengthOfLongestSubstring(String s) {
		if(s==null || s.isEmpty()) return 0;
		int j=0, max = 0;
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(map.containsKey(ch)) {
				j = Math.max(j, 1+map.get(ch));
			}
			max = Math.max(max, i-j+1);
			map.put(ch, i);
		}
		
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
