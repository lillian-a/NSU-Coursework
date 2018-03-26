
/**
 * @author Michael Van Hilst
 * @version 1.0 November 14, 2015
 *
 */

	public class Assert {
		public static void isTrue(boolean actual) { 
			if (actual)
	            System.out.println("OK");
	        else
	        	System.out.println("FAIL");
		}
		public static void isFalse(boolean actual) {
			if (actual)
				System.out.println("FAIL");
			else
	            System.out.println("OK");
		}
		public static void equals(int actual, int expected) {
			if (actual == expected)
	            System.out.println("OK");
	        else
	        	System.out.println("FAIL");
		}
		public static void equals(String actual, String expected) {
			if (actual.equals(expected))
				System.out.println("OK");
			else
				System.out.println("FAIL");
		}
	}