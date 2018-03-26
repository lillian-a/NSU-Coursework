import static org.junit.Assert.assertTrue;

/**
 * @author Lillian Arguelles
 * @version 1.0 01/26/17
 * Copyright (c) Lillian Arguelles 2017 
 */

public class OrdArrayNoDups {

	int BUFFER_SIZE;
	private int[] intArray;
	private int numberOfElements = 0;
	
	public OrdArrayNoDups(int size) {
		this.BUFFER_SIZE = size;
		this.intArray = new int[BUFFER_SIZE];
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
				numberOfElements--;
				shiftDown(i);
			} else
				numberOfElements--;
			return true;
		}
		else
			return false;
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
	
	
	void shiftDown(int index) {
		for(int i = index; i < numberOfElements; i++)
			intArray[i] = intArray[i+1];	
	}
	
	void shiftUp(int index) {
		for(int i = numberOfElements; i > index; i--)
			intArray[i] = intArray[i-1];
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
		
		
		
		assert1.isTrue(buf1.stableRemove(1));
		System.out.println(buf1);
		
		assert1.isTrue(buf1.find(2));
		assert1.equals(buf1.locationOf(2), 1);
		

	}
}
