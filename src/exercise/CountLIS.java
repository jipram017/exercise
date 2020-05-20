package exercise;

import java.util.Arrays;

public class CountLIS {

	// Time complexity O(n^n)
	// Space complexity O(n)
    public static int findNumberOfLIS(int[] nums) {
    	if(nums == null || nums.length == 0) return 0;
    	int[] LISlength = new int[nums.length];
    	int[] LIScount = new int[nums.length];
    	Arrays.fill(LISlength, 1);
    	Arrays.fill(LIScount, 1);
    	int result = 1, answer = 0;
    	
    	for(int i = 0; i < nums.length; i++) {
    		for(int j = 0; j < i; j++) {
    			if(nums[i] > nums[j]) {
    				if(LISlength[i] <= LISlength[j]) {
    					LISlength[i] = LISlength[j] + 1;
    					LIScount[i] = LIScount[j];
    				} else if(LISlength[j] + 1 == LISlength[i]) {
    					LIScount[i] += LIScount[j];		
    				}
    			}
    		}
    		result = Math.max(result, LISlength[i]);
    	}
    	
    	for(int i = 0; i < nums.length; i++) {
    		if(LISlength[i] == result) {
    			answer += LIScount[i];
    		}
    	}
    	
    	return answer;
    }
    
	public static void main(String[] args) {
		int[] list = new int[] {1,2,4,3,5,4,7,2};
		//int[] list = new int[] {1,2,3};
		System.out.println("result: " + findNumberOfLIS(list));
	}

}
