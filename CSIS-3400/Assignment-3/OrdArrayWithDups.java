import static org.junit.Assert.assertTrue;

/**
 * @author Lillian Arguelles
 * @version 1.2 01/26/17
 * Copyright (c) Lillian Arguelles 2017
 *  
 */

public class OrdArrayWithDups {
		
	int BUFFER_SIZE;
	private int[] intArray;
	private int numberOfElements = 0;
	
	public OrdArrayWithDups(int size) {
		this.BUFFER_SIZE = size;
		this.intArray = new int[BUFFER_SIZE];
	}
	
	public boolean insert(int value) {
		if (numberOfElements < intArray.length) {
			int i;
			for(i = 0; i < numberOfElements; i++)
				if(intArray[i] > value)
					break;
			shiftUp(i);
			intArray[numberOfElements] = value;
			numberOfElements++;
			return true;
		} else
			return false;
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
				shiftDown(i);
				numberOfElements--;
				
			} else
				numberOfElements--;
			return true;
		}
		else
			return false;
		
	}
	
	public int findAll(int target) {
		int count = 0;
		for (int i = 0; i < numberOfElements; i++) {
			if (intArray[i] == target)
				count++;
		}
		return count;
	}
	
	public int stableRemoveAll(int target) {
		int count = 0;
		while ( stableRemove(target) ) {
			count++;
		}
		return count;
	}
	
	
	void shiftUp(int index) {
		for(int i = numberOfElements; i > index; i--)
			intArray[i] = intArray[i-1];
	}
	
	void shiftDown(int index) {
		for(int i = index+1; i < numberOfElements; i++)
			intArray[i-1] = intArray[i];
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
		
		assert1.isTrue(buf1.stableRemove(3));
		System.out.println(buf1);
		assert1.isTrue(buf1.insert(3));
		System.out.println(buf1);
		
		assert1.equals(buf1.findAll(2), 3);
		assert1.equals(buf1.stableRemoveAll(2), 3);
		System.out.println(buf1);
		assert1.isTrue(buf1.find(1));
		assert1.equals(buf1.locationOf(1), 0);
		
		
	}
		

}

