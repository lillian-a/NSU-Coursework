import static org.junit.Assert.assertTrue;

/**
 * @author Lillian Arguelles
 * @version 1.2 01/24/17
 * Copyright (c) Lillian Arguelles 2017 
 */

public class ArrayBufferNoDups {
	
	int BUFFER_SIZE;
	private int[] intArray;
	private int numberOfElements = 0;
	
	public ArrayBufferNoDups(int size) {
		this.BUFFER_SIZE = size;
		this.intArray = new int[BUFFER_SIZE];
	}

	
	public boolean insert(int value) {
		if ((numberOfElements < intArray.length) && (!find(value))) {
			intArray[numberOfElements] = value;
			numberOfElements++;
			return true;
		} else
			return false;
	}
	
	public boolean fastRemove(int value) {
		if (find(value)) {
			int i = locationOf(value);
			if (i != numberOfElements-1) {
				intArray[i] = intArray[numberOfElements-1];
				numberOfElements--;
			} else
				numberOfElements--;
			return true;
		}
		return false;
	}	

	public void display() {
		if (numberOfElements > 0){
			for (int i = 0; i < numberOfElements; i++) {
				if (i !=numberOfElements-1)
					System.out.print(intArray[i]+",");
				else
					System.out.print(intArray[i]);
			}
		}
		System.out.println();
	}
	
	public int locationOf(int target) {
		for (int i = 0; i < numberOfElements; i++) {
			if (intArray[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean find(int target) {
		if (locationOf(target) == -1)
			return false;
		else
			return true;
		
	}
	
	public boolean stableRemove(int target) {
		if (find(target)) {
			int i = locationOf(target);
			if (i != numberOfElements-1) {
				for (int j = i; j < numberOfElements-1; j++) {
					intArray[j] = intArray[j+1];
				}
				numberOfElements--;
			} else
				numberOfElements--;
			return true;
		}
		else
			return false;
	}
	
	public static void main(String[] args) {
		Assert assert1 = new Assert();
		ArrayBufferNoDups buf1 = new ArrayBufferNoDups(5);
		
		assert1.isTrue(buf1.insert(0));
		assert1.isTrue(buf1.insert(1));
		assert1.isTrue(buf1.insert(2));
		assert1.isTrue(buf1.insert(3));
		buf1.display();
		
		// test that no duplicates are allowed
		assert1.isFalse(buf1.insert(3));
		buf1.display();
		
		assert1.isTrue(buf1.insert(4));
		buf1.display();
		
		// test that no overflow is allowed
		assert1.isFalse(buf1.insert(5));
		buf1.display();
		
		
		assert1.isTrue(buf1.fastRemove(0));
		buf1.display();
		
		assert1.isTrue(buf1.stableRemove(1));
		buf1.display();
		
		assert1.isTrue(buf1.find(2));
		buf1.display();
		
		assert1.equals(buf1.locationOf(2), 1);
		

	}
}

