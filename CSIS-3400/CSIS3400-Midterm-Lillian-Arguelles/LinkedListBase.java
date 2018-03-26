/**
 * @version 1.0 03/02/17
 * 
 */
public class LinkedListBase {

	protected Node head;
	protected Node tail;
	
	class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	public void insertHead(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		if (tail == null)
			// if this is the first link, update the tail as well
			tail = newNode;
		// update the head
		head = newNode;
	}
	
	public void insertTail(int data) {
		Node newNode = new Node(data);
		if (tail == null)
			// if this is the first link, update the head as well
			head = newNode;
		else
			// if there is a tail, point it at this the new tail
			tail.next = newNode;
		// update the tail
		tail = newNode;
	}
	
	public int removeHead() {
		if (head == null) {
			return 0;
		} else {
			Node oldHead = head;
			if (oldHead.next == null) {
				// if this is the only node, update the head and tail
				head = null;
				tail = null;
			} else
				// if there is a second node, make it the first
				head = head.next;
			// return the data that was at the head
			return oldHead.data;
		}
	}

}
