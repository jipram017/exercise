package exercises;

public class FindDuplicate {
	
    // Time complexity O(N), space complexity O(1)
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        do {
        	slow = nums[slow];
        	fast = nums[nums[fast]];
        } while (slow != fast);
        
        int found = 0;
        while(found != slow) {
        	found = nums[found];
        	slow = nums[slow];
        }
        
        return found;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
