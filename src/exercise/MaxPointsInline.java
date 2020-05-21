package exercise;

import java.util.HashMap;
import java.util.Map;

// Time O(n^2), Space O(1)
public class MaxPointsInline {
    public int maxPoints(int[][] points) {
    	if(points.length == 0 || points == null) return 0;
    	int finalCount = 0;
    	Map<Integer, Map<Integer, Integer>> result = new HashMap<>();
    	
        for(int i = 0; i < points.length; i++) {
            result.clear();
        	int duplicate = 1, maxCount = 0;
        	for(int j = i+1; j < points.length; j++) {
    			int dy = points[j][1] - points[i][1];
    			int dx = points[j][0] - points[i][0];
    			if(dx == 0 && dy == 0) {
    				duplicate++;
    				continue;
    			}
    			
    			int d = generateGCD(dx, dy);
    			if(d != 0) {
    				dx /= d; dy /= d;
    			}
        			
        		if(result.containsKey(dx)) {
        			if(result.get(dx).containsKey(dy)) {
        				result.get(dx).put(dy, result.get(dx).get(dy) + 1);
        			} else {
        				result.get(dx).put(dy, 1);
        			} 
        		} else {
        			Map<Integer, Integer> m = new HashMap<>();
        			m.put(dy, 1);
        			result.put(dx, m);
        		}
        			
        		maxCount = Math.max(maxCount, result.get(dx).get(dy));	
        	}	
        	finalCount = Math.max(finalCount, maxCount+duplicate);
        } 
        return finalCount;
    }
    
    private int generateGCD(int a, int b) {
    	if(b == 0) return a;
    	return generateGCD(b, a%b);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
