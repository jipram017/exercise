package coding_preps;

import helper.DataStructure.ListNode;

/** LeetCode #160 **/
public class LinkedListIntersection {
	
	// Time complexity O(N)
	// Space complexity O(1)
	// where N is the total number of nodes
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		ListNode p1 = headA;
		ListNode p2 = headB;
		
		while(p1 != p2) {
			p1 = p1==null? headB : p1.next;
			p2 = p2==null? headA : p2.next;
		}
		
		return (p1==p2 && p1 != null)? p1 : null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
