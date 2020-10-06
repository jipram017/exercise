package coding_preps;

/** LeetCode #72**/
public class EditOperations {
	
	// Time complexity O(m*n)
	// Space complexity O(min(m,n))
	// where m and n are respective length of input strings
	public static int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		if(m==0) return n;
		if(n==0) return m;
		
		int[][] edit = new int[2][m+1];
		for(int i=0;i<=word1.length();i++) {
			edit[0][i]=i;
		}
		for(int i=1; i<=n; i++) {
			int flag = i & 1;
			for(int j=0; j<=m; j++) {
				if(j==0) edit[flag][j] = i;
				else {
					if(word2.charAt(i-1) == word1.charAt(j-1)) {
						edit[flag][j] = edit[1-flag][j-1];
					}
					else {
						edit[flag][j] = 1+Math.min(edit[flag][j-1], Math.min(edit[1-flag][j], edit[1-flag][j-1]));
					}
				}
			}
		}
		
		return edit[n%2][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1 = "horse", word2 = "ros";
		String word3 = "intention", word4 = "execution";
		System.out.println(minDistance(word3, word4));
	}

}
