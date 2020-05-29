package exercise;

public class MyCircularDeque {	
	static class Node{
		int value;
		Node next;
		Node prev;
		Node(int val){
			this.value = val;
			this.next = null;
			this.prev  = null;
		}
	}

	static int capacity, counter;
	static Node front, rear;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
    	MyCircularDeque.capacity = k;
    	MyCircularDeque.counter = 0;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public static boolean insertLast(int value) {
        Node temp = new Node(value);
        if(counter == capacity) return false;
        if(rear == null) {
        	front = rear = temp;
        } else {
        	temp.prev = rear;
        	rear.next = temp;
        	rear = temp;
        }
        counter++;
        return true;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public static boolean insertFront(int value) {
        Node temp = new Node(value);
        if(counter == capacity) return false;
        if(front == null) {
        	rear = front = temp;
        } else {
        	temp.next = front;
        	front.prev = temp;
        	front = temp;
        }
        counter++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public static boolean deleteFront() {
        if(front == null) return false;
        front = front.next;
        if(front == null) {
        	rear = null;
        } else {
        	front.prev = null;
        }
        counter--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public static boolean deleteLast() {
    	if(front == null) return false;
    	rear = rear.prev;
    	if(rear == null) {
    		front = null;
    	} else {
    		rear.next = null;
    	}
        counter--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public static int getFront() {
        if(front==null) return -1;
        return front.value;
    }
    
    /** Get the last item from the deque. */
    public static int getRear() {
        if(rear==null) return -1;
        return rear.value;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public static boolean isEmpty() {
        return front == null;
    }
    
    /** Checks whether the circular deque is full or not. */
    public static boolean isFull() {
        return counter == capacity;
    }
    
	public static void main(String[] args) {
		System.out.println(MyCircularDeque.insertFront(1));
		System.out.println(MyCircularDeque.getFront());
		System.out.println(MyCircularDeque.isEmpty());
		System.out.println(MyCircularDeque.deleteFront());
		System.out.println(MyCircularDeque.insertLast(2));
		System.out.println(MyCircularDeque.getRear());
		System.out.println(MyCircularDeque.insertLast(3));
		System.out.println(MyCircularDeque.insertFront(4));
		System.out.println(MyCircularDeque.deleteLast());
		System.out.println(MyCircularDeque.insertLast(5));
		System.out.println(MyCircularDeque.isEmpty());
	}

}
