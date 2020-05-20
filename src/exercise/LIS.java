package exercise;

import java.util.ArrayList;
import java.util.List;

// Time complexity O(n log n)
// Space complexity O(n)
public class LIS {
    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        List<Integer> LIS = new ArrayList<>();
        
        for(int num : nums) {
        	if(LIS.size() == 0 || num > LIS.get(LIS.size()-1)) {
        		LIS.add(num);
        	} else {
        		int i = 0;
        		int j = LIS.size()-1;
        		while(i<j) {
        			int mid = (i+j)/2;
        			if(num <= LIS.get(mid)) {
        				j = mid;
        			} else {
        				i = mid+1;
        			}
        		}
        		LIS.set(j, num);
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
