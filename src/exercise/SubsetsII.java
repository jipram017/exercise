package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	if(nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<List<Integer>> prev = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
        	if(i == 0 || nums[i] != nums[i-1] || prev.size() == 0) {
        		prev = new ArrayList<List<Integer>>();
        		for(List<Integer> rst : result) {
        			prev.add(new ArrayList<Integer>(rst));
        		}
        	}
        	
        	for(List<Integer> temp : prev) {
        		temp.add(nums[i]);
        	}
        	
        	if(i == 0 || nums[i] != nums[i-1]) {
        		List<Integer> singleNum = new ArrayList<Integer>();
        		singleNum.add(nums[i]);
        		prev.add(singleNum);
        	}
        	
        	for(List<Integer> temp : prev) {
        		result.add(new ArrayList<Integer>(temp));
        	}
        }
        
        result.add(0, new ArrayList<Integer>());
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
