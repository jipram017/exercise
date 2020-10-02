package coding_preps;

import java.util.HashMap;
import java.util.HashSet;

/** LeetCode #403 **/
public class FrogJump {
	// Time complexity O(N^3/2)
	// Space complexity O(N)
	// where N is size of the inputs
	public static boolean canCross(int[] stones) {
		if(stones==null || stones.length == 0) return false;
		HashMap<Integer, HashSet<Integer>> steps = new HashMap<Integer, HashSet<Integer>>();
		for(Integer stone : stones) {
			steps.put(stone, new HashSet<Integer>());
		}
		
		steps.get(stones[0]).add(1);
		
		for(int i=0; i<stones.length-1; i++) {
			for(int step : steps.get(stones[i])) {
				int dest = stones[i] + step;
				if(dest == stones[stones.length-1]) return true;
				
				HashSet<Integer> dest_steps = steps.get(dest);
				if(dest_steps != null) {
					dest_steps.add(step);
					if(step > 1) dest_steps.add(step-1);
					dest_steps.add(step+1);
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones1 = new int[] {0,1,3,5,6,8,12,17};
		int[] stones2 = new int[] {0,1,2,3,4,8,9,11};
		System.out.println(canCross(stones1));
		System.out.println(canCross(stones2));
	}

}
