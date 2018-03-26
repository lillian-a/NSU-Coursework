/**
 * @author Lillian Arguelles
 * @version 1.0 05/04/17
 * Copyright (c) Lillian Arguelles 2017
 */

public class LinkedListStack {
	// head of stack
	StackNode head = null;
	
	// Stack Node class
	class StackNode {
		double value;
		StackNode next;
		
		StackNode(double value, StackNode next) {
			// set value and next
			this.value = value;
			this.next = next;
		}
	}
	
	// push value into stack
	public void push(double value) {
		// set head to new stack node, set value, and set next to old head
		head = new StackNode(value, head);
	}
	// pop out head of stack
	public double pop() {
		// get value of head to return (before losing access to it)
		double returnValue = head.value;
		// set head to head's next
		head = head.next;
		// return old head's value
		return returnValue;
	}
	
	
	public static void main(String[] args) {
		
		Double[] array = { 2.3, 4.6, 6.3, 7.1, 9.5, 23.6, 26.2, 12.4 };
		// create linked list stack
		LinkedListStack stk = new LinkedListStack();
		
		// print array before reversing
		System.out.print("Before: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		
		// PUSH value from array into stack
		for(int i = 0; i < array.length; i++)
			stk.push(array[i]);
		// POP value from stack into array
		for(int i = 0; i < array.length; i++)
			array[i] = stk.pop();
		// print array after reversing
		System.out.print("After: ");
		for(int i=0; i<array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		
	}
}
