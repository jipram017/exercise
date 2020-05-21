package exercise;

public class WaterArea {
    public static int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
        int lmax = height[0], rmax = height[height.length-1], w = 0;
        for(int i=0; i < height.length; i++) {
        	lmax = Math.max(lmax, height[i]);
        	leftMax[i] = lmax;
        }
        for(int j=height.length-1; j >= 0; j--) {
        	rmax = Math.max(rmax, height[j]);
        	rightMax[j] = rmax;
        }
        
        for(int k=0; k < height.length; k++) {
        	w += Math.min(leftMax[k], rightMax[k]) - height[k];
        }
        
        return w;
    }
    
    public static int maxArea(int[] height) {
    	if(height == null || height.length == 0) return 0;
        int max = 0;
        int i = 0;
        int j = height.length-1;
        
        while(i < j) {
        	max = Math.max(max, (j-i) * Math.min(height[i], height[j]));
        	if(height[i] < height[j]) {
        		i++;
        	} else {
        		j--;
        	}
        }
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
