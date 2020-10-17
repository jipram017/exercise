package coding_preps;

import helper.DataStructure.ListNode;

/** LeetCode #148 **/
public class LinkedListSorting {
	// Time complexity O(NlogN)
	// Space complexity O(1)
	// where N is total number of nodes
	public static ListNode sortList(ListNode head) {
		if(head==null) return null;
		ListNode slow = head, fast = head, prev = null;
		
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev.next = null;
		return mergeSort(sortList(head), sortList(slow));
	}
	
	public static ListNode mergeSort(ListNode p1, ListNode p2) {
		if(p1==null) return p2;
		if(p2==null) return p1;
		
		ListNode tmp = new ListNode(-1);
		ListNode result = tmp;
		
		while(p1 != null && p2 != null) {
			if(p1.val < p2.val) {
				result.next = p1;
				p1 = p1.next;
			} else {
				result.next = p2;
				p2 = p2.next;
			}
			result = result.next;
		}
		
		if(p1 != null) {
			result.next = p1;
		}
		
		if(p2 != null) {
			result.next = p2;
		}
		
		return tmp.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
