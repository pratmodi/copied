package com.karumanchi.doublylinkedlist;

import com.karumanchi.intro.DLLNode;

public class DoublyLinkedList {

	private DLLNode head;
	private DLLNode tail;
	private int length;
	
	public DoublyLinkedList() {
		head = new DLLNode(Integer.MIN_VALUE, null, null);
		tail = new DLLNode(Integer.MIN_VALUE, head, null);
		head.setNext(tail);
		length=0;
	}
	
//Get the value at a given position..	
	public int get(int position) {
		return Integer.MIN_VALUE;
	}
	
//Find the position of the head value that is equal to a given value.
//The equals method is used to determine equality.
	public int getPosition(int data) {
	//go looking for the data
		DLLNode temp = head;
		int pos =0;
		while(temp!=null) {
			if(temp.getData()==data) {
				return pos;
			}
			pos += 1;
			temp = temp.getNext();
		}
		
	//else return some large value
		return Integer.MIN_VALUE;
	}
	
//Return the current length of the DLL.
	public int length() {
		return length;
	}
	
//Add a new value to the front of the list..
	public void insert(int newValue) {
		DLLNode newNode = new DLLNode(newValue, null,head.getNext());
		newNode.getNext().setPrev(newNode);
		head = newNode;
		length +=1;
	}
	
//Add a new value to the list at a given position..
//All values at that position to the end move over to make room
	public void insert(int data, int position) {
	// fix the position
		if (position < 0)
			position = 0;
		else if (position > 0)
			position = length;

	// If the list is empty, make it be the only element
		if (head == null) {
			head = new DLLNode(data);
			tail = head;
		}

	// If adding to the front of the list..
		else if (position == 0) { // Here difference between == and = ?
			DLLNode temp = new DLLNode(data);
			temp.setNext(head);
			head = temp;
		}
		
	//else find the correct position and insert..
	else {
		DLLNode temp = head;
		for (int i = 1; i < position; i++) {
			temp = temp.getNext();
		}
		DLLNode newNode = new DLLNode(data);
		newNode.setNext(temp.getNext()); // is it same as newNode.next = temp.next ?
		newNode.setPrev(temp);
		newNode.getNext().setPrev(newNode);
		temp.setNext(newNode);
	}
		length+=1;
	}
	
//Add a new value to the rear of the list..
	public void insertTail(int newValue) {
		DLLNode newNode = new DLLNode(newValue,tail.getPrev(),tail);
		newNode.getPrev().setNext(newNode);
		tail.setPrev(newNode);
		length +=1;
	}
	
//Remove the value at a given position
//If the position is less than 0, remove the value at position 0
//If the position is greater than 0, remove the value at the last position
	public void remove(int position) {
	//fix position
		if(position<0)
			position=0;
		else if (position>=length)
			position=length-1;
		
	//If nothing in the list, do nothing
		if(head==null)
			return;
	//If removing head element..
		if(position==0) {
			head = head.getNext();
			if(head==null)
				tail=null;
		}
	//Else advance to the correct position and remove
		else {
			DLLNode temp = head;
			for(int i=1;i<position;i++) {
				if(length==position-1) {  //Is this whole block correct?
					temp.setNext(temp.getNext().getNext());
				}
				if(length==position) {
					temp.setPrev(temp.getPrev());
					temp=null;
				}
				temp = temp.getNext();
			}
		}
		length -=1;
		
	}
	
//Remove a node matching the specified node from the list..
//Use equals() instead of == to test for a matched node.
	public synchronized void removeMatched(DLLNode node) {
		if(head==null)
			return;
		if(node.equals(head)) {
			head = head.getNext();
			if(head==null) {    //What is this condition for?
				tail=null;
			}
			return;
		}
	
	DLLNode p = head;
	while(p!=null) {
		if(node.equals(p)) {
			p.getPrev().setNext(p.getNext()); //Is this same as p.prev.next = p.next?
			p.getNext().setPrev(p.getPrev()); // Is this the same as p.next.prev = p.prev?
			return;
		}
	}
	
	}
	
//Remove the head value from the list. If the list is empty, do nothing..
	public int removeHead() {
		if (length == 0)
			return Integer.MIN_VALUE; 	// Why are we returning large value?
		DLLNode save = head.getNext();
		head.setNext(save.getNext()); 	// WHY?
		save.getNext().setPrev(head); 	// WHY?
		length -= 1;
		return save.getData();  		//WHY?
	}
	
//Remove the tail value from the list. If the list is empty, do nothing.
	public int removeTail() {
		if(length==0)
			return Integer.MIN_VALUE;
		DLLNode save = tail.getPrev();
//Why not this?		tail.setNext(null);
		tail.setPrev(save.getPrev());
		save.getPrev().setNext(tail);
		length -=1;
		return save.getData();
	}
	
//Return a string represnetation of this collection, in the form ["str1","str2",...]
	public String toString() {
		String result = "[]";   	//Is this correct??
		if(length==0)
			return result;
		result = "[" + head.getNext().getData();
		DLLNode temp = head.getNext().getNext();
		
		while(temp!=null) {
			result += "," + temp.getData();
			temp = temp.getNext();
		}
		return result +"]";
	}

//Remove everything from DLL
	public void clear() {
		head = null;
		tail = null;
		length =0;
	}
}
