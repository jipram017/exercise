package coding_preps;

import helper.DataStructure.ListNode;

/** LeetCode #147 **/
public class InsertionSortList {
	// Time complexity O(N^2)
	// Space complexity O(1)
	public static ListNode insertionSortList(ListNode head) {
		if(head==null) return null;
		ListNode init = head;
		ListNode curr = head.next;
		
		while(curr != null) {
			while(init != curr) {
				if(init.val > curr.val) {
					int temp = init.val;
					init.val = curr.val;
					curr.val = temp;
				}
				init = init.next;
			}
			init = head;
			curr = curr.next;
		}
		
		return head;
	}
	
	public static void swap(int[] array, int idx1, int idx2) {
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
