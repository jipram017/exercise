package coding_preps;

/** LeetCode #55**/
public class JumpGame {
	// Time complexity O(N*N) where N is size of the input
	// Space complexity O(N)
	public static boolean canJumpI(int[] nums) {
		boolean[] dp = new boolean[nums.length];
		dp[0] = true;
		
		for(int i=1; i<nums.length; i++) {
			for(int j=0; j<i; j++) {
				if(j+nums[j]>=i && dp[j]) {
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[nums.length-1];
	}
	
	// Time complexity O(N) where N is size of the input
	// Space complexity O(1)
	public static boolean canJump(int[] nums) {
		if(nums.length<=1) return true;
		if(nums[0]==0) return false;
		
		int next=nums[0], maxReach=nums[0];
		for(int i=0;i<nums.length; i++) {
			maxReach = Math.max(maxReach, i+nums[i]);
			if(next >= nums.length-1) return true;
			if(i==next) {
				next=maxReach;
				if(next==i) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[] {2,3,1,1,4};
		int[] nums2 = new int[] {3,2,1,0,4};
		
		System.out.println(canJump(nums1));
		System.out.println(canJump(nums2));
	}

}
