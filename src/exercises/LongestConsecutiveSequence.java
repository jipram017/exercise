package exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
	// Return the longest range
	// Time complexity O(n), Space complexity O(n)
	public static int[] longestConsecutive2(int[] nums) {
		int[] bestRange = new int[2];
        if(nums == null || nums.length == 0){
            return bestRange ;
        }
		Map<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
		for(Integer num : nums) {
			visited.put(num, false);
		}
		
		int longest = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			int left = nums[i]-1, right = nums[i]+1, currentLongest = 0;
			if(visited.get(nums[i])) {
				continue;
			}
			visited.put(nums[i], true);
			while(visited.containsKey(left)) {
				visited.put(left, true);
				currentLongest++; left--;
			}
			while(visited.containsKey(right)) {
				visited.put(right, true);
				currentLongest++; right++;
			}
			if(currentLongest > longest) {
				longest = currentLongest;
				bestRange = new int[] {left+1, right-1};
			}
			
		}
		return bestRange;
	}
	
	// Return only the length of longest range
	// Time complexity O(1), Space complexity O(n)
	public static int longestConsecutive(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		Set<Integer> numSet = new HashSet<Integer>();
		for(Integer num : nums) {
			numSet.add(num);
		}
		
		int longestRange = Integer.MIN_VALUE;
		for(Integer num : numSet) {
			int currentRange = 1, currentNum = num;
			if(!numSet.contains(num-1)) {
				while(numSet.contains(currentNum+1)) {
					currentRange++;
					currentNum++;
				}
				longestRange = Math.max(longestRange, currentRange);
			}
		}
		
		return longestRange;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
		//System.out.println(Arrays.toString(longestConsecutive(nums)));
		System.out.println(longestConsecutive(nums));
	}

}
