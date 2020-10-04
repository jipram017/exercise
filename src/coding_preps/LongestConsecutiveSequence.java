package coding_preps;

import java.util.HashSet;

/** LeetCode #128 **/
public class LongestConsecutiveSequence {
	// Time complexity O(N)
	// Space complexity O(1)
	// where N is size of the input
	
	public static int longestConsecutive(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for(Integer num : nums) {
			set.add(num);
		}
		
		int longest = Integer.MIN_VALUE;
		for(Integer num : set) {
			int currentMax = 1, currentNum = num;
			if(!set.contains(num-1)) {
				while(set.contains(currentNum+1)) {
					currentMax++;
					currentNum++;
				}
				longest = Math.max(currentMax, longest);
			}
		}
		
		return longest;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive(nums));
	}

}
