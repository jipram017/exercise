package exercises;

import helper.DataStructure.ListNode;

public class ReverseLinkedList {
	
	// Reverse the entire linked list
    public ListNode reverseList(ListNode head) {
        ListNode p1 = null, p2 = head;
        while(p2 != null) {
        	ListNode p3 = p2.next;
        	p2.next = p1;
        	p1 = p2;
        	p2 = p3;
        }
        return p1;
    }
    
    // Reverse linked list between m and n
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next == null) return head;
        if(m==n) return head;
        ListNode p1 = head, p2 = head;
        ListNode before = new ListNode(-1);

        for(int i=1; i <= n; i++) {
        	if(i < m) {
                before.next = p2;
        		p2 = p2.next;
                before = before.next;
        	}
        	p1 = p1.next;
        }
       
        int diff = n-m;
        while(diff >= 0) {
        	ListNode p3 = p2.next;
        	p2.next = p1;
        	p1 = p2;
        	p2 = p3;
        	diff--;
        }
        
        before.next = p1;
        before = head;
        return m == 1 ? p1 : before;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
