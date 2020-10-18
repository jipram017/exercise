package coding_preps;

/** LeetCode #75 **/
public class SortColors {
	// Time complexity O(N)
	// Space complexity O(1)
	// where N is the number of input numbers
	public static void sortColors(int[] nums) {
		if(nums==null || nums.length == 0) return;
		int i=0, j=nums.length-1, mid=0, temp=0;
		while(mid <=j) {
			switch(nums[mid]) {
				case 2 :
					temp = nums[mid];
					nums[mid] = nums[j];
					nums[j] = temp;
					j--;
					break;
				case 0 :
					temp = nums[mid];
					nums[mid] = nums[i];
					nums[i] = temp;
					i++; mid++;
					break;
				case 1 :
					mid++;
					break;
				default :
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
