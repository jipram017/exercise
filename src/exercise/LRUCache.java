package exercise;

import java.util.HashMap;
import java.util.Map;

//Time complexity O(1)
public class LRUCache {
	
	class Node {
		int key;
		int value;
		Node prev;
		Node next;
		
		Node(int key, int val){
			this.key = key;
			this.value = val;
			this.prev = null;
			this.next = null;
		}
	}
	
	class DoublyLinkedList {
		Node head;
		Node tail;
		
		DoublyLinkedList(){
			this.head = new Node(-1,-1);
			this.tail = new Node(-1,-1);
			head.next = tail;
			tail.prev = head;
		}
		
		Node getFirstNode() {
			if (head == tail) return null;
			return head.next;
		}
		
		Node getLastNode() {
			if (head == tail) return null;
			return tail.prev;
		}
		
		void removeNode(Node node) {
			if(node != null && node.next != null && node.prev != null) {
				Node prev = node.prev;
		        prev.next = node.next;
		        prev.next.prev = prev;
			} 
		}
		
		void putAtFront(Node node) {
			node.next = head.next;
			head.next.prev = node;
			node.prev = head;
			head.next = node;
		}
	}
	
	Map<Integer, Node> cache = null;
	DoublyLinkedList dl = null;
	int capacity = 0;
	
	LRUCache(int capacity){
		this.capacity = capacity;
		cache = new HashMap<Integer, Node>();
		dl = new DoublyLinkedList();
	}
	
	int get(int key) {
		if(!cache.containsKey(key)) {
			return -1;
		}
		else {
			Node node = cache.get(key);
			if(dl.getFirstNode() != node) {
				dl.removeNode(node);
			    dl.putAtFront(node);
			}
			return node.value;
		}
	 }
	
	 void put(int key, int value) {
		 if(cache.containsKey(key)) {
			 Node node = cache.get(key);
			 node.value = value;
			 dl.removeNode(node);
			 dl.putAtFront(node);
		 } else {
		     if (cache.size() == capacity) {
		    	 Node last = cache.get(dl.getLastNode().key);
		    	 dl.removeNode(last);
			     cache.remove(last.key);
		     }
		     Node newNode = new Node(key, value);
		     dl.putAtFront(newNode);
		     cache.put(key, newNode);
		 }
	 }
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		//cache.get(2);       // returns -1 (not found)
		System.out.println(cache.get(2));
		cache.put(4, 4);    // evicts key 1
		cache.get(1);       // returns -1 (not found)
		//cache.get(3);       // returns 3
		System.out.println(cache.get(3));
		cache.get(4);       // returns 4
		
	}

}
