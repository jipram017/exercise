package exercise;

import java.util.Arrays;

public class KPartitionEqualSum {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
    	if(k == 1) return true;
    	if(k > nums.length)return false;
    	int sum  = 0;
    	for(int num : nums) {
    		sum += num;
    	}
    	if(sum% k != 0) return false;
    	sum = sum / k;
    
    	int[] bucket = new int[k];
    	Arrays.sort(nums);
    	return canPartitionKSubsets(nums, nums.length-1, sum, bucket);
    }
    
    
    public static boolean canPartitionKSubsets(int[] nums, int index, int sum, int[] bucket) {
    	if(index == -1) return true;
    	for(int i = 0; i < bucket.length; i++) {
    		int temp = bucket[i] + nums[index];
    		if(temp <= sum) {
    			bucket[i] += nums[index];
    			if(canPartitionKSubsets(nums, index-1, sum, bucket)) return true;
    			bucket[i] -= nums[index];
    		}
    		if(bucket[i] == 0) break;
    	}
    	
    	return false;
    }
    
	public static void main(String[] args) {
		int[] nums = {10,10,10,7,7,7,7,7,7,6,6,6};
		int k  =3;
		boolean result = canPartitionKSubsets(nums, k);
		System.out.println(result);
	}

}
