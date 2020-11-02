package coding_preps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** LeetCode #90 **/
public class SubsetsII {
	
	// Time complexity O(2^n * n)
	// Space complexity O(2^n * n)
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		if(nums==null || nums.length==0) return new ArrayList<List<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<List<Integer>> prev = new ArrayList<List<Integer>>();
		
        Arrays.sort(nums);
		for(int i=0; i<nums.length; i++) {
			if(i==0 || nums[i] != nums[i-1] || prev.size() == 0) {
				prev = new ArrayList<List<Integer>>();
				for(List<Integer> l : result) {
					prev.add(new ArrayList<Integer>(l));
				}
			}
			
			// Add nums[i] into each element in  prev
			for(List<Integer> l : prev) {
				l.add(nums[i]);
			}
			
			// Add nums[i] as single element only if nums[i] != nums[i+1]
			if(i == 0 || nums[i] != nums[i-1]) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(nums[i]);
				prev.add(temp);
			}
			
			for(List<Integer> l : prev) {
				result.add(new ArrayList<Integer>(l));
			}
		}
		
		result.add(0, new ArrayList<Integer>());
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
