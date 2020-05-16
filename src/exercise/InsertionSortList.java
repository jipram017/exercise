package exercise;

import exercise.LinkedListCycle.ListNode;

public class InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode current = head.next, init = head;
		while(current != null) {
			while(init != current) {
				if(init.val > current.val) {
					int temp = current.val;
					current.val = init.val;
					init.val = temp;
				}
				init  = init.next;
			}
			init = head;
			current = current.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
