package exercise;

public class LinkedListCycle {
	 // Definition for singly-linked list.
	static class ListNode {
		 int val;
	     ListNode next;
	     ListNode(int x) {
	    	 val = x;
	         next = null;
	     }
	}
	
    public static boolean hasCycle(ListNode head) {
    	if(head == null) return false;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null && p2.next.next != null) {
        	p1 = p1.next;
        	p2 = p2.next.next;
        	if(p1 == p2) return true;
        }
        return false;
    }
    
    public static ListNode detectCycle(ListNode head) {
    	if(head == null) return null;
        boolean cycleDetected = false;
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null && p2.next.next != null) {
        	p1 = p1.next;
        	p2 = p2.next.next;
            if(p1 == p2){
                cycleDetected = true; break;
            }
        }
        
        if(!cycleDetected) return null;
        p1 = head;
        while(p1 != p2) {
        	p1 = p1.next;
        	p2 = p2.next;
        }
        return p1;   
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
