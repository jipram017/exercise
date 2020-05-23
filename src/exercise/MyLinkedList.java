package exercise;

public class MyLinkedList {
	class Node {
		int value;
		Node prev, next;
		
		Node(int val){
			this.value = val;
			this.prev = null;
			this.next = null;
		}
	}
	
    /** Initialize your data structure here. */
	Node head, tail;
    public MyLinkedList() {
    	this.head = null;
    	this.tail = null;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    // O(P) time, O(1) space, >> P : position/index in the linked list
    public int get(int index) {
    	if(index == 0) {
    		return head.value;
    	}
    	int currentIndex = 0;
    	Node node = head;
    	while(node != null && currentIndex != index) {
    		node = node.next;
    		currentIndex++;
    	}
    	if(node != null) {
    		return node.value;
    	} 
    	return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    // O(1) time, O(1) space
    public void addAtHead(int val) {
    	Node node = new Node(val);
    	if(head == null) {
    		head = node; tail = node; return;
    	}
    	addBefore(head, node);     
    }
    
    /** Append a node of value val to the last element of the linked list. */
    // O(1) time, O(1) space
    public void addAtTail(int val) {
    	Node node = new Node(val);
    	if(tail == null) {
    		addAtHead(val);
    	}
    	addAfter(tail, node);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    // O(P) time, O(1) space, >> P: Position/Index
    public void addAtIndex(int index, int val) {
    	if(index == 0) {
    		addAtHead(val);
    		return;
    	}
    	int currentIndex = 0;
    	Node node = head;
    	while(node != null && currentIndex != index) {
    		node = node.next;
    		currentIndex++;
    	}
    	
    	Node nodeToInsert = new Node(val);
    	if(node != null) {
    		addBefore(node, nodeToInsert);
    	} else if(currentIndex == index){
    		addAtTail(val);
    	} 
    }
    
    /** Add a node at certain index or position in the doubly linked list. */
    // O(P) time, O(1) space, >> P: Position/Index
    public void addAtIndex(int index, Node nodeToInsert) {
    	if(index == 0) {
    		setHead(nodeToInsert);
    		return;
    	}
    	int currentIndex = 0;
    	Node node = head;
    	while(node != null && currentIndex != index) {
    		node = node.next;
    		currentIndex++;
    	}
    	if(node != null) {
    		addBefore(node, nodeToInsert);
    	} else if(currentIndex == index) {
    		setTail(nodeToInsert);
    	}
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    // O(P) time, O(1) space, >> P: Position/Index
    public void deleteAtIndex(int index) {
    	if(index == 0) {
    		head = head.next;
    		return;
    	}
    	int currentIndex = 0;
    	Node node = head;
    	while(node != null && currentIndex != index) {
    		node = node.next;
    		currentIndex++;
    	}
    	if(node != null) {
    		delete(node);
    	} 
    }
    
    /** Set a node as the head of doubly linked list */
    // O(1) time, O(1) space
    public void setHead(Node node) {
    	if(head == null) {
    		head = node;
    		tail = node;
    		return;
    	}
    	addBefore(head, node);
    }
    
    /** Set a node as the tail of doubly linked list */
    // O(1) time, O(1) space
    public void setTail(Node node) {
    	if(tail == null) {
    		setHead(node);
    		return;
    	}
    	addAfter(tail, node);
    }
    
    /** Add a node before other node. */
    // O(1) time, O(1) space
    public void addBefore(Node node, Node nodeToInsert) {
    	if(nodeToInsert == head && nodeToInsert == tail) return;
    	delete(nodeToInsert);
    	nodeToInsert.prev = node.prev;
    	nodeToInsert.next = node;
    	if(node.prev == null) {
    		head = nodeToInsert;
    	} else {
    		node.prev.next = nodeToInsert;
    	}
    	node.prev = nodeToInsert;
    }
    
    /** Add a node after other node. */
    // O(1) time, O(1) space
    public void addAfter(Node node, Node nodeToInsert) {
    	if(nodeToInsert == head && nodeToInsert == tail) return;
    	delete(nodeToInsert);
    	nodeToInsert.next = node.next;
    	nodeToInsert.prev = node;
    	if(node.next == null) {
    		tail = nodeToInsert;
    	} else {
    		node.next.prev = nodeToInsert;
    	}
    	node.next = nodeToInsert;
    }
    
    /** Remove a node from doubly linked list. */
    // O(1) time, O(1) space
    public void delete(Node node) {
    	if(node == head) head = head.next;
    	if(node == tail) tail = tail.prev;
    	
    	if(node.prev != null) node.prev.next = node.next;
    	if(node.next != null) node.next.prev = node.prev;
    	node.prev = null;
    	node.next = null;
    }
    
    /** Remove node with certain value from doubly linked list. */
    // O(N) time, O(1) space
    public void deleteNodeWithValue(int val) {
    	Node node = head;
    	while(node != null) {
    		Node nodeToRemove = node;
    		node = node.next;
    		if(nodeToRemove.value == val) {
    			delete(nodeToRemove);
    		}
    	}
    }
    
    /** Check if doubly linked list contains node with certain value. */
    // O(N) time, O(1) space
    public boolean containsNodeWithValue(int val) {
    	Node node = head;
    	while(node != null && node.value != val) {
    		node = node.next;
    	}
    	return node != null;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
