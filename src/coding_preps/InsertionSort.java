package coding_preps;

import helper.DataStructure.ListNode;

public class InsertionSort {
	// Time complexity O(N^2)
	// Space complexity O(1)
	public static int[] sortArray(int[] array) {
		if(array==null || array.length==0) return array;
		for(int i=1; i<array.length; i++) {
			int j = i;
			while(j>0) {
				if(array[j-1] > array[j]) {
					swap(array, j, j-1);
				}
				j--;
			}
		}
		return array;
	}
	
	/** LeetCode #147 **/
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
