package exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FrogJump {
	
    // Time complexity O(n), space complexity O(n)
    public boolean canCross(int[] stones) {
  	    if(stones == null || stones.length == 0) return false;
    	HashMap<Integer, Set<Integer>> dp = new HashMap<>();
    	for(Integer stone : stones) {
    		dp.put(stone, new HashSet<Integer>());
    	}
    	
    	dp.get(0).add(0);
    	
    	for(Integer stone : stones) {
    		for(Integer reach : dp.get(stone)) {
    			for(Integer step = reach-1; step <= reach+1; step++) {
    				if(step > 0 && dp.containsKey(stone + step)) {
                        if(stone+step >= stones[stones.length-1]) return true;
    					dp.get(stone+step).add(step);
    				}
    			}
    		}
    	}
    	
    	return dp.get(stones[stones.length-1]).size() > 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
