package com.karumanchi.queues;

public class FixedSizeArrayQueue {

	private int[] queueRep;
	private int size, front, rear;
	
//Length of the array used to implement the queue..
	private static final int CAPACITY = 16; //Default Queue size

//Initializes the queue to use an array of default length..
	public FixedSizeArrayQueue() {
		queueRep = new int[CAPACITY];
		size=0; front=0;rear=0; 			//WHY?
	}
	
//Initializes the queue to use an array of given length..
	public FixedSizeArrayQueue(int cap) {
		queueRep = new int[cap];
		size=0;front=0;rear=0;
	}
	
//Inserts an element at the rear of the queue...
	public void enQueue(int data) throws Exception {
		if(size==CAPACITY)
			throw new Exception("Queue is full. Overflow!");
		else {
			size++;
			queueRep[rear] = data;
			rear = (rear+1) % CAPACITY;
		}
	}
	
//Removes the front element from the queue...
	public int deQueue() throws Exception {
		if(size==0)
			throw new Exception("Queue is empty!");
		size--;
		int data = queueRep[(front%CAPACITY)];
		queueRep[front] = Integer.MIN_VALUE;
		front = (front+1) % CAPACITY;
		return data;
	}
	
//Check whether the queue is empty.
	public boolean isEmpty() {
		return (size==0);
	}
	
//Checks whether the queue is full..
	public boolean isFull() {
		return (size==CAPACITY);
	}
	
//Returns the number of elements in the queue..
	public int size() {
		return size;
	}

//Returns the String representation of the queue as a list of elements, with the
//front element at the end [...,prev,rear]
	public String toString() {
		String result = "[";
		for(int i=0;i<size;i++) {
			result += Integer.toString(queueRep[(front+i)%CAPACITY]);	//WHY?	
			if(i<size-1)
				result +=", ";  			//WHY?
		}
		result += "]";
		return result;
	}
}
