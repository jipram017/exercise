package coding_preps;

/** LeetCode #622 **/
// Time complexity for each operation O(1)
// Space complexity O(k)
public class MyCircularQueue {
	private int front;
	private int rear;
	private int[] arr;
	private int capacity;
	
	/** Initialize your data structure here. Set the size of the queue to be k. */
	public MyCircularQueue(int k) {
		this.capacity = k;
		this.front = -1;
		this.rear = -1;
		this.arr = new int[k];
	}
	
    /** Insert an element into the circular queue. Return true if the operation is successful. */
	public boolean enQueue(int value) {
		if(isFull()) return false;
		if(isEmpty()) front=rear=0;
		else {
			rear = (rear+1)%capacity;
		}
		arr[rear] = value;
		return true;
	}
	
    /** Delete an element from the circular queue. Return true if the operation is successful. */
	public boolean deQueue() {
		if(isEmpty()) return false;
		if(front==rear) front=rear=-1;
		else {
			front = (front+1)%capacity;
		}
		return true;
	}
	
	/** Get the front item from the queue. */
	public int Front() {
		if(isEmpty()) return -1;
		return arr[front];
	}
	
	/** Get the last item from the queue. */
	public int Rear() {
		if(isEmpty()) return -1;
		return arr[rear];
	}
	
	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return front == -1;
	}
	
	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return (rear+1)%capacity == front;
	}
	
	public static void main(String[] args) {
		MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
		circularQueue.enQueue(1);                               // return true
		circularQueue.enQueue(2);                               // return true
		circularQueue.enQueue(3);                               // return true
		circularQueue.enQueue(4);                               // return false, the queue is full
		circularQueue.Rear();                                   // return 3
		circularQueue.isFull();                                 // return true
		circularQueue.deQueue();                                // return true
		circularQueue.enQueue(4);                               // return true
		circularQueue.Rear();                                   // return 4
	}
}
