package exercise;

public class LongestPalindrome {
	public static String longestPalindrome(String s) {
		if(s.isEmpty()) return s;
		int[] longest = new int[] {0,1};
		for(int i = 1; i < s.length(); i++){
			int[] odd = longestPalindrome(s, i-1, i+1);
			int[] even = longestPalindrome(s, i, i-1);
			int[] current = odd[1]-odd[0] > even[1]-even[0] ? odd : even;
			if(current[1]-current[0] > longest[1] - longest[0]) {
				longest = current;
			}
		}
		return s.substring(longest[0], longest[1]);
	}
	
	public static int[] longestPalindrome(String s, int start, int end) {
		while(start >= 0 && end < s.length()) {
			if(s.charAt(start) != s.charAt(end)) break;
			start--; end++;
		}
		return new int[] {++start, end};
	}
	public static void main(String[] args) {
		String s1 = "abaxyzzyxf";
		String s2 = "bbbab";
		String r = longestPalindrome(s2);
		System.out.println(r);
	}

}
