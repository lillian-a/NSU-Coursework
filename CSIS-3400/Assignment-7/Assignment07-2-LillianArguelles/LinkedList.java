public class LinkedList {
	protected Link head;
	protected Link tail;
	class Link {
		String name;
		Link next;
		Link(String name) {
			this.name = name;
			next = null;
		}
	}
	public boolean isEmpty() {
		return head == null;
	}
	public void insertHead(String name) {
		Link newLinkBeingAdded = new Link(name);
		if (head == null)
			tail = newLinkBeingAdded;
		else
		    newLinkBeingAdded.next = head;
		head = newLinkBeingAdded;
	}
}