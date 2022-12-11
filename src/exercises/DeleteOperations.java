package exercises;

public class DeleteOperations {
	// Time complexity O(m*n), space complexity O(min(m,n)) where m: length of word1 and n: length of word2
	public static int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		if(m==0 || word1 == null) {
			return n;
		}
		if(n==0 || word2 == null) {
			return m;
		}
		
		int flag = 0;
		
		int[][] lcs = new int[2][n+1];
		for(int i = 0; i <= m; i++) {
			for(int j=0; j <= n; j++) {
				if(i==0 || j==0) {
					lcs[flag][j] = 0;
				}
				else if(word1.charAt(i-1) == word2.charAt(j-1)) {
					lcs[flag][j] = 1 + lcs[flag^1][j-1];
				} else {
					lcs[flag][j] = Math.max(lcs[flag][j-1], lcs[flag^1][j]);
				}
			}
			flag ^= 1;
		}
		
		return (word1.length()+word2.length())- 2*lcs[flag^1][n];
	}

	public static void main(String[] args) {
		String array1 = "AGGTAB";
		String array2 = "GXTXAYB";
		System.out.println(minDistance(array1, array2));
	}

}

