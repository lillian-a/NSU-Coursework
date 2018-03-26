
/**
 * @author Lillian Arguelles
 * @version 1.0 02/23/17
 * Copyright (c) Lillian Arguelles 2017
 */
public class SortSub extends SortBase {

	/**
	 * @param size
	 */
	public SortSub(int size) {
		super(size);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see SortBase#bubbleSort()
	 * has a bool flag set to true if swap found, so loops again
	 */
	@Override
	public void bubbleSort() {
		boolean swapOccured = true;
		int i;
		while (swapOccured){
			swapOccured = false;
	        for(i = 0; i < numberOfElements - 1; i++) {
	        	//find a swap
	        	if( array[ i ] > array[ i + 1 ] ) {
	            	// swap and set flag to true
	        		swapOccured = true;
	            	int temp = array[ i ];
	            	array[ i ] = array[ i + 1 ];
	            	array[ i + 1 ] = temp;
	            }
	         }
		}
	}
	
	public void bubbleSortBook() {
		int out, in;
		for(out = numberOfElements - 1; out > 1; out--){
			// outer loop (backward)
			for(in = 0; in < out; in++) {
				// inner loop (forward)
				if( array[ in ] > array[ in + 1 ] ){
					// swap elements
					int temp = array[ in ];
					array[ in ] = array[ in + 1 ];
					array[ in + 1 ] = temp;
				}
			}
		}     
	}

	/* (non-Javadoc)
	 * @see SortBase#selectionSort()
	 */
	@Override
	public void selectionSort() {
		int minNum, j;
		
		for( int i = 0; i < numberOfElements - 1; i++) {
			
			// set minimum number default
			minNum = i;
			
			// find smallest number
			for( j = i + 1; j < numberOfElements; j++ ) {
				if( array[j] < array[minNum] ) {
					minNum = j;
				}
			}
			// swap
			if (minNum != i){
				int temp = array[i];
				array[i] = array[minNum];
				array[minNum] = temp;
			}
			
		}

	}

}
