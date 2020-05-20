package exercise;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
    	if(nums == null|| nums.length == 0)return null;
        int[] result = new int[nums.length];
        result[nums.length-1] = 1;
        
        for(int i = nums.length-2; i>=0; i--) {
        	result[i] = result[i+1]*nums[i+1];
        }
        
        int left = 1;
        for(int j = 0; j<nums.length; j++) {
        	result[j] = result[j]*left;
        	left = left*nums[j];
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
