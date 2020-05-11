package exercise;

public class ArrayElementsRemoval {
	// Remove an element from array in place and return its new length
	// Neglect elements beyond the length
    public static int removeElement(int[] nums, int val) {
    	int m = 0;
        for(int a : nums) {
        	if(a != val) {
        		nums[m] = a;
        		m++;
        	}
        }
        return m;
    }

	// Remove duplicated element from array in place and return its new length
    // After removal, each elements are unique
	// Neglect elements beyond the length
    public static int removeDuplicates(int[] nums) {
    	if(nums.length < 2 ) return nums.length;
    	int d = 1;
    	for(int i = 1; i < nums.length; i++) {
    		if(nums[i] != nums[i-1]) {
    			nums[d++] = nums[i];
    		}
    	}
    	return d;
    }
    
	// Remove duplicated element from array in place and return its new length
    // After removal, duplicate elements can appear at most twice
	// Neglect elements beyond the length
    public static int findDuplicate(int[] nums) {
        final int k = 2;
    	int count = 1; int d = 1;
    	for(int i = 1; i < nums.length; i++) {
    		if(nums[i] == nums[i-1]) {
    			if(count < k) {
    				nums[d++] = nums[i];
    			}
    			count++;
    		} else {
    			count = 1;
    			nums[d++] = nums[i];
    		}
    	}   	
    	return d;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
