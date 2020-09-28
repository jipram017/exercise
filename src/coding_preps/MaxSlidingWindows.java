package coding_preps;

import java.util.Arrays;
import java.util.LinkedList;

/** LeetCode #239 **/
public class MaxSlidingWindows {
	
	// Time complexity O(N-K+1) where N is size of nums array
	// Space complexity O(N-K+1)
    public static int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums==null || nums.length == 0) return new int[0];
        int[] result = new int[nums.length-k+1];
        
        LinkedList<Integer> deque = new LinkedList<Integer>();
        
        for(int i=0; i<nums.length; i++) {
        	if(!deque.isEmpty() && deque.peekFirst() == i-k) {
        		deque.poll();
        	}
        	while(!deque.isEmpty() && nums[i]>nums[deque.peekLast()]) {
        		deque.removeLast();
        	}
        	
        	deque.offer(i);
        	
        	if(i+1 >= k) {
        		result[i+1-k] = nums[deque.peek( )];
        	}
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
		int k = 3;
		
		System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
	}

}

