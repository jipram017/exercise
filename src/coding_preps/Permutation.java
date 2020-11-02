package coding_preps;

import java.util.ArrayList;
import java.util.List;

/** LeetCode #46 **/
public class Permutation {
	// Time complexity O(N *N!)
	// Space complexity O(N *N!)
	// where N is length of nums
	public static List<List<Integer>> permute(int[] nums) {
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
		
		for(int i = index; i<nums.length; i++) {
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
		int[] a = new int[] {1,2,3};
		List<List<Integer>> res = permute(a);
		for(List<Integer> list : res) {
			for(Integer num : list) {
				System.out.print(num);
			}
			System.out.println();
		}
	}

}
