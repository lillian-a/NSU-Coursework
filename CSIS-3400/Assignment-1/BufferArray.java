public class BufferArray {
	private static int BUFFER_SIZE = 8;
	private int intArray[] = new int[BUFFER_SIZE];
	private int numberOfElements = 0;

	
	public boolean insert(int value) {
		if (numberOfElements < intArray.length) {
			intArray[numberOfElements] = value;
			numberOfElements++;
			return true;
		} else
			return false;
	}
	
	public boolean remove(int value) {
		if (find(value)) {
			int i = locationOf(value);
			if (i != numberOfElements-1) {
				intArray[i] = intArray[numberOfElements-1];
				numberOfElements--;
			} else
				numberOfElements--;
			
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
	
	public boolean stableRemove(int target){
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
	

}
