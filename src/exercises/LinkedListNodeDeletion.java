package exercises;

import exercises.Node.ListNode;

public class LinkedListNodeDeletion {
	
	// Delete node from a linked list (except tail) given access only to that node
    public static void deleteNode(ListNode node) {
        ListNode nxt = node.next;
        if(nxt != null) {
        	node.val = nxt.val;
        	node.next = nxt.next;
        }
    }
    
    // Delete node(s) with certain value from linked list
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.next.val == val) pointer.next = pointer.next.next;
            else pointer = pointer.next;
        }
        return head.val == val ? head.next : head; 
    }
    
    
    // Remove Nth element from end of linked list
    public static ListNode removeNthFromEnd(ListNode head, int n) {
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
