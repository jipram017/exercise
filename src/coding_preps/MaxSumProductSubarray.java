package coding_preps;

public class MaxSumProductSubarray {
	/** LeetCode #53 **/
	// Time complexity O(N)
	// Space complexity O(1)
	public static int maxSubArray(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int max = nums[0], maxSoFar = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			maxSoFar = Math.max(nums[i], nums[i] + maxSoFar);
			max = Math.max(max, maxSoFar);
		}
		
		return max;
	}
	
	/** LeetCode #152 **/
	// Time complexity O(N)
	// Space complexity O(N)
	public static int maxProduct(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int max = nums[0];
		int[] minVals = new int[nums.length];
		int[] maxVals = new int[nums.length];
		minVals[0] = nums[0]; maxVals[0] = nums[0];
		
		for(int i=1; i<nums.length; i++) {
			if(nums[i] >= 0) {
				minVals[i] = Math.min(nums[i], minVals[i-1]*nums[i]);
				maxVals[i] = Math.max(nums[i], maxVals[i-1]*nums[i]);
			} else {
				minVals[i] = Math.min(nums[i], maxVals[i-1]*nums[i]);
				maxVals[i] = Math.max(nums[i], minVals[i-1]*nums[i]);
			}
			max = Math.max(max, maxVals[i]);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
