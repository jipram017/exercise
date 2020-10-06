package coding_preps;

import java.util.ArrayList;

/** LeetCode 583 **/
public class DeleteOperations {
	
	// This problem can be approached by using LCS for two strings 
	public static int minDistance(String word1, String word2) {
		int lcs = spaceOptimizedLCS(word1, word2);
		return word1.length() + word2.length() - 2*lcs;
	}
	
	// Time complexity O(m*n) 
	// Space complexity O(min(m,n))
	// where m and n are length of input strings
	public static int spaceOptimizedLCS(String text1, String text2) {
		int m = text1.length(), n = text2.length();
		if(m==0 || n==0) return 0;
		
		int[][] lcs = new int[2][n+1];
		int max_lcs = Integer.MIN_VALUE;
		ArrayList<Character> lcs_string = new ArrayList<Character>();
		
		for(int i=0; i<m+1; i++) {
			int flag = i & 1;
			for(int j=0; j<n+1; j++) {
				if(i==0 || j==0) {
					lcs[flag][j] = 0;
				}
				else {
					if(text1.charAt(i-1) == text2.charAt(j-1)) {
						lcs[flag][j] = lcs[1-flag][j-1] + 1;
						lcs_string.add(text1.charAt(i-1));
					}
					else {
						lcs[flag][j] = Math.max(lcs[1-flag][j], lcs[flag][j-1]);
					}
				}
				
				max_lcs = Math.max(max_lcs, lcs[flag][j]);
			}
		}
		
		return max_lcs;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
