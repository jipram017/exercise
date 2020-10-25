package coding_preps;

/** LeetCode #5 **/
public class LongestPalindromicSubstring {
	// Time complexity O(N*N)
	// Space complexity O(1)
	// where N is length of the input string
	public static String longestPalindrome(String s) {
		if(s.isEmpty()) return s;
		int[] result = new int[] {0,1};
		for(int i=1; i<s.length(); i++) {
			int[] s1 = getLongestPalindrome(s, i-1, i+1);
			int[] s2 = getLongestPalindrome(s, i-1, i);
			int[] cur = s1[1]-s1[0] > s2[1]-s2[0]? s1 : s2;
			if(cur[1]-cur[0] > result[1]-result[0]) {
				result = cur;
			}
		}
		
		return s.substring(result[0], result[1]);
	}
	
	public static int[] getLongestPalindrome(String s, int start, int end) {
		while(start >= 0 && end < s.length()) {
			if(s.charAt(start) != s.charAt(end)) break;
			start--; end++;
		}
		return new int[] {start+1, end};
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
