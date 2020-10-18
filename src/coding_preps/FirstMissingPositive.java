package coding_preps;

/** LeetCode #41 **/
public class FirstMissingPositive {
	// Time complexity O(N)
	// Space complexity O(1)
	// where N is length of input numbers
	public static int firstMissingPositive(int[] nums) {
		if(nums==null || nums.length==0) return 1;
		int n = nums.length;
		for(int i=0; i<n; i++) {
			if(nums[i] <= 0) nums[i] = n+2;
		}
		for(int i=0; i<n; i++) {
			int val = Math.abs(nums[i]);
			if(val<=n) {
				nums[val-1] = -Math.abs(nums[val-1]);
			}
		}
		for(int i=0; i<n; i++) {
			if(nums[i]>0) return i+1;
		}
		
		return n+1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
