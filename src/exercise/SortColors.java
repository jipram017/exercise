package exercise;

public class SortColors {
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
