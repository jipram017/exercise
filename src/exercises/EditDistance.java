package exercises;

public class EditDistance {
	// Time complexity O(m*n), Space complexity O(m*n)
	public int minDistance(String word1, String word2) {
		 int m = word1.length();
		 int n = word2.length();
		 int[][] dp = new int[m+1][n+1];
		 
		 for(int i=0; i<=m; i++) {
			 for(int j=0; j<=n; j++) {
		     
				 if(i==0 || j==0){
		        	 dp[i][j]= i==0? j : i;
	             }
		         
		         else if(word1.charAt(i-1) == word2.charAt(j-1)) {
					 dp[i][j] = dp[i-1][j-1];
				 }
				 
				 else {
					 dp[i][j] = 1+Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
				 }
			 }
		 }
		 
		 return dp[m][n];
	}	
	// Time complexity O(m*n), Space complexity O(min(m,n))
	public int optimizedMinDistance(String word1, String word2) {
		 int m = word1.length();
		 int n = word2.length();
		 
		 int[][] dp = new int[2][n+1];
		 int flag = 0;
		 
		 for(int i=0; i<=m; i++) {
			 for(int j=0; j<=n; j++) {
		         if(i==0 || j==0){
		        	 dp[flag][j]= i==0? j : i;
	             }
		         
		         else if(word1.charAt(i-1) == word2.charAt(j-1)) {
					 dp[flag][j] = dp[flag^1][j-1];
				 }
				 
				 else {
					 dp[flag][j] = 1+Math.min(dp[flag][j-1], Math.min(dp[flag^1][j], dp[flag^1][j-1]));
				 }
			 }
			 
			 flag ^= 1;
		 }
		 
		 return dp[flag^1][n];
	}
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
