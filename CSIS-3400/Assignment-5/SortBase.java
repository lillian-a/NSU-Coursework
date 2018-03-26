/**
* @author Michael Van Hilst 
* @version 1.0 02/01/17
*
*/
public abstract class SortBase {
	protected int[] array;
	protected int numberOfElements = 0;
	
	public SortBase(int size) {
		array = new int[size];
		numberOfElements = 0;
	}
	public boolean insert(int value) {
		if (numberOfElements < array.length) {
			// insert the new value at the end
			array[numberOfElements] = value;
			numberOfElements++;
			return true;
		} else
			return false;
	}
	
	public void fillRandom(int min, int max) {
		// clear the buffer
		numberOfElements = 0;
		// integer range is inclusive of min and max
		int range = 1 + max - min;
		for (int i = 0; i < array.length; i++)
			insert((int) Math.floor(min + Math.random() * range));
	}
	
	public void shuffle() {
		// swap each element with a randomly chosen element
		for (int i = 0; i < numberOfElements; i++) {
		// randomly choose an element with which to swap
		int index = (int) (Math.random() * numberOfElements);
		// swap the current element with the random element
		int temp = array[i];
		array[i] = array[index];
		array[index] = temp;
		}
	}
	
	public String toString() {
		String returnString = "";
		for (int i = 0; i < array.length; i++) {
			if (i > 0 && (i % 10) == 0)
				returnString += "\n";
			returnString += String.format("%7d", array[i]);
		}
		return returnString;
	}
	public void insertionSort() {
		// leave first element in place, start inserting with second
		for (int i = 1; i < array.length; i++) {
			// next element to insert
			int value = array[i];
			// region in which to insert is up to this point (i)
			int j;
			for (j = i; j > 0 && array[j - 1] > value; j--)
				// shift up until we reach the point to insert
				array[j] = array[j - 1];
				// loop stopped with j at the insertion point
				array[j] = value;
		}
	}
	
	public abstract void bubbleSort();
	
	public abstract void selectionSort();
		
	public static void main(String[] args) {
		SortBase test = new SortSub(35);
		test.fillRandom(1, 200);
		System.out.println(test + " random\n");
		test.insertionSort();
		System.out.println(test + " insertion sorted\n"); test.shuffle();
		System.out.println(test + " shuffled\n"); test.bubbleSort();
		System.out.println(test + " bubble sorted\n"); test.shuffle();
		System.out.println(test + " shuffled\n"); test.selectionSort();
		System.out.println(test + " selection sorted");
	}
	
	
}