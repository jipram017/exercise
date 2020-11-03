package coding_preps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**LeetCode #295 **/
public class MedianFinder {
	private PriorityQueue<Integer> q1 = null;
	private PriorityQueue<Integer> q2 = null;
	
    /** initialize your data structure here. */
    public MedianFinder() {
        q1 = new PriorityQueue<Integer>();
        q2 = new PriorityQueue<Integer>(Comparator.reverseOrder());
    }
    
    // O(logN) time
    public void addNum(int num) {
    	q1.offer(num);
    	q2.offer(q1.poll());
    	if(q2.size() > q1.size()) {
    		q1.offer(q2.poll());
    	}
    }
    
    // O(1) time
    public double findMedian() {
        if(q1.size() > q2.size()) return (double) q1.peek();
        return (q1.peek() + q2.peek())/2.0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
