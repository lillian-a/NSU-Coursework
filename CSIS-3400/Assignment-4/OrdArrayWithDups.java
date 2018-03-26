

/**
 * @author Lillian Arguelles
 * @version 1.3 02/20/17
 * Copyright (c) Lillian Arguelles 2017
 *  
 */

public class OrdArrayWithDups {
		
	int BUFFER_SIZE;
	private int[] intArray;
	private int numberOfElements = 0;
	
	public OrdArrayWithDups(int size) {
		BUFFER_SIZE = size;
		intArray = new int[BUFFER_SIZE];
	}
	
	public void clear(){
		numberOfElements = 0;
	}
	
	public boolean find(int target){
		return locationOf(target) != -1;
	}
	
	public int findAll(int target) {
		int count = 0;
		for (int i = 0; i < numberOfElements; i++) {
			if (intArray[i] == target)
				count++;
		}
		return count;
	}
	
	public int findFirst(int target, int initialLocation){
		if(intArray[initialLocation-1] == target){
			initialLocation--;
		}
		return initialLocation;
	}
	
	public int getSize(){
		return intArray.length;
	}
	
	public int getNumberOfElements(){
		return numberOfElements;
	}
	
	public boolean insert(int value) {
		if (numberOfElements < intArray.length) {
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
	
	public boolean linearFind(int target) {
		return locationOfLinear(target) != -1;
	}
	
	public int locationOf(int target) {
		int lower = 0;
		int upper = numberOfElements - 1;
		int pivot;
		while(true) {
			pivot = (lower + upper ) / 2;
			if(intArray[pivot] == target) {
				return pivot;
			}
			else if (lower > upper)
				return -1;
			else if (intArray[pivot] < target)
				lower = pivot + 1;
			else
				upper = pivot - 1;
		}
	}
	
	public int locationOfLinear(int target) {
		for (int i = 0; i < numberOfElements; i++) {
			if (intArray[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean remove(int target) {
		int i = locationOf(target);
		if (i <= 0)
			return false;
		else{
			shiftDown(i);
			numberOfElements--;
			return true;
		}
	}
	
	public int removeAll(int target) {
		int count = 0;
		int i = locationOf(target);
		if (i <= 0){
			return 0;
		} else {
			i = findFirst(target, i);
			int j = findAll(target);
			System.out.println(i+" "+j);
			for( count = 0 ; j > 0; j--, count++){
				shiftDown(i);
				numberOfElements--;
			}
		}
		return count;
	}
	
	public int removeAllLinear(int target) {
		int count = 0;
		while ( remove(target) ) {
			count++;
		};
		return count;
	}
	
	public void resize(int size) {
		int[] copy = new int[size];
		if (numberOfElements > size)
			numberOfElements = copy.length;
		for (int i = 0; i < numberOfElements; i++){
			copy[i] = intArray[i];
		}
		intArray = copy;
	}
	
	void shiftDown(int index) {
		for(int i = index+1; i < numberOfElements; i++)
			intArray[i-1] = intArray[i];
		
	}
	
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
		OrdArrayWithDups buf1 = new OrdArrayWithDups(5);
		assert1.isTrue(buf1.insert(1));
		assert1.isTrue(buf1.insert(2));
		assert1.isTrue(buf1.insert(2));
		assert1.isTrue(buf1.insert(2));
		assert1.isTrue(buf1.insert(3));
		System.out.println(buf1);
		// test that no overflow is allowed
		assert1.isFalse(buf1.insert(4));
		System.out.println(buf1);
		assert1.isTrue(buf1.remove(3));
		System.out.println(buf1);
		assert1.isTrue(buf1.insert(3));
		System.out.println(buf1);
		
		assert1.equals(buf1.findAll(2), 3);
		assert1.equals(buf1.removeAll(2), 3);
		System.out.println(buf1);
		assert1.isTrue(buf1.linearFind(1));
		assert1.equals(buf1.locationOf(1), 0);
		assert1.equals(buf1.locationOf(20), -1);
		assert1.isTrue(buf1.insert(1));
		assert1.isTrue(buf1.insert(2));
		System.out.println(buf1);
		buf1.resize(2);
		System.out.println(buf1);
		assert1.equals(buf1.getSize(), 2);
		assert1.equals(buf1.getNumberOfElements(), 2);
		buf1.clear();
		System.out.println(buf1);
		assert1.equals(buf1.getNumberOfElements(), 0);
		
		
	}
		

}

