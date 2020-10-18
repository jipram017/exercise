package coding_preps;

/** LeetCode #343 **/
public class IntegerBreak {
	// First approach is by using dynamic programming
	// Time complexity O(n*n), space complexity O(n) 
	public static int integerBreak(int n) {
		if(n==0) return 0;
		int[] dp = new int[n+1];
		dp[0] = 0; dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			for(int j=1; j<i; j++) {
				dp[i] = Math.max(dp[i], Math.max(j*(i-j), dp[j]*(i-j)));
			}
		}
		
		return dp[n];
	}
	
	// Second approach is by using modulo number
	// Time complexity O(1), space complexity O(1)
	public static int integerBreak2(int n) {
		if(n==0) return 0;
		if(n==1 || n==2) return 1;
        if(n==3) return 2;
        
		int result = 0;
		if(n%3 == 0) result = (int) Math.pow(3, n/3);
		else if(n%3 == 2) result = (int) Math.pow(3, n/3)*2;
		else if(n%3 == 1) result = (int) Math.pow(3, (n-4)/3)*4;
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
