/**
 * @author Lillian Arguelles
 * @version 1.0 03/02/17
 * Copyright (c) Lillian Arguelles 2017
 */

public class LinkedStack extends LinkedListBase {
	
	LinkedListBase b;
	
	public LinkedStack() {
		b = new LinkedListBase();
	}

	public void push(int data) {
		b.insertTail(data);
	}
	
	public int pop() {
		return b.removeHead();
	}

}
