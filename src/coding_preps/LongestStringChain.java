package coding_preps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** LeetCode #1048 **/
public class LongestStringChain {
	// Time complexity O(N*N)
	// Space complexity O(N)
	// where N is size of words
	public static int longestStrChain(String[] words) {
		if(words == null || words.length== 0) return 0;
		Map<String, Integer> map = new HashMap<>();
		for(String str : words) {
			map.put(str, 1);
		}
		int longest = 1;
		
		Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));
		for(String str : words) {
			for(int i=0; i<str.length(); i++) {
				String sub = str.substring(0,i) + str.substring(i+1);
				if(map.containsKey(sub)) {
					if(map.get(sub) + 1 > map.get(str)) {
						map.put(str, map.get(sub) + 1);
						longest = Math.max(longest, map.get(str));
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
