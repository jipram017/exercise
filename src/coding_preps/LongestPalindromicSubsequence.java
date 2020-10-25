package coding_preps;

/** LeetCode #516 **/
public class LongestPalindromicSubsequence {
	// Time complexity O(N*N)
	// Space complexity O(N*N)
	// where N is length of the input string
	public static int longestPalindromeSubseq(String s) {
		if(s.isEmpty()) return 0;
		int[][]LP = new int[s.length()+1][s.length()+1];
		for(int i=0; i<s.length(); i++) {
			LP[i][i] = 1;
		}
		for(int sublen = 2; sublen <= s.length(); sublen++) {
			for(int i=0; i<s.length()-sublen+1; i++) {
				int j = i+sublen-1;
				if(s.charAt(i) == s.charAt(j) && sublen==2) {
					LP[i][j] = 2;
				}
				else if(s.charAt(i) == s.charAt(j)) {
					LP[i][j] = LP[i+1][j-1] + 2;
				}
				else {
					LP[i][j] = Math.max(LP[i+1][j], LP[i][j-1]);
				}
			}
		}

		return LP[0][s.length()-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbbab";
		System.out.println(longestPalindromeSubseq(s));
	}

}
