package exercises;

import helper.DataStructure.ListNode;

public class LinkedListIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB) {
          	pA = pA != null? pA.next: headB;
        	pB = pB != null? pB.next: headA;
        }
        
        return (pA==pB && pA != null)? pA:null;
    }

}
