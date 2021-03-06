package com.karumachi.stack;

public class FixedSizeArrayStack {

	protected int capacity;
	public static final int CAPACITY = 10;
	protected int[] stackRep;
	
//Index of the top element of the stack in array
	protected int top = -1;

	public FixedSizeArrayStack() {
		this(CAPACITY);
	}
	
	public FixedSizeArrayStack(int cap) {
		capacity = cap;
		stackRep = new int[capacity];
	}
	
//Returns the number of elements in the stack...
	public int size() {
		return (top+1);		//WHY?
	}
	
//Tests whether the stack is empty..
	public boolean isEmpty() {
		return (top<0);
	}
	
//Inserts an element at the top of the stack..
	public void push(int data) throws Exception{
		if(size()==capacity)
			throw new Exception("Stack is full!");
		stackRep[++top] = data;  	//WHY?
	}
	
//Inspects the element at the top of the stack..
	public int top() throws Exception {
		if(isEmpty())
			throw new Exception("Stack is empty!");
		return stackRep[top];
	}
	
//Removes the top element from the stack...
	public int pop() throws Exception {
		int data;
		if(isEmpty())
			throw new Exception("Stack is empty!");
		data = stackRep[top];
		stackRep[top--] = Integer.MIN_VALUE;
		return data;
	}
	
//Returns a String representation of the stack as a list of elements, with the top element at the end
	public String toString() {
		String str = "[";
		
		for(int i=capacity-1;i>-1;i--) {		//Is this method correct?
			str += "," + stackRep[i];
		}
		str += "]";
		return str;
	}
}
