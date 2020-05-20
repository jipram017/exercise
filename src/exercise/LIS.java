package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time complexity O(n log n)
// Space complexity O(n)
public class LIS {
    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        List<Integer> LIS = new ArrayList<>();
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        
        for(int k = 0; k < nums.length; k++) {
        	if(LIS.size() == 0 || nums[k] > LIS.get(LIS.size()-1)) {
        		LIS.add(nums[k]);
        	} else {
        		int i = 0;
        		int j = LIS.size()-1;
        		while(i<j) {
        			int mid = (i+j)/2;
        			if(nums[k] <= LIS.get(mid)) {
        				j = mid;
        			} else {
        				i = mid+1;
        			}
        		}
        		LIS.set(j, nums[k]);
        	}
        }
        
        return LIS.size();
    }
	public static void main(String[] args) {
		//int[] list = new int[] {10,9,2,5,3,7,101,18};
		int[] list = new int[] {1,2,4,3,5,4,7,2};
		System.out.println("result: " + lengthOfLIS(list));
	}

}
