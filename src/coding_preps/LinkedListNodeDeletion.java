package coding_preps;

import helper.DataStructure.ListNode;

public class LinkedListNodeDeletion {
	/** LeetCode #237 **/
	// Time complexity O(1)
	// Space complexity O(1)
	public static void deleteNode(ListNode node) {
		ListNode next = node.next;
		if(next != null) {
			node.val = next.val;
			node.next = next.next;
		}
	}
	
	/** LeetCode #203 **/
	// Time complexity O(N)
	// Space complexity O(1)
	// where N is the number of nodes
	public static ListNode removeElements(ListNode head, int val) {
		 if(head==null) return head;
		 ListNode pointer = head;
		 while(pointer.next != null) {
			 if(pointer.next.val == val) {
				 pointer.next = pointer.next.next;
			 }
			 else{
				 pointer = pointer.next;
			 }
		 }
		 return head.val==val? head.next : head;
	}
	
	/** LeetCode #19 **/
	// Time complexity O(N)
	// Space complexity O(1)
	// where N is the number of nodes
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head==null) return null;
		if(n==0) return head;
		ListNode p1 = head, p2 = head;
		for(int i=1; i<=n; i++) {
			p2 = p2.next;
		}
		
		if(p2 == null) {
			head = head.next;
			return head;
		}
		
		while(p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		p1.next = p1.next.next;
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
