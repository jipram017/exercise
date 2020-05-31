package exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {
	
	// Time complexity O(n!*n)
	// Space complexity O(n!*n)
    public static List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        permutationsHelper(0, nums, permutations);
        return permutations;       
    }
    
    private static void permutationsHelper(int index, int[] nums, List<List<Integer>> permutations){
    	if(index == nums.length-1) {
    		List<Integer> l = new ArrayList<Integer>();
    		for(Integer num : nums) {
    			l.add(num);
    		}
    		permutations.add(l);
    		return;
    	}
    	
    	HashSet<Integer> set = new HashSet<Integer>();
    	for(int i=index; i<nums.length; i++) {
    		if(set.contains(nums[i])) {
    			continue;
    		}
    		set.add(nums[i]);		
    		swap(nums, index, i);
    		permutationsHelper(index+1, nums, permutations);
    		swap(nums, index, i);
    	}
    }
    
    private static void swap(int[] nums, int a, int b) {
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
