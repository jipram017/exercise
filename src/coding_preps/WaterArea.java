package coding_preps;

/** LeetCode #42 **/
public class WaterArea {
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is length of the input
	public static int trap(int[] height) {
		if(height==null || height.length == 0) return 0;
		int lmax = height[0], rmax = height[height.length-1];
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		
		int maxArea = 0;
		
		for(int i=0; i<height.length; i++) {
			lmax = Math.max(lmax, height[i]);
			leftMax[i] = lmax;
		}
		
		for(int j=height.length-1; j>=0; j--) {
			rmax = Math.max(rmax, height[j]);
			rightMax[j] = rmax;
		}
		
		for(int i=0; i<height.length; i++) {
			maxArea += Math.min(leftMax[i], rightMax[i]) - height[i];
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
