package exercise;

import exercise.LinkedListCycle.ListNode;

public class LinkedListNodeDeletion {
    public static void deleteNode(ListNode node) {
        ListNode nxt = node.next;
        if(nxt != null) {
        	node.val = nxt.val;
        	node.next = nxt.next;
        }
    }
    
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.next.val == val) pointer.next = pointer.next.next;
            else pointer = pointer.next;
        }
        return head.val == val ? head.next : head; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
