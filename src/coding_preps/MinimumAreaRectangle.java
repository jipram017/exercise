package coding_preps;

import java.util.HashSet;
import java.util.Set;

/** LeetCode #939 **/
public class MinimumAreaRectangle {
	// Time complexity O(N*N)
	// Space complexity O(N)
	// where N is how many points input
    public static int minAreaRect(int[][] points) {
        if(points==null || points.length==0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int[] point : points) {
        	set.add(40001*point[0] + point[1]);
        }
        
        int minArea = Integer.MAX_VALUE;
        for(int[] point1 : points) {
        	for(int[] point2 : points) {
        		if(point2[0] <= point1[0] || point2[1] <= point1[1]) {
        			continue;
        		}
        		int upperLeft = 40001*point1[0] + point2[1];
        		int bottomRight = 40001*point2[0] + point1[1];
        		if(set.contains(upperLeft) && set.contains(bottomRight)) {
        			int rectArea = (point2[1]-point1[1])*(point2[0]-point1[0]);
        			minArea = Math.min(minArea, rectArea);
        		}
        	}
        }
        
        return minArea!= Integer.MAX_VALUE? minArea : 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
