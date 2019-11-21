
public class SharkMemory {
	
	public int[] memArray;
	int availableStart;
	
	/**
	 * 
	 * @param m 		size of memory
	 * @param n		available start location
	 */
	SharkMemory(int m, int n){
		memArray = new int[m];
		availableStart = n;
	}
	
	/**
	 * WRITE
	 * sets data in primary storage (memArray)
	 *  at the location specified
	 *  TO USE:
	 *  		to set m[a] = b
	 *  		WRITE(a, b)
	 */
	public void WRITE(int location, int data) {
		// System.out.println("-- WRITE --");
		memArray[location] = data;
	}
	/**
	 * READ
	 * returns data from primary storage (memArray) at
	 * 	the location specified
	 *  TO USE:
	 *  		to get m[a]
	 *  		READ(a)
	 */
	public int READ(int location) {
		// System.out.println("-- READ --");
		return memArray[location];
	}
	/**
	 * calls prettyPrintArr function on memArray
	 */
	public void printMem() {
		prettyPrintArr(memArray);
	}
	
	/**
	* Prints a readable array of integers to the console.
	* Separates each in sets of 16 with spacing with 8 digits
	* and a number in front indicating the row number.
	* @param arr		array to print
	*/
	private void prettyPrintArr(int[] arr) {
		// print start line number
		System.out.print("00: ");
		// loop through array
		for(int i = 0, j = 1; i < arr.length; i++) {
			// print memory info
			System.out.printf(" %8d",arr[i]);
			// at end of group of 16, print new line and line number
			if ((i % 16 == 15) && (i < arr.length-1)) {
				System.out.println();
				System.out.printf("%02d: ", j);
				j++;
			}
		}
		// print end line
		System.out.println();
	}
}
