package exercises;

import exercises.Node.ListNode;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
    	ListNode result = new ListNode(-1);
    	ListNode last = result;
    	
        while(l1 != null && l2 != null) {
        	if(l1.val < l2.val) {
        		last.next = l1;
        		last = l1;
        		l1 = l1.next;
        	} else {
        		last.next = l2;
        		last = l2;
        		l2 = l2.next;
        	}
        }
        
        if(l1 != null) {
        	last.next = l1;
        }
        if(l2 != null) {
        	last.next = l2;
        }
        
        return result.next;  
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
