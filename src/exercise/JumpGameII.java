package exercise;

public class JumpGameII {
	//Time complexity: O(n)
	//Space complexity: O(n)
	public static int minimumJump(int[] nums) {
		if(nums.length <= 1) return 0;
		
		int maxReach = nums[0], steps = nums[0], jump = 0;
		for(int i = 0; i < nums.length; i++) {
			if(i == nums.length-1) break;
			maxReach = Math.max(maxReach, i+nums[i]);
			steps--;
			if(steps == 0) {
				if(i >= maxReach) return -1;
				jump++;
				steps = maxReach-i;
			}
		}
		return jump+1;
	}
	
	public static void main(String[] args) {
		int[]array1 = {2,3,1,1,4};
		System.out.println(minimumJump(array1));
	}

}
