/**
 * @author Lillian Arguelles
 * @version 1.0 03/02/17
 * Copyright (c) Lillian Arguelles 2017
 */

public class LinkedQueue extends LinkedListBase {

	LinkedListBase b;
	
	public LinkedQueue() {
		b = new LinkedListBase();
	}
	
	public void enqueue(int data) {
		b.insertHead(data);
	}
	
	public int dequeue() {
		return b.removeHead();
	}

}
