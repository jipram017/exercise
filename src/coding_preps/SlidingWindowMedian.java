package coding_preps;

import java.util.Comparator;
import java.util.PriorityQueue;

/** LeetCode #480 **/
public class SlidingWindowMedian {
    static PriorityQueue<Integer> minHeap = null;
    static PriorityQueue<Integer> maxHeap = null;
    
    // Time complexity O(NlogK)
    // Space complexity O(K)
    public static double[] medianSlidingWindow(int[] nums, int k) {
    	if((nums.length-k+1)<=0) return new double[0];
    	minHeap = new PriorityQueue<Integer>();
    	maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
    	
        double[] median = new double[nums.length-k+1];
        for(int i=0; i<=nums.length; i++) {
        	if(i>=k) {
        		median[i-k] = getMedian();
        		remove(nums[i-k]);
        	}
        	if(i<nums.length) {
        		add(nums[i]);
        	}
        }
        
        return median;
    }
    
    private static void remove(int num) {
    	if(num < getMedian()) {
    		maxHeap.remove(num);
    	} else {
    		minHeap.remove(num);
    	}
    	
    	if(maxHeap.size() > minHeap.size()) {
    		minHeap.offer(maxHeap.poll());
    	}
    	if(minHeap.size() - maxHeap.size() > 1) {
    		maxHeap.offer(minHeap.poll());
    	}
    }
    
    private static void add(int num) {
    	if(num < getMedian()) {
    		maxHeap.add(num);
    	} else {
    		minHeap.add(num);
    	}
    	
    	if(maxHeap.size() > minHeap.size()) {
    		minHeap.offer(maxHeap.poll());
    	}
    	if(minHeap.size() - maxHeap.size() > 1) {
    		maxHeap.offer(minHeap.poll());
    	}
    }
    
    private static double getMedian() {
    	if(minHeap.size()==0 && maxHeap.size()==0) return 0.0;
    	if(minHeap.size() == maxHeap.size()) {
    		return ((double)minHeap.peek() + (double)maxHeap.peek())/2.0;
    	}
    	return (double) minHeap.peek();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
