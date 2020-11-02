package coding_preps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** LeetCode #78 **/
public class Subsets {
	// Time complexity O(2^n * n)
	// Space complexity O(2^n * n)
    public static List<List<Integer>> subsets(int[] nums) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 if(nums==null || nums.length == 0) return result;
		 
		 Arrays.sort(nums);
		 for(int i=0; i<nums.length; i++) {
			 // Copy current result to temp
			 List<List<Integer>> temp = new ArrayList<List<Integer>>();
			 for(List<Integer> b : result) {
				 temp.add(new ArrayList<Integer>(b));
			 }
			 
			 // Add nums[i] to each list in temp
			 for(List<Integer> a : temp) {
				 a.add(nums[i]);
			 }
			 
			 // Add single nums[i] to temp
			 List<Integer> singleNum = new ArrayList<Integer>();
			 singleNum.add(nums[i]);
			 temp.add(singleNum);
			 
			 result.addAll(temp);
		 }
		 
		 result.add(0, new ArrayList<Integer>());
		 return result;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
