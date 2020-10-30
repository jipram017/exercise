package coding_preps;

import java.util.HashMap;
import java.util.Map;

// Time complexity O(N)
// Space complexity O(N)
// where N is length of input string
public class LongestSubstringKDistinct {
	public static String lengthOfLongestSubstringTwoDistinct(String s) {
		if(s==null || s.isEmpty()) return null;
		int max = 0, start = 0;
		int[] res = new int[] {0,0};
		Map<Character, Integer> map =  new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			} else {
				map.put(ch, 1);
			}
			
			if(map.size() > 2) {
				if(i-start > max) {
					max = i-start;
					res = new int[] {start, i};
				}
				
				while(map.size()>2) {
					char ci = s.charAt(start);
					if(map.get(ci) > 1) {
						map.put(ci, map.get(ci)-1);
					}else {
						map.remove(ci);
					}
					start++;
				}
			}
		}
		
		if(s.length()-start > max) {
			max = Math.max(max, s.length()-start);
			res = new int[] {start, s.length()};
		}
		
		return s.substring(res[0], res[1]);
	}
	
	public static String lengthOfLongestSubstringKDistinct(String s, int k) {
		if(s==null || s.isEmpty()) return null;
		int max = 0, start = 0;
		int[] res = new int[] {0,0};
		Map<Character, Integer> map =  new HashMap<Character, Integer>();
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			} else {
				map.put(ch, 1);
			}
			
			if(map.size() <= k) {
				if(i-start > max) {
					max = Math.max(max, i-start);
					res = new int[] {start, i};
				}
				
			} else {
				while(map.size()>k) {
					char ci = s.charAt(start);
					if(map.get(ci) > 1) {
						map.put(ci, map.get(ci)-1);
					}else {
						map.remove(ci);
					}
					start++;
				}
			}
		}
		
		if(s.length()-start > max) {
			max = Math.max(max, s.length()-start);
			res = new int[] {start, s.length()};
		}
		
		return s.substring(res[0], res[1]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcbbbbcccbdddadacb";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s1));
		
		String s2 = "abcadcacacaca";
		System.out.println(lengthOfLongestSubstringKDistinct(s2, 3));
	}

}
