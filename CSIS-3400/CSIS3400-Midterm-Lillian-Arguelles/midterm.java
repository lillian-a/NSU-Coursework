/**
 * @author Lillian Arguelles
 * @version 1.0 03/02/17
 * Copyright (c) Lillian Arguelles 2017
 */

// General data structure questions

/**
 * QUESTION 1
 * 
 * Stack Contents:  7 6 4 1
 * Stack Output:	3 2 5 8 9
 * 
 * QUESTION 2
 * 
 * Queue Contents:  9 8 7 6
 * Queue Output: 	1 2 3 4 5
 * 
 * QUESTION 3
 * 
 * Begin:	4, 7, 2, 1, 9, 5, 8, 6, 3
 * 			4, 2, 7, 1, 9, 5, 8, 6, 3
 * 			4, 2, 1, 7, 9, 5, 8, 6, 3
 *  		4, 2, 1, 7, 5, 9, 8, 6, 3
 *  		4, 2, 1, 7, 5, 8, 9, 6, 3
 *  		4, 2, 1, 7, 5, 8, 6, 9, 3
 * End:		4, 2, 1, 7, 5, 8, 6, 3, 9
 *  		
 */


public class midterm {

	public static void main(String[] args) {
		System.out.println("Testing Base:");
		LinkedListBase b = new LinkedListBase();
		b.insertHead(5);
		System.out.println(b.removeHead());
		b.insertTail(5);
		System.out.println(b.removeHead());
		
		System.out.println("Testing Queue:");
		testQueue();
		
		System.out.println("Testing Stack:");
		testStack();
		
		System.out.println("Testing Array Stack:");
		testArrayStack();
		
		System.out.println("Testing Display:");
		testLinkedDisplay();	
	}
	
	public static void testLinkedDisplay(){
		LinkedDisplay d = new LinkedDisplay();
		d.main();
	}
	
	public static void testArrayStack(){
		ArrayStack stk = new ArrayStack(5);
		int[] a = new int[5];
		int i;
		for(i = 0; i < 5; i++)
			a[i] = i;
		for(i = 0; i < 5; i++)
			stk.push(a[i]);
		for(i = 0; i < 5; i++)
			System.out.print(stk.pop());
		System.out.println();
	}
	
	public static void testQueue(){
		LinkedQueue q = new LinkedQueue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.print(q.dequeue());
		System.out.print(q.dequeue());
		q.enqueue(4);
		q.enqueue(5);
		System.out.print(q.dequeue());
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		System.out.print(q.dequeue());
		q.enqueue(9);
		System.out.print(q.dequeue());
		System.out.println();
	}
	
	public static void testStack(){
		LinkedStack s = new LinkedStack();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.print(s.pop());
		System.out.print(s.pop());
		s.push(4);
		s.push(5);
		System.out.print(s.pop());
		s.push(6);
		s.push(7);
		s.push(8);
		System.out.print(s.pop());
		s.push(9);
		System.out.print(s.pop());
		System.out.println();
	}

}
