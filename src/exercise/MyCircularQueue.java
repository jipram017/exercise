package exercise;

public class MyCircularQueue {
	static class Node{
		int value;
		Node link;
		Node(int val){
			this.value = val;
			this.link = null;
		}
	}
	
	static int capacity;
	static int counter;
	static Node front, rear;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
    	MyCircularQueue.capacity = k;
    	MyCircularQueue.front = null;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public static boolean enQueue(int value) {
    	Node temp = new Node(value);
    	if(counter == capacity) return false;
        if(front == null) {
        	front = temp;
        } else {
        	rear.link = temp;
        }
        
        rear = temp;
        rear.link = front;
        counter++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public static boolean deQueue() {
        if(front == null) return false;
        if(rear == front) {
        	front = null; rear = null;
        	counter--;
        	return true;
        }
        front = front.link;
        rear.link = front;
        counter--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public static int Front() {
    	if(front == null) return -1;
        return front.value;
    }
    
    /** Get the last item from the queue. */
    public static int Rear() {
        if(front == null) return -1;
        return rear.value;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public static boolean isEmpty() {
        return front == null;
    }
    
    /** Checks whether the circular queue is full or not. */
    public static boolean isFull() {
        return counter == capacity;
    }
    
	public static void main(String[] args) {
		System.out.println(MyCircularQueue.enQueue(1));
		System.out.println(MyCircularQueue.Rear());
		System.out.println(MyCircularQueue.Front());
		System.out.println(MyCircularQueue.deQueue());
		System.out.println(MyCircularQueue.Front());
		System.out.println(MyCircularQueue.deQueue());
		System.out.println(MyCircularQueue.Front());
		System.out.println(MyCircularQueue.enQueue(2));
		System.out.println(MyCircularQueue.enQueue(3));
		System.out.println(MyCircularQueue.enQueue(4));
		System.out.println(MyCircularQueue.enQueue(5));
	}

}
