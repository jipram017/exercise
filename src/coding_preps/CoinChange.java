package coding_preps;

import java.util.Arrays;

public class CoinChange {
	/** LeetCode #322 **/
	public static int coinChange(int[] coins, int amount) {
		if(amount==0 || coins==null || coins.length==0) return -1;
		int[] dp = new int[amount+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for(int i=1; i<=amount; i++) {
			for(int j=0; j<coins.length; j++) {
				if(i >= coins[j] && dp[i-coins[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
				}
			}
		}
		
		return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
	}
	
	/** LeetCode #518 **/
	public static int change(int amount, int[] coins) {
		if(amount==0 || coins==null || coins.length==0) return 0;
		int[] dp = new int[amount+1];
		Arrays.fill(dp, 0);
		dp[0]=1;
		
		for(int i=0; i<coins.length; i++) {
			for(int j=1; j<=amount; j++) {
				if(coins[i] <= j) {
					dp[j] = dp[j] + dp[j-coins[i]];
				}
			}
		}
		
		return dp[amount];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
