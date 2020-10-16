package coding_preps;

import helper.DataStructure.ListNode;

// Time complexity O(N)
// Space complexity O(1) where N is the number of nodes
public class LinkedListReversal {
	
	/** LeetCode #206 **/
	public static ListNode reverseList(ListNode head) {
		if(head==null) return null;
		ListNode p1=null, p2=head;
		ListNode p3;
		while(p2 != null) {
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		
		return p1;
	}
	
	/** LeetCode #92 **/
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || head.next == null || m==n) return head;
		ListNode p2 = head, p1 = head, before = new ListNode(-1);
		
		for(int i=1; i<=n; i++) {
			if(i<m) {
				before.next = p1;
				p1 = p1.next;
				before = before.next;
			}
			p2 = p2.next;
		}
		
		int diff = n - m;
		while (diff >= 0) {
			ListNode p3 = p1.next;
			p1.next = p2;
			p2 = p1;
			p1 = p3;
			diff--;
		}
		
		before.next = p2;
		before = head;
		return m==1? p2 : before;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
