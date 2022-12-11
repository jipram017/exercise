package exercises;

public class FirstMissingPositive {
	
    // Time complexity O(N), space complexity O(1)
    public int firstMissingPositive(int[] nums) {
    	int n = nums.length;
    	if(n==0 || nums==null) return 1;
    	
        // Since we are going to exclude zero and negative numbers, we turn it into (n+2), removing from the solution
    	for(int i=0; i<n; i++) {
    		if(nums[i]<=0) {
    			nums[i] = n+2;
    		}
    	}
    	
    	// Scan the arrays, for values in range [1,n] turns it into negative values
    	for(int i=0; i<n; i++) {
    		int value = Math.abs(nums[i]);
    		if(value <= n) {
    			nums[value-1] = -Math.abs(nums[value-1]);
    		}
    	}
    	
    	// Scan the arrays again. If we found a positive number from previous scanning, then the missing number is (i+1)
    	for(int i=0; i<n; i++) {
    		if(nums[i] > 0) {
    			return i+1;
    		}
    	}
    	
    	// If all numbers are negatives, then (n+1) is our missing number
    	return n+1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
