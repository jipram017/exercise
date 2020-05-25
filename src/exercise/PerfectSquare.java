package exercise;

import java.util.Arrays;

public class PerfectSquare {
	
	// Time complexity O(n^3/2)
	// Space complexity O(n)
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int squareRoot = (int) Math.sqrt(n);
        
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= squareRoot; j++) {
        		if(i >= j*j) {
        			dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);
        		}
        	}
        }
        
        return dp[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
