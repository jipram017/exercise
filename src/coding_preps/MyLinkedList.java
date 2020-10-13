package coding_preps;

/** LeetCode #707 **/
public class MyLinkedList {
	class Node{
		Node next;
		Node prev;
		int val;
		public Node(int val){
			this.next = null;
			this.prev = null;
			this.val = val;
		}
	}
	
	Node head;
	Node tail;
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	// This methods return value of a Node with specified index. Return -1 if not found
	// O(p) time, O(1) space, p = the index 
	public int get(int index) {
		if(index==0) return head.val;
		int currentIndex =0;
		Node node = head;
		while(node != null && currentIndex != index) {
			currentIndex++;
			node = node.next;
		}
		
		if(node != null) return node.val;
		return -1;
	}
	
	// This methods adds a node of value val before the first element of the linked list
	// After the insertion, the new node will be the first node of the doubly linked list.
	// O(1) time, O(1) space
	public void addAtHead(int val) {
		Node node = new Node(val);
		if(head==null) {
			head = node;
			tail = node;
		}
		else {
			addBefore(head, node);
		}
	}
	
	// This method appends a node of value val as the last element of the double linked list.
	// O(1) time, O(1) space
	public void addAtTail(int val) {
		Node node = new Node(val);
		if(tail == null) {
			head = node;
			tail = node;
		}
		else {
			addAfter(tail, node);
		}
		
	}
	
	// This methods adds a node before another node 
	// O(1) time, O(1) space
	public void addBefore(Node node, Node nodeToInsert) {
		if(nodeToInsert == head && nodeToInsert == tail) return;
		delete(nodeToInsert);
		nodeToInsert.next = node;
		nodeToInsert.prev = node.prev;
		if(node.prev != null) {
			node.prev.next = nodeToInsert;
		} else {
			head = nodeToInsert;
		}
		node.prev = nodeToInsert;
	}
	
	// This method adds a node after another node
	// O(1) time, O(1) space
	public void addAfter(Node node, Node nodeToInsert) {
		if(nodeToInsert == head && nodeToInsert == tail) return;
		delete(nodeToInsert);
		nodeToInsert.prev = node;
		nodeToInsert.next = node.next;
		if(node.next != null) {
			node.next.prev = nodeToInsert;
		} else {
			tail = nodeToInsert;
		}
		node.next = nodeToInsert;
	}
	
	// This method adds a Node with specified value at specified index
	// O(p) time, O(1) space, p = the index
	public void addAtIndex(int index, int val) {
		if(index==0) {
			addAtHead(val);
			return;
		}
		
		Node node = head;
		int currentIndex = 0;
		while(node != null && currentIndex != index) {
			currentIndex++;
			node = node.next;
		}
		
		if(node != null) {
			addBefore(node, new Node(val));
		}
		else if(currentIndex == index) {
			addAtTail(val);
		}
	}
	
	// This methods delete a Node
	// O(1) time, O(1) space
	public void delete(Node node) {
		if(node == head) head = head.next;
		if(node == tail) tail = tail.prev;
		
		if(node.next != null) {
			node.next.prev = node.prev;
		}
		if(node.prev != null) {
			node.prev.next = node.next;
		}
		node.next = null;
		node.prev = null;
	}
	
	// This method delete a Node from the specified index
	// O(p) time, O(1) space, p = the index
	public void deleteAtIndex(int index) {
		Node node = head;
		if(index==0) {
			head = head.next;
			return;
		}
		int currentIndex = 0;
		while(node != null && currentIndex != index) {
			currentIndex++;
			node = node.next;
		}
		if(node != null) {
			delete(node);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
