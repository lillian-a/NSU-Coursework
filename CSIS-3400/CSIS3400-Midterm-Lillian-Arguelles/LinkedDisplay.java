/**
 * @author Lillian Arguelles
 * @version 1.0 03/02/17
 * Copyright (c) Lillian Arguelles 2017
 */

public class LinkedDisplay extends LinkedListBase {

	LinkedListBase b;
	
	public LinkedDisplay() {
		b = new LinkedListBase();
	}
	
	public void display() {
		Node n = b.head;
		while(n != tail){
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	
	public void displayReversed() {
		printRecursively(b.head);
	}
	
	public void printRecursively(Node n) {
		if(n != null){
			printRecursively(n.next);
			System.out.print(n.data + " ");
		}
	}	
	
	public void main() {
		System.out.println("Display Forward:");
		b.insertHead(1);
		b.insertHead(2);
		b.insertHead(3);
		b.insertHead(4);
		b.insertHead(5);
		display();
		System.out.println("Display Reverse:");
		displayReversed();
		
	}
	

}
