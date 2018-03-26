/**
 * @author Lillian Arguelles
 * @version 1.0 03/02/17
 * Copyright (c) Lillian Arguelles 2017
 */
public class ArrayStack {

	int[] stack;
	int numberOfElements;
	
	public ArrayStack(int size) {
		stack = new int[size];
		numberOfElements = -1;
	}
	
	public void push(int value) {
		if (numberOfElements < stack.length){
			numberOfElements++;
			stack[numberOfElements] = value;
			
		}
	}
	
	public int pop() {
		int i;
		if (numberOfElements > -1){
			i = stack[numberOfElements];
			numberOfElements--;
			return i;
		} else
			return 0;
	}

}
