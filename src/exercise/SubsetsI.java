package exercise;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsI {
    public static List<List<Integer>> subsets(int[] nums) {
    	if(nums == null || nums.length == 0) return new ArrayList<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++) {
        	List<List<Integer>> temp = new ArrayList<List<Integer>>();
        	for(List<Integer> rst : result) {
        		temp.add(new ArrayList<Integer>(rst));
        	}
        	for(List<Integer> tmp : temp) {
        		tmp.add(nums[i]);
        	}
        	ArrayList<Integer> singleNum = new ArrayList<>();
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
