package com.karumanchi.linkedlist;

import com.karumanchi.intro.ListNode;

public class LinkedList {
	ListNode head;
	private int length = 0;

	public LinkedList() {
		super();
		length = 0;
	}

	public ListNode getHead() {
		return head;
	}

	public void setHead(ListNode head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

//Insert a node at the beginning of the list..
	public synchronized void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}

//Insert a node at the end of the list..
	public synchronized void insertAtEnd(ListNode node) {
		if (head == null)
			head = node;
		else {
			ListNode p, q;
			for (p = head; (q = p.getNext()) != null; p = q)
				p.setNext(node);
			node.setNext(null);
		}
		length++;
	}

//Add a new value to the list at a given position..
	public void insert(int data, int position) {

		// fix the position
		if (position < 0)
			position = 0;
		else if (position > length)
			position = length;

		// If the list is empty, make it be the only element..
		if (head == null)
			head = new ListNode(data);

		// IF adding at the front of the list..
		else if (position == 0) {
			ListNode temp = new ListNode(data);
			temp.setNext(head);
			head = temp;
		}

		// Else find the corrent position and insert
		else {
			ListNode temp = head;
			for (int i = 1; i < position; i += 1) {
				temp = temp.getNext();
			}
			ListNode newNode = new ListNode(data);
			newNode.setNext(temp.getNext()); // is this same as newNode.next = temp.next; ?
			temp.setNext(newNode);
		}
		length += 1;
	}

//Remove and return the node at the head of the list..
	public synchronized ListNode removeNodeAtHead() {
		ListNode node = head;
		if (node != null) {
			head = node.getNext();
			node.setNext(null); // why set to null?
		}
		return node;
	}

//Remove and return the node at the end of the list..	
	public synchronized ListNode removeNodeAtEnd() {
		if (head == null) {
			return null;
		}
		ListNode p = head, q = null, next = head.getNext();
		if (next == null) {
			head = null;
			return p;
		}
		while ((next = p.getNext()) != null) { // is this loop same as -> for(p=head;next.getNext()!=null;p.getNext())
			q = p;
			p = next;
		}
		q.setNext(null);
		return p;

	}

//Remove a node matching the speicified node from the list..
	public synchronized void removeMatched(ListNode node) {
		ListNode p = head, q = null;
		if (node.getNext() == null) {
			head = node;
			head = null;
			length = 0;
		} else {
			while ((q = p.getNext()) != null) { // in book written as something else
				if (q.getNext().getNext() == node) {
					ListNode x, y;
					x = q.getNext();
					y = node.getNext();
					x.setNext(y);
					return;
				}
			}

		}
	}

//Remove the value at given position.
//If the position is less than 0, remove the value at position 0.
//If the position is greater than 0, remove the value at the last position
	public synchronized void remove(int position) {
	
	//fix position..
		if(position<0)
			position=0;
		else if(position>=length)
			position = length-1;
		
		if(head==null)
			return;
		if(position==0)
			head = head.getNext();
		else {
			ListNode p,q = null;
			int length = 0;
			for(p=head;length<=position;length++) {
				
				if(length==position-1) {
					q.setNext(q.getNext().getNext());
				}else if(length==position) {
					q=null;
				}
				q = p.getNext();
			}
			length-=1;
		}
	}
	
//Return a String represnetation of this collection, in the form of ["str1","str2",...]
	public String toString() {
		String result="[";
		if(head==null)
			return "]";
		
		result = result + head.getData();
		ListNode temp = head.getNext();
		
		while(temp!=null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}
	
//Return the current length of the list..
	public int length() {
		return length;
	}
	
//Find the position of the first value that is equal to a given value..
//The equals method is used to determine equality
	public int getPosition(int data) {
	//go looking for the data..	
		ListNode temp = head;
		int pos = 0;
		
		while(temp!=null) {
			if(temp.getData()==data) {
				return pos;
			}
			pos +=1;
			temp = temp.getNext();
		}
	//else return some large value..
		return Integer.MIN_VALUE;
	}
	
	public void clearList() {
		head=null;
		length=0;
	}
	
}
