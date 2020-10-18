package coding_preps;

import java.util.PriorityQueue;

/** LeetCode #215 **/
public class ArrayKthLargestElement {
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is the number of input elements
	public static int findKthLargest(int[] nums, int k) {
		if(nums==null || nums.length == 0 || k==0) return 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
		for(int num : nums) {
			q.offer(num);
			if(q.size() > k) {
				q.poll();
			}
		}
		
		return q.peek();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
