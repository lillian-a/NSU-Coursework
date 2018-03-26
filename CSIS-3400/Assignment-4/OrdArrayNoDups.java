
/**
 * @author Lillian Arguelles
 * @version 1.3 02/20/17
 * Copyright (c) Lillian Arguelles 2017 
 */

public class OrdArrayNoDups {

	int BUFFER_SIZE;
	private int[] intArray;
	private int numberOfElements = 0;
	
	public OrdArrayNoDups(int size) {
		BUFFER_SIZE = size;
		intArray = new int[BUFFER_SIZE];
	}
	
	public void clear(){
		numberOfElements = 0;
	}
	
	public int getSize(){
		return intArray.length;
	}
	
	public int getNumberOfElements(){
		return numberOfElements;
	}

	public boolean insert(int value) {
		if ((numberOfElements < intArray.length) && (!find(value))) {
			int i;
			for(i = 0; i < numberOfElements; i++)
				if(intArray[i] > value)
					break;
			shiftUp(i);
			intArray[i] = value;
			numberOfElements++;
			return true;
		} else
			return false;
	}
	
	public boolean find(int target) {
		return locationOf(target) != -1;
	}
	
	public boolean linearfind(int target) {
		return locationOfLinear(target) != -1;
	}
	
	public int locationOfLinear(int target) {
		for (int i = 0; i < numberOfElements; i++) {
			if (intArray[i] == target) {
				return i;
			}
		}
		return -1;
	}
		
	public int locationOf(int target) {
		int lower = 0;
		int upper = numberOfElements - 1;
		int pivot;
		for(;;) {
			pivot = (lower + upper ) / 2;
			if(intArray[pivot] == target)
				return pivot;
			else if (lower > upper)
				return -1;
			else if (intArray[pivot] < target)
				lower = pivot + 1;
			else
				upper = pivot - 1;
		}
	}
	
	public boolean remove(int target) {
		if (find(target)) {
			int i = locationOf(target);
			if (i != numberOfElements-1) {
				numberOfElements--;
				shiftDown(i);
			} else
				numberOfElements--;
			return true;
		}
		else
			return false;
	}
	
	public void resize(int size) {
		int[] copy = new int[size];
		if (numberOfElements > size)
			numberOfElements = copy.length;
		for (int i = 0; i < numberOfElements; i++)
			copy[i] = intArray[i];

		intArray = copy;
	}
	
	// moving elements from right to left - for deleting
	void shiftDown(int index) {
		for(int i = index; i < numberOfElements; i++)
			intArray[i] = intArray[i+1];	
	}
	
	// moving elements from left to right - for inserting
	void shiftUp(int index) {
		for(int i = numberOfElements; i > index; i--)
			intArray[i] = intArray[i-1];
	}
		
	@Override
	public String toString(){
		String s = "{";
		if(numberOfElements > 0)
			for(int i = 0; i < numberOfElements; i++)
				if (i !=numberOfElements-1)
					s += intArray[i] + ", ";
				else
					s += intArray[i];
		s += "}";
		return s;
	}
	
	public static void main(String[] args) {
		Assert assert1 = new Assert();
		OrdArrayNoDups buf1 = new OrdArrayNoDups(5);
		
		assert1.isTrue(buf1.insert(3));
		System.out.println(buf1);
		assert1.isTrue(buf1.insert(1));
		System.out.println(buf1);
		assert1.isTrue(buf1.insert(2));
		System.out.println(buf1);
		assert1.isTrue(buf1.insert(0));
		System.out.println(buf1);
		
		// test that no duplicates are allowed
		assert1.isFalse(buf1.insert(3));
		System.out.println(buf1);
		
		assert1.isTrue(buf1.insert(4));
		System.out.println(buf1);
		
		// test that no overflow is allowed
		assert1.isFalse(buf1.insert(5));
		System.out.println(buf1);
		
		
		
		assert1.isTrue(buf1.remove(1));
		System.out.println(buf1);
		
		assert1.isTrue(buf1.find(2));
		assert1.equals(buf1.locationOf(2), 1);
		
		assert1.isTrue(buf1.insert(1));
		System.out.println(buf1);
		buf1.resize(3);
		System.out.println(buf1);
		System.out.println(buf1.getSize());
		System.out.println(buf1.getNumberOfElements());
		
		

	}
}
