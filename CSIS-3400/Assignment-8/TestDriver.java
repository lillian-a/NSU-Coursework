
public class TestDriver {

	
	public static void main(String[] args) {
		testOne();
		testTwo();
		testThree();
	}
	public static void testOne() {
		System.out.println("TEST ONE - INITIAL SMALL TEST WITH 6 VALUES");
		ChainedHashTable test = new ChainedHashTable(7);
		test.insert(12);
		test.insert(3271);
		test.insert(262134);
		test.insert(89567);
		test.insert(984472);
		test.insert(86372);
		System.out.println("984472 found " + test.find(984472));
		System.out.println("89566 not found " + test.find(89566));
	}
	
	public static void testTwo() {
		System.out.println("TEST TWO - BIGGER TEST LOADING 1000 VALUES");
		final int TEST_SIZE = 1000;
		final int MAX_VAL = 1000000;
		int array[] = new int[TEST_SIZE];
		for (int i = 0; i < array.length; i++)
			array[i] = (int) (Math.random() * MAX_VAL);
		ChainedHashTable test = new ChainedHashTable(TEST_SIZE * 2 - 1);
		for (int i = 0; i < array.length; i++)
			test.insert(array[i]);
		for (int i = 0; i < TEST_SIZE; i += TEST_SIZE / 10) {
			System.out.print(array[i] + 1 + " not found " + test.find(array[i] + 1));
			System.out.print(", " + array[i] + " found " + test.find(array[i]) + ", ");
			test.remove(array[i]);
			System.out.println(array[i] + " removed now " + test.find(array[i]));
		}
		// System.out.println("Longest chain is: " + test.getLengthOfLongestLinkedListInTheHashTable());
		System.out.println("Longest chain is: " + test.getLengthOfLongestListInTheHashTable());
	}
		
	public static void testThree() {
		System.out.println("TEST THREE - USING POOL FOR HALF THE NODES");
		final int TEST_SIZE = 1000;
		final int MAX_VAL = 1000000;
		int array[] = new int[TEST_SIZE];
		for (int i = 0; i < array.length; i++)
			array[i] = (int) (Math.random() * MAX_VAL);
		ChainedHashTable test = new ChainedHashTable(TEST_SIZE * 2 - 1);
		// create a bunch of nodes and then remove them to load up the pool
		for (int i = 0; i < TEST_SIZE / 2; i++) {
			test.insert(i);
		}
		for (int i = 0; i < TEST_SIZE / 2; i++) {
			test.remove(i); 
		}
		for (int i = 0; i < array.length; i++)
			test.insert(array[i]);
		for (int i = 0; i < TEST_SIZE; i += TEST_SIZE / 10) {
			System.out.print(array[i] + 1 + " not found " + test.find(array[i] + 1));
			System.out.print(", " + array[i] + " found " + test.find(array[i]) + ", ");
			test.remove(array[i]);
			System.out.println(array[i] + " removed now " + test.find(array[i]));
		}
		// System.out.println("Longest chain is: " + test.getLengthOfLongestLinkedListInTheHashTable());
		System.out.println("Longest chain is: " + test.getLengthOfLongestListInTheHashTable());
	}

}
