package coding_preps;

import helper.DataStructure.ListNode;

public class LinkedListDuplicatesRemoval {
	/** LeetCode #83 **/
	// Time complexity O(N)
	// Space complexity O(1)
	// where N is the number of nodes
	// This remove all duplicates except one
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null) return null;
		ListNode p1 = head;
		
		while(p1 != null && p1.next != null) {
			if(p1.next.val == p1.val) {
				p1.next = p1.next.next;
			} else {
				p1 = p1.next;
			}
		}
		
		return head;
	}
	
	/** LeetCode #82 **/
	// Time complexity O(N)
	// Space complexity O(1)
	// where N is the number of nodes
	// This remove all duplicates, returns only distinct elements
	public static ListNode deleteDuplicates2(ListNode head) {
		if(head==null) return null;
		ListNode p1 = new ListNode(0);
		p1.next = head;
		
		ListNode p2 = p1;
		while(p2.next != null && p2.next.next != null) {
			if(p2.next.val == p2.next.next.val) {
				int duplicate = p2.next.val;
				while(p2.next != null && p2.next.val == duplicate) {
					p2.next = p2.next.next;
				}
			} else {
				p2 = p2.next;
			}
		}
		
		return p1.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
