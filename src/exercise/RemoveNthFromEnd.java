package exercise;

import exercise.LinkedListCycle.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(head == null) return null;
        ListNode first = head, second = head;
        for(int i=0; i < n; i++) {
        	second = second.next;
        }
        
        if(second == null) {
        	head = head.next;
        	return head;
        }
        
        while(second.next != null) {
        	second = second.next;
        	first = first.next;
        }
        
        first.next = first.next.next;
        return head;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
