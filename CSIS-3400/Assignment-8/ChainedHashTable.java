public class ChainedHashTable {
	private LinkNode tableOfHeads[];
	private LinkNode headOfPool;
	private int count = 0;
	
	// inner class is private to it can't be used outside ChainedHashTable
	private class LinkNode {
		int value;
	    LinkNode next;
	    
	    // %%% STOP USING THIS CONSTRUCTOR
	    LinkNode(int value) {
	    	this.value = value;
	    	next = null;
	    }
	    
	    // *** CHANGE *** 04/18/17 - added inner lines
	    LinkNode(int value, LinkNode next) {
	    	// %%% IMPLEMENT AND USE THIS CONSTRUCTOR
	    	this.value = value;
	    	this.next = next;
	    }
	}
	
	public ChainedHashTable(int tableSize) {
		tableOfHeads = new LinkNode[tableSize];
		headOfPool = null;
		count = 0;
	}
	
	private int hash(int value) {
		if (value < 0)
			// make negative values positive so hash is positive
			value = -value;
		return value % tableOfHeads.length;
	}
	
	// *** CHANGE *** 04/18/17 - added inner lines
	// *** CHANGE *** 04/27/17 - adjusted in if loop
	private LinkNode getNewNode(int value, LinkNode next) {
		// %%% IMPLEMENT AND USE THIS VERSION OF getNewNode
		//return null;
		if (headOfPool != null) {
//			// remove node from pool head and return it as the new node
			LinkNode newNode = headOfPool;
			newNode = new LinkNode(value, next);
			headOfPool = headOfPool.next;
//			newNode.value = value;
//			newNode.next = null;	// original line 48
//			newNode.next = next;
			return newNode;
	     } else
//	    	 // just create a new node with "new"
//	    	 // return new LinkNode(value);
	    	 return new LinkNode(value, next);
	}
	
	// %%% STOP USING THIS VERSION OF getNewNode
	private LinkNode getNewNode(int value) {
		if (headOfPool != null) {
			// remove node from pool head and return it as the new node
			LinkNode newNode = headOfPool;
			headOfPool = headOfPool.next;
			newNode.value = value;
			newNode.next = null;
			return newNode;
	     } else
	    	 // just create a new node with "new"
	    	 return new LinkNode(value);
	}
	
	// hang on to old nodes so they can be reused when a new node is needed
	private void releaseNodeToPool(LinkNode garbageNode) {
		// insert this node at head of pool's linked list
	    garbageNode.next = headOfPool;
	    headOfPool = garbageNode;
	}
	
	// put a new value in the chained hash table
	public void insert(int value) {
		int index = hash(value);
		// check for duplicates, do nothing if already here
		if (walkListToFindValue(value, tableOfHeads[index]))
			return;
		// insert Node with new value at head of linked list
		// %%% USE NEW getNewNode TO REDUCE NEXT THREE LINES DOWN TO ONE
		// *** CHANGE *** 04/18/17 - commented out below 3 lines and added the 4th
		// LinkNode newNode = getNewNode(value);
		// newNode.next = tableOfHeads[index];
		// tableOfHeads[index] = newNode;
		tableOfHeads[index] = getNewNode(value, tableOfHeads[index]);
		// increment the count of values in the hash table
		count++;
	}
	
	public int getCount() {
		return count;
	}
	
	// %%% REDUCE THIS METHOD TO A SINGLE LINE
	public boolean find(int value) {
		//LinkNode head;
		//for(head = tableOfHeads[hash(value)]; head != null && !walkListToFindValue(value, head); head = head.next);
		//walkListToFindValue(value, new LinkNode());
		//return head != null;
		return walkListToFindValue(value, tableOfHeads[hash(value)]);
		// where to look in the array of linked lists
		// int index = hash(value);
		// get that linked list
		// LinkNode head = tableOfHeads[index];
		// walk the linked list and return true if it is there
		// boolean result = walkListToFindValue(value, head);
		// return result;
		
	}
	
	// walk this linked list looking for the value being sought
	private boolean walkListToFindValue(int value, LinkNode node) {
		while (node != null) {
			// while the current node is not null, check it out
			if (node.value == value)
				return true;
			else
				// if not this one, go on to the next
				node = node.next;
		}
		// if we reached null, we didn't find the value in any node
		return false;
	}
	
	// remove value from the data structure
	// return true if found and removed, else return false
	public boolean remove(int value) {
		// where to look in the array of linked lists
		int index = hash(value);
		LinkNode nodeAtHead = tableOfHeads[index];
		// if there's nothing there, we didn't find it
		if (nodeAtHead == null) {
			return false;
		// if head node is the one we want
		} else if (nodeAtHead.value == value) {
			// if head node has value, remove it by pointing head beyond it
			tableOfHeads[index] = nodeAtHead.next;
			releaseNodeToPool(nodeAtHead);
			return true;
		} else {
			// check rest of linked list (if any)
			return removeFromRemainingLinkedList(nodeAtHead, value);
		}
	}
	
	// walk the list from an initial parent, remove value node if we find it
	private boolean removeFromRemainingLinkedList(LinkNode parent, int value) {
		while (parent.next != null) {
			LinkNode node = parent.next;
			if (node.value == value) {
				parent.next = node.next;
				releaseNodeToPool(node);
				return true;
			}
		    parent = node;
		}
		return false;
	}
	
	// %%% IMPLEMENT THIS METHOD
	// *** CHANGE *** 04/18/17 - added inner lines
	public int getLengthOfLongestListInTheHashTable() {
		int longestListLength = 0;
		int num = 0;
		
		for(int i = 0; i < tableOfHeads.length; i++) {
			
			LinkNode node = tableOfHeads[i];
			while(node != null){
				num++;
				node = node.next;
			}
			if( num > longestListLength)
				longestListLength = num;	
		}
		
		return longestListLength;
	}
	

}
