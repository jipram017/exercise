package coding_preps;
import java.util.Arrays;

/** LeetCode #698 **/
public class KPartitionEqualSum {
	public static boolean canPartitionKSubsets(int[] nums, int k) {
		if(k==1) return true;
		if(nums==null || nums.length==0) return false;
		if(k>nums.length) return false;
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		if(sum % k != 0) return false;
		sum /= k;
		int[] bucket = new int[k];
		Arrays.sort(nums);
		return canPartitionKSubsets(nums, nums.length-1, sum, bucket);
	}
	
	public static boolean canPartitionKSubsets(int[] nums, int index, int sum, int[] bucket) {
		if(index == -1) return true;
		for(int i=0; i<bucket.length; i++) {
			int temp = bucket[i] + nums[index];
			if(temp <= sum) {
				bucket[i] += nums[index];
				if(canPartitionKSubsets(nums, index-1, sum, bucket)) {
					return true;
				}
				bucket[i] -= nums[index];
			}
			if(bucket[i] == 0) break;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
