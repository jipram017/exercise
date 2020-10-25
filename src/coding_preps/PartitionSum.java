package coding_preps;

/** LeetCode #416 **/
public class PartitionSum {
	// Time complexity O(m*n)
	// Space complexity O(m)
	// where m is target sum and n is number of inputs
	public static boolean canPartition(int[] nums) {
		if(nums==null || nums.length == 0) return false;
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		if(sum % 2 != 0) return false;
		sum /= 2;
		boolean[] dp = new boolean[sum+1];
		dp[0] = true;
		
		for(int num : nums) {
			for(int j=sum; j>= num; j--) {
				dp[j] = dp[j] | dp[j-num];
			}
		}
		
		return dp[sum];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
