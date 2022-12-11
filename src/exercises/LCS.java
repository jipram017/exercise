package exercises;

public class LCS {
	// Time complexity: O(m*n) where m=length of text1 and n=length of text2
	// Space complexity: O(m*n) where m=length of text1 and n=length of text2
	public static int nonOptimizedLCS(String text1, String text2) {
		if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
			return 0;
		}
		
		int m = text1.length();
		int n = text2.length();
		int[][] dp = new int[m+1][n+1];
		
		for(int i = m; i >= 0; i--) {
			for(int j = n; j >= 0; j--) {
				if(i==m || j==n) {
					dp[i][j] = 0;
				}
				else if(text1.charAt(i) == text2.charAt(j)) {
					dp[i][j] = 1 + dp[i+1][j+1];
				} else {
					dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
				}
			}
		}
		
		return dp[0][0];
	}
	
	// Time complexity: O(m*n) where m=length of text1 and n=length of text2
	// Space complexity: O(min(m,n)) where m=length of text1 and n=length of text2
	public static void optimizedLCS(String text1, String text2) {
		if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
			return;
		}
		
		int m = text1.length();
		int n = text2.length();
		int flag = 0;
		int[][] dp = new int[2][n+1];
		
		for(int i = m; i >= 0; i--) {
			for(int j = n; j >= 0; j--) {
				if(i==m || j==n) {
					dp[flag][j] = 0;
				}
				else if(text1.charAt(i) == text2.charAt(j)) {
					dp[flag][j] = 1 + dp[flag^1][j+1];
				}
                else {
					dp[flag][j] = Math.max(dp[flag][j+1], dp[flag^1][j]);
				}
			}
            flag ^= 1;
		}

		// Printing longest common subsequence
		int index = dp[m][n];
		
		char[] lcs_string = new char[index+1];
		lcs_string[index] = '\u0000';
		
		int i = m, j = n;
		while(i>0 && j>0) {
			if(text1.charAt(i-1) == text2.charAt(j-1)) {
				lcs_string[index-1] = text1.charAt(i-1);
				i--; j--; index--;
			}
			else if(dp[flag^1][j] > dp[flag][j-1]){
				i--;
			}
			else {
				j--;
			}
		}
		
		for (char x : lcs_string) {
			System.out.print(lcs_string[x]);
		}
	}
	 
	
	public static void main(String[] args) {
		String array1 = "AGGTAB";
		String array2 = "GXTXAYB";
		//String[][] result = LCS(array1, array2);
		//System.out.println(LCS(array1,array2));
		System.out.println(nonOptimizedLCS(array1,array2));
	}

}
