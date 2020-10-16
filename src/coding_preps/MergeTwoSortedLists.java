package coding_preps;

import helper.DataStructure.ListNode;

/** LeetCode #21 **/
public class MergeTwoSortedLists {
	
	// Time complexity O(N)
	// Space complexity O(1)
	// where N is total number of nodes
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		
		ListNode tmp = new ListNode(-1);
		ListNode result = tmp;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				tmp.next = l1;
				tmp = l1;
				l1 = l1.next;
			} else {
				tmp.next = l2;
				tmp = l2;
				l2 = l2.next;
			}
		}
		
		if(l1 != null) {
			tmp.next = l1;
		}
		
		if(l2 != null) {
			tmp.next = l2;
		}
		
		return result.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
