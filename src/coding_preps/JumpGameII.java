package coding_preps;

/** LeetCode #45 **/
public class JumpGameII {
	// Time complexity O(N) where N is size of the input
	// Space complexity O(1)
	public static int jump(int[] nums) {
        if(nums.length<=1) return 0;
		int minJump = 1;
		int next=nums[0], maxReach=nums[0];
		
		for(int i=0;i<nums.length; i++) {
			maxReach = Math.max(maxReach, i+nums[i]);
			if(i==next && i!=nums.length-1) {
                next=maxReach;
				minJump++;
			}
		}
		
		return minJump;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {2,3,1,1,4};
		System.out.println(jump(input));
	}

}
