package coding_preps;

/** LeetCode #238 **/
public class ProductExceptSelf {
	// Time complexity O(N)
	// Space complexity O(1) --> does not count output array's size
	public static int[] productExceptSelf(int[] nums) {
		if(nums==null || nums.length==0) return nums;	
		int[] output = new int[nums.length];
		output[0] = 1; 
		for(int i=1; i<nums.length; i++) {
			output[i] = nums[i-1]*output[i-1];
		}
		
		int res = 1;
		for(int j=nums.length-2; j>=0; j--) {
			res *= nums[j+1];
			output[j] *= res;
		}
		
		return output; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
