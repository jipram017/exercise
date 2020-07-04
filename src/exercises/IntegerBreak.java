package exercises;

public class IntegerBreak {
	
	// Time complexity O(n*n), space complexity O(n)
	public static int integerBreak(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0; dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j < i; j++) {
				dp[i] = Math.max((i-j)*j, Math.max((i-j)*dp[j], dp[i]));
			}
		}
		
		return dp[n];
	}
	
	// Time and space complexity O(1)
	public static int integerBreakWithoutDP(int n) {
		if(n==2) return 1;
		if(n==3) return 2;
		if(n==4) return 4;
		
		if(n%3 == 0) return (int) Math.pow(3, n/3);
		if(n%3 == 2) return (int) Math.pow(3, n/3) * 2;
		if(n%3 == 1) return (int) Math.pow(3, (n-4)/3) * 4;
		
		return -1;
	}
	public static void main(String[] args) {
		int number = 10;
		System.out.println(integerBreakWithoutDP(number));
	}

}
