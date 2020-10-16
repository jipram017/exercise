package coding_preps;

import helper.DataStructure.ListNode;

// Time complexity O(N) where N is the number of nodes
// Space complexity O(1)

public class LinkedListCycle {
	/** LeetCode #141 **/
	public static boolean hasCycle(ListNode head) {
   	    if(head == null) return false;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null && p2.next.next != null) {
        	p1 = p1.next;
        	p2 = p2.next.next;
        	if(p1 == p2) return true;
        }
        return false;
	}
	
	/** LeetCode #142 **/
	public static ListNode detectCycle(ListNode head) {
   	    if(head == null) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        boolean cycleDetected = false;
        while(p2.next != null && p2.next.next != null) {
        	p1 = p1.next;
        	p2 = p2.next.next;
        	if(p1 == p2) {
        		cycleDetected = true;
        		break;
        	}
        }
		
		if(cycleDetected) {
			p1 = head;
			while(p1 != p2) {
				p1 = p1.next;
				p2 = p2.next;
			}
			return p1;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
