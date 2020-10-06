package coding_preps;

import java.util.ArrayList;
import java.util.Arrays;

/** LeetCode #1143 **/
public class LongestCommonSubsequence {
	// Time complexity O(m*n) 
	// Space complexity O(m*n)
	// where m and n are length of input strings
	public static String longestCommonSubsequence(String text1, String text2) {
		int m = text1.length(), n = text2.length();
		if(m==0 || n==0) return "";
		
		int[][] lcs = new int[m+1][n+1];
		int max_lcs = Integer.MIN_VALUE;
		
		for(int i=0; i<m+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i==0 || j==0) {
					lcs[i][j] = 0;
				}
				else {
					if(text1.charAt(i-1) == text2.charAt(j-1)) {
						lcs[i][j] = lcs[i-1][j-1] + 1;
					}
					else {
						lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
					}
				}
				max_lcs = Math.max(max_lcs,  lcs[i][j]);
			}
		}
		
		return buildSequence(m, n, text1, text2, max_lcs, lcs);
	}
	
	
	// Time complexity O(m*n) 
	// Space complexity O(min(m,n))
	// where m and n are length of input strings
	public static String spaceOptimizedLCS(String text1, String text2) {
		int m = text1.length(), n = text2.length();
		if(m==0 || n==0) return "";
		
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
		
		return lcs_string.toString();
	}
	
	public static String buildSequence(int m, int n, String text1, String text2, int max_lcs, int[][] lcs) {
		char[] lcs_string = new char[max_lcs];
		int i=m, j=n;
		while(i > 0 && j > 0) {
			if(text1.charAt(i-1) == text2.charAt(j-1)) {
				lcs_string[max_lcs-1] = text1.charAt(i-1);
				i--; j--; max_lcs--;
			}
			else {
				if(lcs[i][j-1] > lcs[i-1][j]) {
					j--;
				}
				else {
					i--;
				}
			}
		}
		
		return Arrays.toString(lcs_string);
	}
	
	public static void main(String[] args) {
		String text1 = "abcde", text2 = "ace";
		System.out.println(spaceOptimizedLCS(text1, text2));
	}

}
