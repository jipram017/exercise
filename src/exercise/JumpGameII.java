package exercise;

public class JumpGameII {
	//Time complexity: O(n)
	//Space complexity: O(n)
	public static int minimumJump(int[] nums) {
		if(nums.length <= 1) return 0;
		int next = nums[0], maxReach = nums[0], jump = 1;
		for(int i = 0; i < nums.length; i++) {
			maxReach = Math.max(maxReach, i+nums[i]);
			if(i == next && i != nums.length - 1) {
				next = maxReach;
				if(next == i) return -1;
				jump++;
			}
		}
		return jump;
	}
	
	public static void main(String[] args) {
		int[]array1 = {2,3,1,1,4};
		System.out.println(minimumJump(array1));
	}

}
