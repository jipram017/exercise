package coding_preps;

import java.util.HashMap;

/** LeetCode #146 **/
public class LRUCache {
	static class Node{
		int key;
		int val;
		Node next;
		Node prev;
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			this.next = null;
			this.prev = null;
		}
	}
	

	static class DoublyLinkedList{
		Node head;
		Node tail;
		public DoublyLinkedList() {
			this.head = new Node(-1,-1);
			this.tail = new Node(-1,-1);
			head.next = tail;
			tail.prev = head;
		}
		
		public Node getFirstNode() {
			if(head==tail) return null;
			return head.next;
		}
		
		public Node getLastNode() {
			if(head==tail) return null;
			return tail.prev;
		}
		
		public void removeNode(Node node) {
			if(node.next != null) {
				node.next.prev = node.prev;
			}
			if(node.prev != null) {
				node.prev.next = node.next;
			}
			node.prev = null;
			node.next = null;
		}
		
		public void putAtFront(Node node) {
			node.next = head.next;
			head.next.prev = node;
			node.prev = head;
			head.next = node;
		}
	}
	
	HashMap<Integer, Node> map;
	DoublyLinkedList linkedList;
	int capacity = 0;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		this.linkedList = new DoublyLinkedList();
	}
	
	// O(1)
	public int get(int key) {
		if(!map.containsKey(key)) {
			return -1;
		}
		
		Node node = map.get(key);
		if(node != linkedList.getFirstNode()) {
			linkedList.removeNode(node);
			linkedList.putAtFront(node);
		}
		return node.val;
	}
	
	// O(1)
	public void put(int key, int value) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			node.val = value;
			linkedList.removeNode(node);
			linkedList.putAtFront(node);
		}
		else {
			if(map.size() == capacity) {
				Node last = map.get(linkedList.getLastNode().key);
				linkedList.removeNode(last);
				map.remove(last.key);
			} 
			Node newNode = new Node(key, value);
			linkedList.putAtFront(newNode);
			map.put(key, newNode);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
