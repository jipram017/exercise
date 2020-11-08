package coding_preps;

/** LeetCode #641 **/
// Time complexity for each operation O(1)
// Space complexity O(k)
public class MyCircularDeque {
	private int[] arr;
	private int front;
	private int rear;
	private int capacity;
	
	/** Initialize your data structure here. Set the size of the deque to be k. */
	public MyCircularDeque(int k) {
		this.capacity = k;
		this.front = -1;
		this.rear = -1;
		this.arr = new int[k];
	}
	
	/** Adds an item at the front of Deque. Return true if the operation is successful. */
	public boolean insertFront(int value) {
		if(isFull()) return false;
		if(isEmpty()) {
			front = rear = 0;
		} else {
			front = (front + 1)%capacity;
		}
		arr[front] = value;
		return true;
	}
	
	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	public boolean insertLast(int value) {
		if(isFull()) return false;
		if(isEmpty()) {
			front = rear = 0;
		} else {
			rear = (rear-1+capacity)%capacity;
		}
		arr[rear] = value;
		return true;
	}
	
	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	public boolean deleteFront() {
		if(isEmpty()) return false;
		if(front==rear) front=rear=-1;
		else front = (front-1+capacity)%capacity;
		return true;
	}
	
	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	public boolean deleteLast() {
		if(isEmpty()) return false;
		if(front==rear) front=rear=-1;
		else rear = (rear+1)%capacity;
		return true;
	}
	
	/** Get the front item from the deque. */
	public int getFront() {
		if(isEmpty()) return -1;
		return arr[front];
	}
	
	/** Get the last item from the deque. */
	public int getRear() {
		if(isEmpty()) return -1;
		return arr[rear];
	}
	
	/** Checks whether the circular deque is empty or not. */
	public boolean isEmpty() {
		if(front==-1) return true;
		return false;
	}
	
	/** Checks whether the circular deque is full or not. */
	public boolean isFull() {
		if(rear==front+1 || (front==capacity-1 && rear==0)) return true;
		return false;
	}
	
	public static void main(String[] args) {
		MyCircularDeque circularDeque = new MyCircularDeque(3); // set the size to be 3
		circularDeque.insertLast(1);			                // return true
		circularDeque.insertLast(2);			                // return true
		circularDeque.insertFront(3);			                // return true
		circularDeque.insertFront(4);			                // return false, the queue is full
		circularDeque.getRear();  			                    // return 2
		circularDeque.isFull();				                    // return true
		circularDeque.deleteLast();			                    // return true
		circularDeque.insertFront(4);			                // return true
		circularDeque.getFront();			                    // return 4
	}

}
