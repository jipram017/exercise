package coding_preps;

import java.util.Comparator;
import java.util.PriorityQueue;

import helper.DataStructure.ListNode;

/** LeetCode #23 **/
public class MergeKSortedLists {
	// Time complexity O(NlogK) where N is the number of elements and K is the number of list nodes
	// Space complexity O(N)
    public static ListNode mergeKLists(ListNode[] lists) {
    	if(lists == null || lists.length == 0) return null;
    	ListNode p = new ListNode(-1);
    	ListNode head = p;
    	
    	PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(
    			new Comparator<ListNode>()
    			{
					@Override
					public int compare(ListNode o1, ListNode o2) {
						// TODO Auto-generated method stub
						return o1.val - o2.val;
					}
    			}
    	);
    	
    	for(ListNode node : lists) {
    		if(node != null) q.offer(node);
    	}
    	
    	while(!q.isEmpty()) {
    		ListNode top = q.poll();
    		p.next = top;
    		p = p.next;
    		if(top.next != null) {
    			q.offer(top.next);
    		}
    	}
    	
    	return head.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
