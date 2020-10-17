package coding_preps;

/** LeetCode #11 **/
public class WaterContainer {
	// Time complexity O(N)
	// Space complexity O(1)
	// where N is length of input
	public static int maxArea(int[] height) {
		int i = 0, j = height.length - 1;
		int maxWater = Integer.MIN_VALUE;
		
		while(i<j) {
			maxWater = Math.max((j-i)*Math.min(height[i], height[j]), maxWater);
			if(height[i]<height[j]) {
				i++;
			}else {
				j--;
			}
		}
		
		return maxWater;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
