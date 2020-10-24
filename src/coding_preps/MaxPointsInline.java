package coding_preps;

import java.util.HashMap;
import java.util.Map;

/** LeetCode #149 **/
public class MaxPointsInline {
	// Time complexity O(N*N)
	// Space complexity O(N*N)
	// where N is the number of input points
	public int maxPoints(int[][] points) {
		if(points==null||points.length==0) return 0;
		Map<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
		int result = Integer.MIN_VALUE;
		
		for(int i=0; i<points.length; i++) {
			map.clear();
			int maxCount = 0, duplicate = 0;
			for(int j=i+1; j<points.length; j++) {
				int dx = points[j][0] - points[i][0];
				int dy = points[j][1] - points[i][1];
				if(dx==0 && dy==0) {
					duplicate++; continue;
				}
				
				int gcd = generateGCD(dx, dy);
				if(gcd != 0) {
					dx = dx / gcd;
					dy = dy / gcd;
				}
				
				if(map.containsKey(dx)) {
					if(map.get(dx).containsKey(dy)) {
						map.get(dx).put(dy, map.get(dx).get(dy) + 1);
					} else {
						map.get(dx).put(dy, 1);
					}
				} else {
					HashMap<Integer, Integer> temp = new HashMap<>();
					temp.put(dy,  1);
					map.put(dx, temp);
				}
				
				maxCount = Math.max(maxCount, map.get(dx).get(dy));
			}
			
			result = Math.max(result,  maxCount + 1 + duplicate);
		}
		
		return result;
	}
	public static int generateGCD(int a, int b) {
		if(b==0) return a;
		return generateGCD(b, a%b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
