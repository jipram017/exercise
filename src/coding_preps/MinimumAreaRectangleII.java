package coding_preps;

import java.util.HashSet;
import java.util.Set;

/** LeetCode #963 **/
public class MinimumAreaRectangleII {
	// Time complexity O(N^3)
	// Space complexity O(N)
	// where N is how many points input
    public static double minAreaFreeRect(int[][] points) {
        if(points==null || points.length==0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for(int[] point : points) {
        	set.add(40001*point[0] + point[1]);
        }
        
        double minArea = Double.MAX_VALUE;
        for(int i=0; i<points.length; i++) {
        	int[] p1 = points[i];
        	for(int j=i+1; j<points.length; j++) {
        		int[] p2 = points[j];
        		for(int k=j+1; k<points.length; k++) {
        			int[] p3 = points[k];
        			int[] p4 = new int[] {p2[0]+p3[0]-p1[0], p2[1]+p3[1]-p1[1]};
        			if(set.contains(40001*p4[0] + p4[1])) {
        				int dot = (p2[0]-p1[0])*(p3[0]-p1[0]) + (p2[1]-p1[1])*(p3[1]-p1[1]);
        				if(dot == 0) {
        					double p = Math.sqrt(Math.pow((p2[1]-p1[1]), 2) + Math.pow((p2[0]-p1[0]), 2));
        					double l = Math.sqrt(Math.pow((p3[1]-p1[1]), 2) + Math.pow((p3[0]-p1[0]), 2));
        					minArea = Math.min(minArea, p*l);
        				}
        			}
        		}
        	}
        }
        
        return minArea != Double.MAX_VALUE? minArea : 0.0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
