package exercises;

public class Node {
	 // Definition for singly-linked list.
	public static class ListNode {
		 public int val;
	     public ListNode next;
	     public ListNode(int x) {
	    	 val = x;
	         next = null;
	     }
	}
	
	// Definition of TrieNode.
	public static class TrieNode {
		TrieNode[] arr;
		boolean isLeaf;
		TrieNode() {
			arr = new TrieNode[26];
		}
	}
}
