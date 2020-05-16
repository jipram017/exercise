package exercise;

import exercise.LinkedListCycle.ListNode;

public class SortLinkedList {
	// Time complexity O(N log(N)), space complexity O(1)
	public static ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode slow = head, fast = head, prev = null;
		while(fast != null && fast.next != null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
	
		prev.next = null;
		return mergeSort(sortList(slow), sortList(head));
	}
	
	public static ListNode mergeSort(ListNode first, ListNode second) {
		ListNode result = new ListNode(-1);
		ListNode current = result;
		while(first != null && second != null) {
			if(first.val < second.val) {
				current.next = first;
				first = first.next;
			} else {
				current.next = second;
				second = second.next;
			}
			current = current.next;
		}
		
		current.next = first != null ? first : second;
		return result.next;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
