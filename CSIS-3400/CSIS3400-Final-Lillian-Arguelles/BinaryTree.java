/**
 * @author Lillian Arguelles
 * @version 1.0 05/04/17
 * Copyright (c) Lillian Arguelles 2017
 */
public class BinaryTree {
	
	private Node root;
	
	private class Node {
		int value;
		Node leftChild;
		Node rightChild;
		public Node(int value) {
			this.value = value;
			leftChild = null;
			rightChild = null;
		}
	}
	
	public BinaryTree() {
		root = null;
	}
	
	public void insert (int value) {
		if (root == null) {
			root = new Node(value);
			return;
		} else {
			Node n = root;
			while (true) {
				if (value < n.value) {
					// value to be added is smaller than this value
					if (n.leftChild == null) {
						n.leftChild = new Node(value);
						return;
					} else
						n = n.leftChild;
				} else if (value > n.value) {
					// value to be added is bigger than this value
					if (n.rightChild == null) {
						n.rightChild = new Node(value);
						return;
					} else
						n = n.rightChild;
				} else
					// value to be added is the same as this value
					return;
			}
		}
	}
	
	public int reportDepth() {
		return reportDepth(root);
	}
	
	public int reportDepth(Node n) {
		if (n == null)
			return 0;
		int leftDepth = reportDepth(n.leftChild);
		int rightDepth = reportDepth(n.rightChild);
		if (leftDepth > rightDepth)
			return leftDepth + 1;
		else
			return rightDepth + 1;
	}
	
	public void printInOrder() {
		printInOrder(root);
		System.out.println();
	}
	
	public void printInOrder(Node n) {
		// check if tree is null
		if (n != null) {
			// print left
			printInOrder(n.leftChild);
			// print self
			System.out.print(n.value + " ");
			// print right
			printInOrder(n.rightChild);
		}
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(12);
		bt.insert(18);
		bt.insert(5);
		bt.insert(20);
		bt.insert(2);
		bt.insert(8);
		bt.insert(15);
		System.out.println(bt.reportDepth());
		bt.printInOrder();

	}

}
