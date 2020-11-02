package coding_preps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** LeetCode #47 **/
public class PermutationII {
	// Time complexity O(N *N!)
	// Space complexity O(N *N!)
	// where N is length of nums
	public static List<List<Integer>> permuteUnique(int[] nums) {
		if(nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
		List<List<Integer>> permutation = new ArrayList<List<Integer>>();
		permutationHelper(permutation, nums, 0);
		return permutation;	
	}
	
	public static void permutationHelper(List<List<Integer>> permutation, int[] nums, int index){
		if(index == nums.length - 1) {
			List<Integer> temp = new ArrayList<Integer>();
			for(int num : nums) {
				temp.add(num);
			}
			permutation.add(temp);
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i = index; i<nums.length; i++) {
			if(set.contains(nums[i])){
				continue;
			}
			
			set.add(nums[i]);
			
			swap(i, index, nums);
			permutationHelper(permutation, nums, index+1);
			swap(i, index, nums);
		}
	}
	
	public static void swap(int i, int index, int[] nums) {
		int temp = nums[index];
		nums[index] = nums[i];
		nums[i] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
