package exercise;

public class MaxSubarray {
	
	// Time complexity O(N), space complexity O(1)
    public static int maxSubArray(int[] nums) {
    	if(nums == null|| nums.length == 0)return 0;
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	maxEndingHere = Math.max(nums[i], nums[i] + maxEndingHere);
        	maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
    
    // Time complexity O(N), space complexity O(N)
    public static int maxProduct(int[] nums) {
    	if(nums == null|| nums.length == 0)return 0;
    	int[] minVal = new int[nums.length];
    	int[] maxVal = new int[nums.length];
    	minVal[0] = nums[0]; maxVal[0] = nums[0];
    	int maxSoFar = nums[0];
    	
    	for(int i = 1; i < nums.length; i++) {
    		if(nums[i] > 0) {
    			minVal[i] = Math.min(nums[i], minVal[i-1]*nums[i]);
    			maxVal[i] = Math.max(nums[i], maxVal[i-1]*nums[i]);
    		} else {
    			minVal[i] = Math.min(nums[i], maxVal[i-1]*nums[i]);
    			maxVal[i] = Math.max(nums[i], minVal[i-1]*nums[i]);
    		}
    		maxSoFar = Math.max(maxSoFar, maxVal[i]);
    	}
    	
    	return maxSoFar;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
