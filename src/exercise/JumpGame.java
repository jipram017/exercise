package exercise;

public class JumpGame {
	//Time complexity: O(n^2)
	//Space complexity: O(n)
	public static boolean canJump(int[] array) {
		boolean[] reachable = new boolean[array.length];
		reachable[0] = true;
		for(int i = 1; i < array.length; i++) {
			for(int j = 0; j < i; j++) {
				if(j+array[j] >= i && reachable[j]) {
					reachable[i] = true;
					break;
				}
			}
		}
		return reachable[array.length-1];
	}

	//Time complexity: O(n)
	//Space complexity: O(n)
	public static boolean canJump2(int[] nums) {
		if(nums.length <= 1) return true;
		if(nums[0] == 0) return false;
		
		int maxReach = nums[0], steps = nums[0];
		boolean jumpable = false;
		for(int i = 0; i < nums.length; i++) {
			if(i == nums.length-1) return true;
			maxReach = Math.max(maxReach, i+nums[i]);
			steps--;
			if(steps == 0) {
				if(i >= maxReach) return false;
				steps = maxReach-i;
			}
		}
		return jumpable;
	}

	public static void main(String[] args) {
		int[]array1 = {3,2,1,0,4};
		System.out.println(canJump2(array1));
	}

}
