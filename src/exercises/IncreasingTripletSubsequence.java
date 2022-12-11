package exercises;

public class IncreasingTripletSubsequence {
	
	// Time complexity O(N), space complexity O(1)
    public static boolean increasingTriplet(int[] nums) {
    	if(nums.length == 0 || nums == null) return false;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MAX_VALUE;
        
        for(int num : nums) {
        	if(num <= minVal) {
        		minVal = num;
        	} else if(num <= maxVal) {
        		maxVal = num;
        	} else {
        		return true;
        	}
        }
        
        return false; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
