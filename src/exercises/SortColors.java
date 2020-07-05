package exercises;

public class SortColors {
	
	// Approach 1 using auxiliary space countArray to count how many num 0, 1, and 2
	// Time complexity O(N), space complexity O(1)
	public static void sortColors1(int[] nums) {
		if(nums==null || nums.length<2) {
			return;
		}
		
		int[] countArray = new int[3];
		for(int num : nums) {
			countArray[num]++;
		}
		
		int j=0, k=0;
		while(j<3) {
			if(countArray[j] !=0) {
				nums[k++] = j;
				countArray[j] = countArray[j]-1;
			}
			else {
				j++;
			}
		}
	}
	
	
	// Approach 2 without using any auxiliary space (Deustche National Flag Algorithm)
	// Time complexity O(N), space complexity O(1)
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int i = 0, j = nums.length-1;
        int mid = 0;
        int temp = 0;
        
        while(mid <= j) {
        switch(nums[mid]){
            case 0 :
                temp = nums[i];
                nums[i]  = nums[mid];
                nums[mid] = temp;
                i++; mid++;
                break;
            case 2:
                temp = nums[j];
                nums[j]  = nums[mid];
                nums[mid] = temp;
                j--;
                break;
            case 1:
                mid++;
        }}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
