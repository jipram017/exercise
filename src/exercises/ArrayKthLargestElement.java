package exercises;

import java.util.PriorityQueue;

public class ArrayKthLargestElement {
	
	// O(N log K) time where N = size of input array and K = kth
	// O(1) space
    public static int findKthLargest(int[] nums, int k) {
    	if(nums == null || nums.length == 0 || k == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(Integer num : nums) {
        	pq.offer(num);
        	if(pq.size() > k) {
        		pq.poll();
        	}
        }
        
        return pq.peek();
    }
    
	public static void main(String[] args) {
		int[] nums = new int[] {3,2,1,5,6,4};
		System.out.println(findKthLargest(nums, 2));
		
		int[] nums2 = new int[] {3,2,3,1,2,4,5,5,6};
		System.out.println(findKthLargest(nums2, 4));
	}

}
