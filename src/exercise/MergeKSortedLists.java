package exercise;

import java.util.Comparator;
import java.util.PriorityQueue;

import exercise.LinkedListCycle.ListNode;

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
        	public int compare(ListNode l1, ListNode l2) {
        		return l1.val - l2.val;
        	}
        });
        
        for(ListNode l : lists) {
        	if(l != null) queue.offer(l);
        }
        
        ListNode p = new ListNode(-1);
        ListNode head  = p;
        
        while(!queue.isEmpty()) {
        	ListNode top = queue.poll();
        	head.next = top;
        	head = top;
        	if(top.next != null) {
        		queue.offer(top.next);
        	}
        }
        
        return p.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
