package exercises;

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
		int maxReach = nums[0], next = nums[0];
		for(int i = 0; i < nums.length; i++) {
			maxReach = Math.max(maxReach, i+nums[i]);
            if(next >= nums.length-1) return true;
			if(i == next) {
				next = maxReach;
				if(next == i) return false;
			}
		}
		return true;
	}
	
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
		System.out.println(canJump2(array1));
		System.out.println(minimumJump(array1));
		
	}

}
