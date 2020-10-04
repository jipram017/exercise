package coding_preps;

import java.util.Arrays;

/** LeetCode #300 **/
public class LongestIncreasingSubsequence {
	// Time complexity O(N*N)
	// Space complexity O(N)
	// where N is size of the input nums
	public static int lengthOfLIS(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int currentMax = 1;
		
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<i; j++) {
				if(nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			if(dp[i] > currentMax) {
				currentMax = dp[i];
			}
		}
		
		return currentMax;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(input));
	}

}
