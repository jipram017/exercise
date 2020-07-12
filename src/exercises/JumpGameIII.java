package exercises;

public class JumpGameIII {
	public static boolean canReachZeroValue(int[] nums, int start) {
		if(nums.length == 0 || nums == null || start < 0 || start >= nums.length) {
			return false;
		} 
		return findZeroValue(nums, start, new boolean[nums.length], nums.length);
	}
	
	public static boolean findZeroValue(int[]nums, int start, boolean[] visited, int length) {
		if(start < 0 || start >= length) {
			return false;
		}
		if(visited[start]) {
			return false;
		}
		if(nums[start] == 0) {
			return true;
		} else {
			visited[start] = true;
			return findZeroValue(nums, start+nums[start], visited, nums.length) ||
				   findZeroValue(nums, start-nums[start], visited, nums.length);
		}	
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {3,0,2,1,2};
		System.out.println(canReachZeroValue(array,2));
		
		array = new int[] {4,2,3,0,3,1,2};
		System.out.println(canReachZeroValue(array,5));
		
		array = new int[] {4,2,3,0,3,1,2};
		System.out.println(canReachZeroValue(array,3));
	}
}
